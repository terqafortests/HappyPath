package salesforce.pages;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;
import utils.MainClass;

public class CreateOpportunityPage extends MainClass {

	public static By newOpprortunityButton = By.xpath("//input[@value='New Opportunity']"), oppType = By.id("p3"),
			continueButton = By.xpath("//input[@title='Continue']"),
			oppNameField = By.xpath("//label[text()='Opportunity Name']/../following-sibling::*//input"),
			statusDropdwn = By.xpath("//label[text()='Status']/../following-sibling::*//select"),
			customerGroupDropdwn = By.xpath("//label[text()='Customer Group']/../following-sibling::*//select"),
			closeDateField = By.xpath("//label[text()='Close Date']/../following-sibling::*//input"),
			sponsorshipLevelDropdwn = By.xpath("//label[text()='Sponsorship Level']/../following-sibling::*//select"),
			saveButton = By.xpath("//td[@id='bottomButtonRow']/input[@title='Save']");

	public static void createNewOpportunity(String customerGroup, String sponsorshipLevel) {
		Logger().log(LogStatus.INFO, "Trying to create new opportunity");
		clickOn(CreateOpportunityPage.newOpprortunityButton, "New Opportunity Button");
		selectFromDropdownText(CreateOpportunityPage.oppType, "Application");
		clickOn(CreateOpportunityPage.continueButton, "Continue Button");
		enterText(CreateOpportunityPage.oppNameField, getElementAtt(
				By.xpath("//label[text()='Account Name']/../following-sibling::*//input[@tabindex='2']"), "value"));
		selectFromDropdownText(CreateOpportunityPage.statusDropdwn, "Accepted - Conditional Firm");
		selectFromDropdownText(CreateOpportunityPage.customerGroupDropdwn, customerGroup);
		enterText(CreateOpportunityPage.closeDateField, "10/03/2017");
		selectFromDropdownText(CreateOpportunityPage.sponsorshipLevelDropdwn, sponsorshipLevel);
		clickOn(CreateOpportunityPage.saveButton, "Save Button");
	}

}
