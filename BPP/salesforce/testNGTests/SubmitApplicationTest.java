package salesforce.testNGTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utils.MainClass;

public class SubmitApplicationTest extends MainClass {

	public static String bannerID;

	@Test(testName = "Submit application", description = "Verifies if application was submitted", groups = {
			"Happy Path" })
	public void submitApplicationTest() {
		try {
			clickOn(By.xpath("//td[@id='topButtonRow']/input[@title='Submit Application']"), "Submit Application Button");
			getPage(ConvertLeadToStudentTest.address);
			bannerID = getElementText(By.xpath("//td[text()='Banner ID']/following-sibling::td[1]//div"));
			System.out.println(bannerID);
			assertTrue("Verifying if application was submitted(Banner ID was created)", bannerID.length() == 9);			
		} catch (Exception e) {
            waitForAlert();
			Logger().log(LogStatus.FAIL, "Possibly duplicate leads");
			Assert.fail(e.getCause().toString());
		}
	}

}
