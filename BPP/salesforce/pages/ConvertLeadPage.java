package salesforce.pages;

import org.openqa.selenium.By;

public class ConvertLeadPage {
	
	public static By subjectField = By.xpath("//label[text()='Subject']/../following-sibling::*//input"),
			convertedStatus = By.id("cstatus"),
			convertButton = By.xpath("//td[@id='bottomButtonRow']/input[@title='Convert']"),
			studentTypeDropdwn = By.xpath("//label[text()='Student Type']/../following-sibling::*//select"),
			legalEntityDropdwn = By.xpath("//label[text()='Legal Entity']/../following-sibling::*//select"),
			saveButton = By.xpath("//td[@id='bottomButtonRow']/input[@name='save']"),
			editButton = By.xpath("//td[@id='topButtonRow']/input[@name='edit']");
	

}