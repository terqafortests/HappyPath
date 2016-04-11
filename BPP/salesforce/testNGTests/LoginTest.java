package salesforce.testNGTests;

import org.testng.annotations.Test;
import salesforce.pages.HomePage;
import salesforce.pages.LoginPage;
import utils.MainClass;

public class LoginTest extends MainClass {

	@Test(testName = "Login to Sales Force", description = "Verifies that user is logged in SalesForce", groups = {
			"Happy Path", "http://google.com" })
	public void loginTest() {
		getPage("");
		LoginPage.login("", "");
		assertTrue("Verifying if logged into Sales Force", isElementDisplayed(HomePage.userLabel));
	}
}
