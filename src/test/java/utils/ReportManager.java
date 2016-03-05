package utils;

import java.util.HashMap;
import java.util.Map;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportManager {

	private static Map<Long, ExtentTest> testThread = new HashMap<Long, ExtentTest>();
	private static ExtentReports extent;

	private synchronized static ExtentReports getInstance() {
		if (extent == null) {
			extent = new ExtentReports("./Report.html", false);
		}
		return extent;
	}

	public synchronized static Map<Long, ExtentTest> startTest(String testName, String testDescription) {
		Long threadID = Thread.currentThread().getId();
		ExtentTest test = getInstance().startTest(testName, testDescription);
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

}