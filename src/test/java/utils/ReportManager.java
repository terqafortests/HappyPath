package utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportManager {

	private static Map<Long, ExtentTest> testThread = new HashMap<Long, ExtentTest>();
	private static ExtentReports extent;

	private synchronized static ExtentReports getInstance() {
		if (extent == null) {
			extent = new ExtentReports("./resources/reports/Report.html", true);
		}
		return extent;
	}

	public synchronized static Map<Long, ExtentTest> startTest(String testName, String testDescription,
			String... groups) {
		Long threadID = Thread.currentThread().getId();

		ExtentTest test = getInstance().startTest(testName, testDescription);
		test.assignCategory(groups);
		testThread.put(threadID, test);
		return testThread;
	}

	public synchronized static ExtentTest Logger() {
		ExtentTest logger = null;
		Long threadID = Thread.currentThread().getId();
		if (testThread.containsKey(threadID)) {
			logger = testThread.get(threadID);
		}
		return logger;
	}

	public synchronized static void closeTest() {
		getInstance().endTest(Logger());
	}

	public synchronized static void closeReporter() {
		getInstance().flush();
	}

	public static String getTestName(Method m) {
		String testName = null;
		String address = null;
		String[] testGroups = m.getAnnotation(Test.class).groups();
		for (int i = 0; i < testGroups.length; i++) {
			if (testGroups[i].startsWith("http")) {
				address = testGroups[i];
			}
		}
		if (address != null) {
			testName = "<a href=" + "\"" + address + "\""
					+ "target=_blank alt=This test is linked to test case. Click to open it>"
					+ m.getAnnotation(Test.class).testName() + "</a>";
		} else {
			testName = m.getAnnotation(Test.class).testName();
		}

		if (testName == null || testName.equals("")) {
			testName = m.getName();
		}
		return testName;
	}

	private String getTestDescription(Method m) {
		String testDescription = null;
		testDescription = m.getAnnotation(Test.class).description();
		if (testDescription == null || testDescription == "") {
			testDescription = "";
		}
		return testDescription;
	}

	private static String getTestGroups(Method m) {
		String b = "";
		String[] testGroups = m.getAnnotation(Test.class).groups();
		try {
			for (int i = 0; i < testGroups.length; i++) {
				if (testGroups[i].startsWith("http")) {
					continue;
				} else {
					b = b + " " + testGroups[i] + "; ";
				}

			}
			b = b.substring(0, b.length() - 2);
		} catch (Exception e) {
		}
		return b;
	}

	@BeforeMethod
	public void startReporting(Method m) {
		startTest(getTestName(m), getTestDescription(m), WebBrowser.getCurrentBrowserName(), getTestGroups(m));
	}

	@AfterMethod
	public void stopReporting() {
		closeTest();
	}

}