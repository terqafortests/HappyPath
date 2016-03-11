package banner.testNGTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import salesforce.pages.LoginPage;
import salesforce.testNGTests.ConvertLeadToStudentTest;
import salesforce.testNGTests.SubmitApplicationTest;
import utils.CMD;
import utils.ExcelUtils;
import utils.MainClass;

public class ProcessStudentInBannerTest extends MainClass {

	public static String uname;
	public static String pass;

	@Test(testName = "Process student in Banner", description = "Verifies if creds were created")
	public void processStudentInBanner() throws Exception {
		ExcelUtils.setExcelFile("D://UFTworkspace//HappyPath//BannerFlow//Default.xls", "WorkFlow");
		ExcelUtils.setCellData(SubmitApplicationTest.bannerID, 1, 0);
		CMD.RunUftTest("BannerFlow");
		getPage("Sales Force Address");
		LoginPage.login("uname", "pass");
		System.out.println("Address " + ConvertLeadToStudentTest.address);
		sleepFor(2000);
		getPage(ConvertLeadToStudentTest.address);
		uname = getElementText(By.xpath("//td[text()='Username']/following-sibling::*//div"));
		pass = getElementText(By.xpath("//td[text()='Password']/following-sibling::*//div"));
		assertTrue("Verifying if username and password were created in Sales Force",
				uname.length() > 1 && pass.length() == 8);
	}
}
