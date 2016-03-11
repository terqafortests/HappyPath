package rfi.testNGTests;

import org.testng.annotations.Test;
import rfi.pages.RFIPage;
import utils.MainClass;

public class SendRFLeadTest extends MainClass {
	@Test(testName = "Create lead in RFI form", description = "Verifies that lead is created")
	public void sendRFLeadTest() {
		getPage("http://noahqa-bpp-13fd3e55188.cs17.force.com/rfi/");
		selectFromDropdownText(RFIPage.title, "Mr");
		enterText(RFIPage.firstName, "ghhfxxvcvcx");
		enterText(RFIPage.lastName, "Blabfhdfbvcxcbvx");
		enterText(RFIPage.email, "Blabla@mail.com");
		enterText(RFIPage.phone, "87557645653453");
		selectFromDropdownText(RFIPage.rUstudingWus, "No");
		sleepFor(2000);
		selectFromDropdownText(RFIPage.hearUs, "Advertising");
		sleepFor(1000);
		selectFromDropdownText(RFIPage.euUk, "UK (EU) Student");
		sleepFor(1000);
		selectFromDropdownText(RFIPage.levelOfStusdy, "Undergraduate");
		sleepFor(1000);
		selectFromDropdownText(RFIPage.areaOfInterest, "Accountancy");
		sleepFor(1000);
		selectFromDropdownText(RFIPage.courseOfinterest, "BSc Professional accounting");
		sleepFor(1000);
		selectFromDropdownText(RFIPage.startMonth, "01");
		sleepFor(1000);
		selectFromDropdownText(RFIPage.startYear, "2017");
		sleepFor(1000);
		selectFromDropdownText(RFIPage.studyLoc, "Bristol");
		sleepFor(1000);
		selectFromDropdownText(RFIPage.countryOfResidence, "United Kingdom");
		enterText(RFIPage.postcode, "89768565577465");
		clickOn(RFIPage.sendRequest, "Send Request");
		assertEquals(getCurrUrl(), "http://noahqa-bpp-13fd3e55188.cs17.force.com/rfi/THANKYOU",
				"Verfying if actual current url mathces expected");
	}
}
