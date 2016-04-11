package salesforce.testNGTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import salesforce.pages.ConvertLeadPage;
import salesforce.pages.CreateLeadPage;
import utils.MainClass;

public class ConvertLeadToStudentTest extends MainClass {

	public static String address;

	@Test(testName = "Convert Lead to Student", description = "Verifies if Lead is converted to Student", groups = {
			"Happy Path" })
	public void convertLeadToStudentTest() {
		clickOn(By.xpath("//td[text()='Lead']/following-sibling::*//a"), "Lead Link");
		clickOn(CreateLeadPage.getProfID, "Get Profile ID Button");
		sleepFor(4000);
		clickOn(CreateLeadPage.convertToStudent, "Convert To Student Button");
		selectFromDropdownText(ConvertLeadPage.convertedStatus, "Shop");
		enterText(ConvertLeadPage.subjectField, "Call");
		clickOn(ConvertLeadPage.convertButton, "Convert Button");
		sleepFor(4000);
		clickOn(ConvertLeadPage.editButton, "Edit Button");
		selectFromDropdownText(ConvertLeadPage.studentTypeDropdwn, "Domestic");
		selectFromDropdownText(ConvertLeadPage.legalEntityDropdwn, "UC~COL");
		clickOn(ConvertLeadPage.saveButton, "Save Button");
		address = getCurrUrl();
		System.out.println(address);
		assertTrue("Verifying if Lead was converted was converted to Student",
				getElementText(By.id("RecordType_ileinner")).contains("Student Account"));

	}

}
