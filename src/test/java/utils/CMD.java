package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.relevantcodes.extentreports.LogStatus;

public class CMD extends MainClass {

	public static String executeCommand(String command) {

		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output.toString();
	}
	
	public static void RunUftTest(String testName) {
		System.out.println("Trying to launch UFT Test");
		Logger().log(LogStatus.INFO, "Trying to launch UFT Test");
		executeCommand("cmdrv -usr \"D:\\UFTworkspace\\HappyPath\\" + testName + "\\" + testName +".usr\"");
		Logger().log(LogStatus.INFO, "UFT Test finished");
		System.out.println("UFT Test finished");
	}

}
