package rfi.pages;

import org.openqa.selenium.By;

public class RFIPage {
	
	
	// Fields
	public static By title = By.id("j_id0:form:Salutation"),
			firstName = By.id("j_id0:form:first_name"),
			lastName = By.id("j_id0:form:last_name"),
			email = By.id("j_id0:form:email"),
			phone = By.id("j_id0:form:phone"),
			rUstudingWus = By.id("j_id0:form:existing_student_check"),
			hearUs = By.id("j_id0:form:source1"),
			euUk = By.id("j_id0:form:eu_uk"),
			levelOfStusdy = By.id("j_id0:form:cbxlevel0"),
			areaOfInterest = By.id("j_id0:form:cbxlevel1"),
			courseOfinterest = By.id("j_id0:form:cbxlevel2"),
			startMonth = By.id("j_id0:form:start_month"),
			startYear = By.id("j_id0:form:start_year"),
			studyLoc = By.id("j_id0:form:location_centre"),
			countryOfResidence = By.id("j_id0:form:country"),
			postcode = By.id("j_id0:form:postalcode");
	
	//Buttons
	public static By sendRequest = By.name("j_id0:form:j_id79");
			
}
