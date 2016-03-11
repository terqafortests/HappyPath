package portal.testNGTests;

import org.testng.annotations.Test;
import banner.testNGTests.ProcessStudentInBannerTest;
import portal.pages.HeaderPage;
import portal.pages.LoginPage;
import utils.MainClass;

public class LoginTest extends MainClass {

	@Test(testName = "Login to BPP's Portal", description = "Verifies if user can log into BPP's Portal using credentials from Sales Force")
	public void loginTest() {
		getPage("https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm");
		LoginPage.login(ProcessStudentInBannerTest.uname, ProcessStudentInBannerTest.pass);
		assertTrue("Veriying if logged into Portal", getElement(HeaderPage.myCalendar).isDisplayed());
	}
}
