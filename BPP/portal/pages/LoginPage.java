package portal.pages;

import org.openqa.selenium.By;
import utils.MainClass;

public class LoginPage extends MainClass {

    public static By username = By.id("username");
    public static By password = By.id("password");
    public static By submit = By.name("submit");
    public static By backgroundImage = By.id("bg-image");
    public static By message = By.xpath("//div[@id='main-content']//h1");
    public static By bppEduLogo = By.xpath("//div[@class='logo']//a[1]/img");
    public static By bppUniLogo = By.xpath("//div[@class='logo']//a[2]/img");
    public static By signInMessage = By.xpath("//div[@id='main-content']//h2");
    public static By errSection = By.cssSelector("#status");
    
    public static void login(String user, String pass) {
        enterText(username, user);
        enterText(password, pass);
        clickOn(submit, "Login Button");
    }

}
