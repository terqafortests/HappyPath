package salesforce.testNGTests;

import org.testng.annotations.Test;
import salesforce.pages.HomePage;
import salesforce.pages.LoginPage;
import utils.MainClass;

public class LoginTest extends MainClass {

	@Test(testName = "Login to Sales Force", description = "Verifies that user is logged in SalesForce")
	public void loginTest() {
		getPage("https://test.salesforce.com/");
		LoginPage.login("crmteamfusion@noah_crm_bpp.com.noahqa", "Fusion12345");
		assertTrue("Verifying if logged into Sales Force", isElementDisplayed(HomePage.userLabel));
	}
}
