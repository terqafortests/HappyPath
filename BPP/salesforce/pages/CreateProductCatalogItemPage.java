package salesforce.pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import utils.MainClass;

public class CreateProductCatalogItemPage extends MainClass {
	
	public static By newProductCatalogItemButton = By.xpath("//input[@title='New Product Catalog Item']"),
			offeringField = By.id("j_id0:searchForm:searchPageBlock:OfferingLookup"),
			searchButton = By.id("j_id0:searchForm:searchPageBlock:sBtn"),
			instanceNameCheckbox = By.xpath("//td[@id='j_id0:searchForm:searchPageBlock:offeringTable:0:j_id43']/input"),
			bundleCheckbox = By.id("j_id0:searchForm:j_id63:bundleTable:0:we"),
			addProductsButton = By.xpath("//td[@id='j_id0:searchForm:j_id77:j_id78']/input[1]"),
	        submitApplication = By.xpath("//td[@id='topButtonRow']/input[@value='Submit Application']");
	        		
	
	public static void createNewProductCatalogItem(String item){
		Logger().log(LogStatus.INFO, "Trying to add product item: " + item);
		clickOn(CreateProductCatalogItemPage.newProductCatalogItemButton, "New Product Catalog Item Button");
		enterText(CreateProductCatalogItemPage.offeringField, item);
		clickOn(CreateProductCatalogItemPage.searchButton, "Search Button");
		clickOn(CreateProductCatalogItemPage.instanceNameCheckbox, "Instance Checkbox");
		clickOn(CreateProductCatalogItemPage.bundleCheckbox, "Bundle Checkbox");
		clickOn(CreateProductCatalogItemPage.addProductsButton, "Add Products Button");
	}

}
