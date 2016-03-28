package salesforce.testNGTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import salesforce.pages.CreateOpportunityPage;
import utils.MainClass;

public class CreateNewOpportunityTest extends MainClass {

	@Test(testName = "Create new opprotunity for student", description = "Verifies if opprortunity was created")
	public void createNewOpportunityTest() {
		CreateOpportunityPage.createNewOpportunity("SELFFUND", "None");
		assertTrue("Verifying if opportunity was created",
				isElementDisplayed(By.xpath("//td[text()='Opportunity ID']/following-sibling::td[1]//div")));
	}
}
