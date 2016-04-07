package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtFilesUtils {

	public static String searchInFile(String fileName, String searchStr) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(fileName));
		String result = null;
		while (scan.hasNext()) {
			String line = scan.nextLine().toString();
			if (line.contains(searchStr)) {
				System.out.println(line);
				result = line + "\n";
			}
		}
		scan.close();
		return result;
	}

}
