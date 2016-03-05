package salesforce.pages;

import org.openqa.selenium.By;

import utils.MainClass;

public class LoginPage extends MainClass{
	
	//Fields
	public static By username = By.id("username"),
			password = By.id("password");
	
	//Buttons
	public static By login = By.id("Login");
	
	
	//Login to Sales Force method
    public static void login(String uname, String pass){
    	enterText(username, uname);
    	enterText(password, pass);
    	clickOn(login, "Log In to Sandbox Button");
    }
}
