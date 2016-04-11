package salesforce.testNGTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import salesforce.pages.LoginPage;
import utils.MainClass;

public class GetCredentialsForStudentTest extends MainClass {

	public static String uname;
	public static String pass;

	@Test(testName = "Get credentials for student", description = "Verifies if creds were created", groups = {
			"Happy Path" })
	public void getCredentialsForStudentTest() {
		getPage("");
		LoginPage.login("", "");
		System.out.println("Address " + ConvertLeadToStudentTest.address);
		sleepFor(2000);
		getPage(ConvertLeadToStudentTest.address);
		uname = getElementText(By.xpath("//td[text()='Username']/following-sibling::*//div"));
		pass = getElementText(By.xpath("//td[text()='Password']/following-sibling::*//div"));
		System.out.println("Username: " + uname);
		System.out.println("Password: " + pass);
		assertTrue("Verifying if username and password were created in Sales Force",
				uname.length() > 1 && pass.length() == 8);
	}
}
