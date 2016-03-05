package salesforce.testNGTests;

import org.testng.annotations.Test;
import salesforce.pages.HomePage;
import salesforce.pages.LoginPage;
import utils.MainClass;

public class LoginTest extends MainClass {
	@Test
	public void loginTest() {
		getPage("http://test.salesforce.com");
		LoginPage.login("crmteamfusion@noah_crm_bpp.com.noahqa", "Fusion12345");
		assertTrue(getElement(HomePage.userLabel).isDisplayed(), "Verifying if user label is displayed");
	}
}
