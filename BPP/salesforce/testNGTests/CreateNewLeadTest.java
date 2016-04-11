package salesforce.testNGTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import salesforce.pages.CreateLeadPage;
import utils.DataGenerator;
import utils.MainClass;

public class CreateNewLeadTest extends MainClass {

	@Test(testName = "Create new Lead in Sales Force", description = "Verifies if Lead was created", priority = 1, groups = {
			"Happy Path" })
	public void createNewLeadTest() {
		String firstName = DataGenerator.firstName();
		String lastName = DataGenerator.lastName();
		CreateLeadPage.createNewLead(firstName, lastName, DataGenerator.intNumber(10));
		assertTrue("Verifying if Lead was created", getElement(CreateLeadPage.getProfID).isDisplayed()
				&& getElement(CreateLeadPage.convertToStudent).isDisplayed());
		System.out.println(firstName + " " + lastName);
	}

	@Test(testName = "Add new address to Lead", description = "Verifies if address was added", priority = 2, groups = {
			"Happy Path " })
	public void addAddressToLeadTest() {
		CreateLeadPage.addAddressToLead(DataGenerator.address());
		assertTrue("Verifying if address was added", getElementText(By.id("Name_ileinner")).length() > 0);
	}

}
