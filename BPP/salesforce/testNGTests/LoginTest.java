package salesforce.testNGTests;

import org.testng.annotations.Test;
import salesforce.pages.HomePage;
import salesforce.pages.LoginPage;
import utils.MainClass;

public class LoginTest extends MainClass {

	@Test(testName = "Login to Sales Force", description = "Verifies that user is logged in SalesForce")
	public void loginTest() {
		getPage("Sales Force address");
		LoginPage.login("uname", "pass");
		assertTrue("Verifying if logged into Sales Force", getElement(HomePage.userLabel).isDisplayed());
	}
}
