package salesforce.testNGTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import salesforce.pages.CreateProductCatalogItemPage;
import utils.MainClass;

public class AddNewProductCatalogItemTest extends MainClass {

	@Test(testName = "Add product catalog item", description = "Verifies if product item was added")
	public void addNewProductCatalogItemTest() {
		CreateProductCatalogItemPage.createNewProductCatalogItem("999546");
		assertTrue("Verifying if product catalog item was added",
				getElementText(By.xpath("//td[text()='Programme']/following-sibling::*//a")).length() > 0
						&& isElementDisplayed(By.xpath("//td[@id='topButtonRow']/input[@title='Submit Application']")));
	}
}
