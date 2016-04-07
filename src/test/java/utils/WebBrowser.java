package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WebBrowser extends ReportManager {

	public String browserName;
	private WebDriver driver;
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> threadLocalBrowserName = new ThreadLocal<String>();

	@Parameters("browser")
	@BeforeTest
	public void initWebBrowser(@Optional(value = "Chrome") String browser) {

		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox has started");
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome has started");
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("Opera")) {
			System.setProperty("webdriver.opera.driver", "./resources/operadriver.exe");
			driver = new OperaDriver();
		} else if (browser.equalsIgnoreCase("Headless")) {
			driver = new HtmlUnitDriver(true);
		}
		threadLocalBrowserName.set(browserName);
		threadLocalDriver.set(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static WebDriver Driver() {
		return threadLocalDriver.get();
	}

	public static String getCurrentBrowserName() {
		return threadLocalBrowserName.get();
	}

	@AfterTest(alwaysRun = true)
	public void closeWebBrowser() {
		if (driver != null) {
			driver.quit();
			threadLocalDriver.remove();
			System.out.println("Browser closed");
		}
	}

	@AfterSuite(alwaysRun = true)
	public void flush() {
		closeReporter();
	}

}