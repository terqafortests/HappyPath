package salesforce.testNGTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.MainClass;

public class SubmitApplicationTest extends MainClass {
	
	
	public static String bannerID;

	@Test(testName = "Submit application", description = "Verifies if application was submitted")
	public void submitApplicationTest() {
		clickOn(By.xpath("//td[@id='topButtonRow']/input[@title='Submit Application']"), "Submit Application Button");
		sleepFor(6000);
		getPage(ConvertLeadToStudentTest.address);
		bannerID = getElementText(By.xpath("//td[text()='Banner ID']/following-sibling::td[1]//div"));
		System.out.println(bannerID);
		assertTrue("Verifying if application was submitted(Banner ID was created)", bannerID.length() == 9);
	}
	
}
