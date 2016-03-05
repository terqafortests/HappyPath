package salesforce.testNGTests;

import org.testng.annotations.Test;
import salesforce.pages.SearchPage;
import utils.MainClass;

public class FindRFICreatedLeadInSalesForceTest extends MainClass {
  @Test
  public void findRFICreatedLeadInSalesForceTest() {
	  SearchPage.searchRecord("Leads", "Joe Black");
	  sleepFor(20000);
  }
}
