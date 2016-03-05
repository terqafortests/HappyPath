package salesforce.pages;

import org.openqa.selenium.By;
import utils.MainClass;

public class SearchPage extends MainClass {
	
	//Links
	public static By deselectAll = By.linkText("Deselect All");
	
	//Check Boxes
	public static By leadChkbox = By.id("00Q");
	
	//Fields
	public static By searchField = By.id("str");
	
	//Buttons
	public static By searchButton = By.name("search");
	
	
	//Search method
	public static void searchRecord(String recordType, String name){
		clickOn(HomePage.homeTab, "Home Tab");
		clickOn(HomePage.advancedSearch, "Advanced Search Link");
		clickOn(SearchPage.deselectAll, "Deselect All Link");
		switch (recordType){
		case "Leads":
			clickOn(SearchPage.leadChkbox, "Lead Checkbox");
			enterText(SearchPage.searchField, name);
			clickOn(SearchPage.searchButton, "Search Button");
			break;
		}
	}

}
