package utils;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;

public class MainClass extends WebBrowser {

	private static SoftAssert sAssert = new SoftAssert();

	private static WebElement getEl(By by) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(Driver(), 5);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	public static void getPage(String pageAddress) {
		try {
			Driver().get(pageAddress);
			Logger().log(LogStatus.PASS, "Redirected to " + pageAddress);
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Redirecting to " + pageAddress + " ...");
			Logger().log(LogStatus.FAIL, "Page is not available" + Logger().addScreenCapture(Screenshot.take()));
			e.printStackTrace();
			Assert.fail();
		}

	}

	public static String getCurrUrl() {
		String currAddress = Driver().getCurrentUrl();
		String title = Driver().getTitle();
		if (title.contains("is not available") || title.contains("Problem loading page")) {
			Logger().log(LogStatus.FATAL, title + Logger().addScreenCapture(Screenshot.take()));
		}
		return currAddress;
	}

	public static WebElement getElement(By by) {
		WebElement element = null;
		try {
			element = getEl(by);
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to get element...");
			Logger().log(LogStatus.FAIL,
					"Cannot get element " + Logger().addScreenCapture(Screenshot.take()) + e.getCause());
			e.printStackTrace();
		}
		return element;
	}

	public static void clickOn(By by, String elementName) {
		WebElement element = null;
		try {
			element = getEl(by);
			element.click();
			Logger().log(LogStatus.PASS, "Clicked on '" + elementName + "'");
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to click on '" + elementName + "' ...");
			Logger().log(LogStatus.FAIL, "Cannot click on element '" + elementName + "' "
					+ Logger().addScreenCapture(Screenshot.take()) + e.getCause());
			e.printStackTrace();
			Assert.fail();
		}
	}

	public static void enterText(By by, String text) {
		WebElement element = null;
		try {
			element = getEl(by);
			element.clear();
			element.sendKeys(text);
			Logger().log(LogStatus.PASS, "Entered text '" + text + "'");
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to enter text '" + text + "'...");
			Logger().log(LogStatus.FAIL,
					"Cannot enter text '" + text + "'" + Logger().addScreenCapture(Screenshot.take()) + e.getCause());
			e.printStackTrace();
			Assert.fail();
		}
	}

	public static void switchToFrame(String frameId) {
		try {
			Driver().switchTo().frame(frameId);
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to switch to frame '" + frameId + "'");
			Logger().log(LogStatus.FAIL, "Cannot find frame: '" + frameId + "'");
			e.printStackTrace();
			Assert.fail();
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
		WebDriver tab = null;
		try {
			tab = Driver().switchTo().window(getTabs().get(i));
			Logger().log(LogStatus.PASS, "Switched to tab '" + tab.getTitle() + "'");
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to switch to tab " + i);
			Logger().log(LogStatus.FAIL, "Cannot switch to tab " + i);
			e.printStackTrace();
			Assert.fail();
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
		String att = null;
		try {
			att = getEl(by).getAttribute(attName);
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to get attribute '" + att + "'");
			Logger().log(LogStatus.FAIL, "Cannot get attribute '" + attName + "'"
					+ Logger().addScreenCapture(Screenshot.take()) + e.getCause());
			e.printStackTrace();
			Assert.fail();
		}
		return att;
	}

	public static String getElementText(By by) {
		String text = null;
		try {
			text = getEl(by).getText();
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to get text...");
			Logger().log(LogStatus.FAIL,
					"Cannot get text" + Logger().addScreenCapture(Screenshot.take()) + e.getCause());
			e.printStackTrace();
			Assert.fail();
		}
		return text;
	}

	public static void switchToDefaultFrame() {
		Driver().switchTo().defaultContent();
		Logger().log(LogStatus.PASS, "Switched to default frame");
	}

	public static List<WebElement> getElements(By by) {
		return Driver().findElements(by);
	}

	public static void assertEquals(String beforeMess, Object actual, Object expected) {
		Logger().log(LogStatus.INFO, beforeMess);
		if (actual.equals(expected)) {
			Logger().log(LogStatus.PASS, "Objects match");
		} else {
			Logger().log(LogStatus.FAIL, "Expected: '" + expected + "' Actual: '" + actual + "'"
					+ Logger().addScreenCapture(Screenshot.take()));
			sAssert.fail();
		}
	}

	public static void assertTrue(String verificationMessage, boolean actual) {
		Logger().log(LogStatus.INFO, verificationMessage);
		try {
			sAssert.assertTrue(actual);
			Logger().log(LogStatus.PASS, "True");
		} catch (AssertionError e) {
			Logger().log(LogStatus.FAIL, "False" + Logger().addScreenCapture(Screenshot.take()) + e.getCause());
			e.printStackTrace();
			sAssert.fail();
		}
	}

	public static boolean isElementDisplayed(By by) {
		WebDriverWait wait = new WebDriverWait(Driver(), 2);
		WebElement element = null;
		boolean b = false;
		try {
			element = wait.until(ExpectedConditions.visibilityOf(Driver().findElement(by)));
			if (element.isDisplayed()) {
				b = true;
			} else {
				b = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public static void selectFromDropdownText(By dropDownIdent, String text) {
		try {
			Select oSelection = new Select(getEl(dropDownIdent));
			oSelection.selectByVisibleText(text);
			Logger().log(LogStatus.PASS, "Selected '" + text + "' from dropdown");
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to select '" + text + "' from dropdown");
			Logger().log(LogStatus.FAIL, "Cannot select '" + text + "' from dropdown"
					+ Logger().addScreenCapture(Screenshot.take()) + e.getCause());
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void selectFromDropdownValue(By dropDownIdent, String value) {
		try {
			Select oSelection = new Select(getEl(dropDownIdent));
			oSelection.selectByValue(value);
			Logger().log(LogStatus.PASS, "Selected '" + value + "' from dropdown");
		} catch (Exception e) {
			Logger().log(LogStatus.INFO, "Trying to select '" + value + "' from dropdown");
			Logger().log(LogStatus.PASS, "Cannot select '" + value + "' from dropdown"
					+ Logger().addScreenCapture(Screenshot.take()) + e.getCause());
			e.printStackTrace();
			Assert.fail();
		}
	}

	public static void assertAll() {
		sAssert.assertAll();
	}

}