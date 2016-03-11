package salesforce.pages;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;
import utils.MainClass;

public class CreateLeadPage extends MainClass {
	
	public static By newButton = By.name("new"),
			typeOfLead = By.id("p3"),
			continueButton = By.xpath("//td[@id='bottomButtonRow']/input[@value='Continue']");
	
	//Fields
	public static By firstName = By.id("name_firstlea2"),
			lastName = By.id("name_lastlea2"),
			preferredPhone = By.xpath("//label[text()='Preferred Phone']/../following-sibling::td[1]//select"),
			mobile = By.xpath("//label[text()='Mobile']/../following-sibling::td[1]/input"),
			preferredEmail = By.xpath("//label[text()='Preferred Email']/../following-sibling::*//select"),
			personalEmail = By.xpath("//label[text()='Personal Email']/../following-sibling::*//input"),
			gender = By.xpath("//select[@tabindex='40']"),
			birthDate = By.xpath("//label[text()='Birth Date']/../following-sibling::*//input"),
	        saveButton = By.name("save");
	
	public static By newAddressButton = By.xpath("//input[@value='New Address']"),
			addressType = By.xpath("//label[text()='Address Type']/../following-sibling::td[1]//select"),
			isPrimary = By.xpath("//label[text()='isPrimary']/../following-sibling::*//input[@type='checkbox']"),
			addressLine1 = By.xpath("//label[text()='Address Line 1']/../following-sibling::*//input[@tabindex='7']"),
			city = By.xpath("//label[text()='City']/../following-sibling::*//input[@tabindex='8']"),
			postalCode = By.xpath("//label[text()='Postal Code']/../following-sibling::*//input"),
			country = By.xpath("//label[text()='Country']/../following-sibling::*//span/input"),
	        saveAddressButton = By.xpath(".//*[@id='bottomButtonRow']/input[1]"),
	        leadLink = By.xpath("//td[text()='Lead']/following-sibling::td[1]//a"),
			getProfID = By.xpath("//*[@id='topButtonRow']/input[@title = 'Get Profile ID']"),
			convertToStudent = By.xpath("//*[@id='topButtonRow']/input[@title = 'Convert To Student']");
	
	public static void createNewLead(String fName, String lName, String phone){
		Logger().log(LogStatus.INFO, "Trying to create new lead");
		clickOn(HomePage.allTabs, "All Tabs Link");
		clickOn(AllTabsPage.leadsLink, "Leads Link");
		clickOn(CreateLeadPage.newButton, "New Button");
		selectFromDropdownText(CreateLeadPage.typeOfLead, "Prospective Student");
		clickOn(CreateLeadPage.continueButton, "Continue Button");
		enterText(CreateLeadPage.firstName, fName);
		enterText(CreateLeadPage.lastName, lName);
		selectFromDropdownText(CreateLeadPage.preferredPhone, "Mobile");
		enterText(CreateLeadPage.mobile, phone);
		selectFromDropdownText(CreateLeadPage.preferredEmail, "Personal");
		enterText(CreateLeadPage.personalEmail, fName.toLowerCase() + lName.toLowerCase() + "@supertestmail.com".toLowerCase());
		selectFromDropdownText(CreateLeadPage.gender, "Male");
		enterText(CreateLeadPage.birthDate, "01/03/1990");
		clickOn(CreateLeadPage.saveButton, "Save Button");
	}
	
	public static void addAddressToLead(String addressLine1){
		Logger().log(LogStatus.INFO, "Trying to create address for Lead");
		clickOn(CreateLeadPage.newAddressButton, "New Address Button");
		selectFromDropdownText(CreateLeadPage.addressType, "Billing");
		clickOn(CreateLeadPage.isPrimary, "isPrimary Checkbox");
		enterText(CreateLeadPage.addressLine1, addressLine1);
		enterText(CreateLeadPage.city, "London");
		enterText(CreateLeadPage.postalCode, "SE16");
		enterText(CreateLeadPage.country, "United Kingdom");
		clickOn(CreateLeadPage.saveAddressButton, "Save Address Button");
	}

}
