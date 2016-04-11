package testNGlisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import com.relevantcodes.extentreports.LogStatus;
import utils.MainClass;

public class SkipNextTestsOnTestFail extends MainClass implements ITestListener {

	private boolean b = true;

	@Override
	public void onTestStart(ITestResult result) {
		if (b == false) {
			Logger().log(LogStatus.SKIP, "Skipped because one of the tests has FAILED");
			throw new SkipException("Skipped");
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		b = true;

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(
				"Invoked SkipNextTestsOnTestFail listener: previous test has FAILED. Next tests will be skipped");
		b = false;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
