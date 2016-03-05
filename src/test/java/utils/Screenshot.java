package utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends WebBrowser {

	public static String take(String name) {
		String path = "./screenshots/" + name + ".png";
		TakesScreenshot screen = (TakesScreenshot) Driver();
		File source = screen.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}