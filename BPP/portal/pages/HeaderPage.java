package portal.pages;

import org.openqa.selenium.By;

public class HeaderPage {
	
	public static By myCalendar = By.xpath("//div[@id='navbarCollapse']//span[contains(text(), 'My Calendar')]");
	public static By myGroups = By.xpath("//div[@id='navbarCollapse']//span[contains(text(), 'My Groups')]");
	public static By myProfTable = By.id("generalSettingsForm");
	public static String iFrame = "iframe-layout-instance";

}
