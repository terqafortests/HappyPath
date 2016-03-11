package salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.relevantcodes.extentreports.LogStatus;
import utils.MainClass;

public class SearchPage extends MainClass {

	// Links
	public static By deselectAll = By.linkText("Deselect All");

	// Check Boxes
	public static By leadChkbox = By.id("00Q");

	// Fields
	public static By searchField = By.id("str");

	// Buttons
	public static By searchButton = By.name("search");

	// Search method
	public static void searchRecord(String recordType, String fNameLname, String email, String phone) {
		Logger().log(LogStatus.INFO, "Trying to search " + recordType + "with: " + fNameLname + " " + email + " "
				+ phone + " in SalesForce");
		clickOn(HomePage.homeTab, "Home Tab");
		clickOn(HomePage.advancedSearch, "Advanced Search Link");
		clickOn(SearchPage.deselectAll, "Deselect All Link");
		switch (recordType) {
		case "Leads":
			clickOn(SearchPage.leadChkbox, "Lead Checkbox");
			enterText(SearchPage.searchField, fNameLname);
			getElement(SearchPage.searchField).sendKeys(Keys.RETURN);
			try {
				Driver().findElement(By.id("Lead_body"));
				clickOn(By.xpath("//a[text()='" + email + "']/../preceding-sibling::td[text()='" + phone
						+ "']/preceding-sibling::*/a[text()='" + fNameLname + "']"), fNameLname + " link");
			} catch (Exception e) {
			}
			break;
		}
	}

}
