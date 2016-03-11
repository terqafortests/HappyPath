package salesforce.testNGTests;

import org.testng.annotations.Test;
import salesforce.pages.LeadPage;
import salesforce.pages.SearchPage;
import utils.MainClass;

public class FindRFICreatedLeadInSalesForceTest extends MainClass {

	@Test(testName = "Search Lead in Sales Force", description = "Verifies that correct lead is found based on data: name, mail, phone")
	public void findRFICreatedLeadInSalesForceTest() {
		SearchPage.searchRecord("Leads", "Alex Test1", "alex_test@mailinator.com", "123456789");
		assertEquals(getElementText(LeadPage.name), "Alex Test1", "Verifying name of Lead");
		assertEquals(getElementText(LeadPage.email), "alex_test@mailinator.com", "Verifying mail of Lead");
		assertEquals(getElementText(LeadPage.phone), "123456789", "Verifying phone of Lead");
	}
}
