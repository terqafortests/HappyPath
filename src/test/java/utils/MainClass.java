package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;

public class MainClass extends WebBrowser {

	private static SoftAssert sAssert = new SoftAssert();

	public static void getPage(String address) {
		Logger().log(LogStatus.INFO, "Trying to redirect to " + address);
		Driver().get(address);
		String title = Driver().getTitle();
		if (title.contains("is not available") || title.contains("Problem loading page")) {
			Logger().log(LogStatus.FATAL, title + Logger().addScreenCapture(Screenshot.take("FATAL_Cannot_load_page")));
		} else {
			Logger().log(LogStatus.PASS, "Redirected to: " + address);
		}
	}

	public static String getCurrUrl() {
		String currAddress = Driver().getCurrentUrl();
		String title = Driver().getTitle();
		if (title.contains("is not available") || title.contains("Problem loading page")) {
			Logger().log(LogStatus.FATAL, title + Logger().addScreenCapture(Screenshot.take("FATAL_Cannot_load_page")));
		}
		return currAddress;
	}

	public static WebElement getElement(By by) {
		WebDriverWait wait = new WebDriverWait(Driver(), 30);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOf(Driver().findElement(by)));
		} catch (Exception e) {
			System.out.println("Cannot find Element on the page" + e.getMessage());
			Logger().log(LogStatus.FAIL, "Cannot find element on the page. Stacktrace: " + e.getMessage() + Logger()
					.addScreenCapture(Screenshot.take("FAIL_Cannot_find_element_" + new Random().nextInt(1000))));
		}
		return element;
	}

	public static void clickOn(By by, String webElement) {
		Logger().log(LogStatus.INFO, "Trying to click on " + webElement);
		WebElement element = getElement(by);
		if (element.isDisplayed() & element.getSize().getHeight() > 0 & element.getSize().getWidth() > 0) {
			element.click();
			Logger().log(LogStatus.PASS, "Clicked on " + webElement);
		} else {
			Logger().log(LogStatus.FAIL,
					"Cannot click on element: element is not visible on page or it's dimensions are less then 0"
							+ Logger().addScreenCapture(
									Screenshot.take("FAIL_Cannot_click_on_element" + new Random().nextInt(1000))));
		}
	}

	public static void enterText(By by, String text) {
		Logger().log(LogStatus.INFO, "Trying to enter text: " + text);
		WebElement element = getElement(by);
		element.clear();
		element.sendKeys(text);
		Logger().log(LogStatus.PASS, "Entered text: " + text);
	}

	public static void switchToFrame(String frameId) {
		try {
			Driver().switchTo().frame(frameId);
		} catch (Exception e) {
			System.out.println("Cannot switch to frame " + frameId);
			Driver().switchTo().frame(frameId);
			Logger().log(LogStatus.FAIL, "Cannot swith to frame: " + frameId);
		}
	}

	public static void sleepFor(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver switchToTab(int i) {
		Logger().log(LogStatus.INFO, "Trying to switch to " + i + " tab");
		WebDriver tab = null;
		try {
			tab = Driver().switchTo().window(getTabs().get(i));
			Logger().log(LogStatus.PASS, "Switched to tab " + tab.getTitle());
		} catch (Exception e) {
			Logger().log(LogStatus.FAIL, "Cannot switch to tab");
		}
		return tab;
	}

	private static List<String> getTabs() {
		List<String> windows = new ArrayList<String>(Driver().getWindowHandles());
		return windows;
	}

	public static void closeTab(int i) {
		switchToTab(i).close();
		Logger().log(LogStatus.PASS, "Tab closed");
	}

	public static String getElementAtt(By by, String attName) {
		return getElement(by).getAttribute(attName);
	}

	public static String getElementText(By by) {
		return getElement(by).getText();
	}

	public static void switchToDefaultFrame() {
		Driver().switchTo().defaultContent();
		Logger().log(LogStatus.PASS, "Switched to default frame");
	}

	public static List<WebElement> getElements(By by) {
		return Driver().findElements(by);
	}

	public static void assertEquals(Object actual, Object expected, String beforeMess) {
		Logger().log(LogStatus.INFO, beforeMess);
		if (actual.equals(expected)) {
			Logger().log(LogStatus.PASS, "Objects match");
		} else {
			Logger().log(LogStatus.FAIL, "Expected: '" + expected + "' Actual: '" + actual + "'"
					+ Logger().addScreenCapture(Screenshot.take("FAILED_" + new Random().nextInt(1000))));
			sAssert.assertEquals(actual, expected);
		}
	}

	public static void assertTrue(String beforeMess, boolean actual) {
		Logger().log(LogStatus.INFO, beforeMess);
		if (actual) {
			Logger().log(LogStatus.PASS, "True");
		} else {
			Logger().log(LogStatus.FAIL, "Expected: true, but false"
					+ Logger().addScreenCapture(Screenshot.take("FAILED_" + new Random().nextInt(1000))));
			sAssert.assertTrue(actual);
		}
	}

	public static void selectFromDropdownText(By dropDownIdent, String text) {
		Logger().log(LogStatus.INFO, "Trying to select " + text + " from dropdown");
		try {
			Select oSelection = new Select(getElement(dropDownIdent));
			oSelection.selectByVisibleText(text);
			Logger().log(LogStatus.PASS, "Selected " + text + " from dropdown");
		} catch (Exception e) {
			Logger().log(LogStatus.FAIL, "Cannot locate element with text: " + text
					+ Logger().addScreenCapture(Screenshot.take("FAILED_" + new Random().nextInt(1000))));
			sAssert.assertTrue(1 == 2);
		}
	}

	public void selectFromDropdownValue(By dropDownIdent, String value) {
		Logger().log(LogStatus.INFO, "Trying to select " + value + " from dropdown");
		try {
			Select oSelection = new Select(getElement(dropDownIdent));
			oSelection.selectByValue(value);
			Logger().log(LogStatus.PASS, "Selected " + value + " from dropdown");
		} catch (Exception e) {
			Logger().log(LogStatus.FAIL, "Cannot locate element with text: " + value
					+ Logger().addScreenCapture(Screenshot.take("FAILED_" + new Random().nextInt(1000))));
			sAssert.assertTrue(1 == 2);
		}
	}

	public static void assertAll() {
		sAssert.assertAll();
	}

}