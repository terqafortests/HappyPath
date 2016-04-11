package banner.testNGTests;

import org.testng.annotations.Test;
import salesforce.testNGTests.SubmitApplicationTest;
import utils.CMD;
import utils.ExcelUtils;
import utils.MainClass;

public class ProcessStudentInBannerTest extends MainClass {

	@Test(testName = "Process student in Banner", description = "Verifies if creds were created", groups = {
			"Happy Path" })
	public void processStudentInBanner() throws Exception {
		ExcelUtils.setExcelFile("D://UFTworkspace//HappyPath//BannerFlow//Default.xls", "WorkFlow");
		ExcelUtils.setCellData(SubmitApplicationTest.bannerID, 1, 0);
		CMD.RunUftTest("BannerFlow");
		sleepFor(20000);

	}
}
