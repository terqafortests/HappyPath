package portal.testNGTests;

import org.testng.annotations.Test;
import portal.pages.HeaderPage;
import portal.pages.LoginPage;
import salesforce.testNGTests.GetCredentialsForStudentTest;
import utils.MainClass;

public class LoginTest extends MainClass {

	@Test(testName = "Login to BPP Portal", description = "Verifies if user can log into BPP's Portal using credentials from Sales Force", groups = {
			"Happy Path" })
	public void loginTest() {
		getPage("https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm");
		LoginPage.login(GetCredentialsForStudentTest.uname, GetCredentialsForStudentTest.pass);
		assertTrue("Veriying if logged into Portal", isElementDisplayed(HeaderPage.myCalendar));
	}
}
