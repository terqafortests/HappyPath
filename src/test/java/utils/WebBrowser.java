package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ISuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.android.AndroidDriver;

public class WebBrowser extends ReportManager {

	public String browserName;
	private WebDriver driver;
	
	@SuppressWarnings({ "rawtypes" })
	private AndroidDriver mDriver;
	
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	
	@SuppressWarnings({ "rawtypes" })
	private static ThreadLocal<AndroidDriver> threadLocalMdriver = new ThreadLocal<AndroidDriver>();
	
	private static ThreadLocal<String> threadLocalBrowserName = new ThreadLocal<String>();
	
	@BeforeSuite
	private void beginSuite(ISuite suite){
		System.out.println("[INFO] Started suite '" + suite.getName() + "'");
	}

	@SuppressWarnings("rawtypes")
	@Parameters({ "browser", "device", "OSv" })
	@BeforeTest
	public void initWebBrowser(@Optional(value = "Chrome") String browser, @Optional(value = "") String device,
			@Optional(value = "") String OSv) {
		browserName = browser;
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("[INFO] Firefox has started");
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("[INFO] Chrome has started");
		} else if (browser.equalsIgnoreCase("AndroidWebBrowser")) {
			ServerArguments serverArguments = new ServerArguments();
			serverArguments.setArgument("--address", "127.0.0.1");
			serverArguments.setArgument("--port", 4723);
			AppiumServer appiumServer = new AppiumServer(serverArguments);
			appiumServer.startServer();
			System.out.println("[INFO] Appium server started");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", device);
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", OSv);
			capabilities.setCapability("browserName", "Chrome");
			try {
				mDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			threadLocalMdriver.set(mDriver);
		}
		threadLocalDriver.set(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		threadLocalBrowserName.set(browserName);
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
			System.out.println("[INFO] Browser closed");
		}
	}

	@AfterSuite(alwaysRun = true)
	public void flushReporter() {
		closeReporter();
	}

}