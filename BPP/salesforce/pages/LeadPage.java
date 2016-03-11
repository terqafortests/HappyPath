package salesforce.pages;

import org.openqa.selenium.By;

public class LeadPage {
	
	//Fields
	public static By name = By.xpath("//td[text()='Name']/following-sibling::*//div"),
			email = By.xpath("//td[text()='Email']/following-sibling::*//div"),
			phone = By.xpath("//td[text()='Phone']/following-sibling::*//div");

}
