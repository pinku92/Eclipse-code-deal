package DriverScripts_Scenarios;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import TestBase.Email_Utils;
import TestBase.TestBase;
import ExcelUtility.*;

public class Ashot_Comparison_QA_Live extends TestBase {
	@DataProvider

	public Object[][] Data() throws IOException {
		return getData(ConstantUtility.input_excel, ConstantUtility.ashot_input_sheet);
	}

	@BeforeSuite
	public void beforesuite() throws IOException, InterruptedException {
		IMAGE_COMPARISON_START_CONFIGURATION();
	}

	@Test(dataProvider = "Data")
	public void Do_Parameterization(String Ex_Status, String QA_Url, String Live_Url, String Product, String Email)
			throws Exception {
	START_IMAGE_COMPARISON_PROCESS(Ex_Status, QA_Url, Live_Url, Product, Email);
	}

	@AfterSuite

	public void aftersuite() throws AddressException, MessagingException, IOException {
		IMAGE_COMPARISON_END_CONFIGURATION(ConstantUtility.commerce_image_comparison_mail_attachment_filename,
				ConstantUtility.commerce_image_comparison__mail_subject,
				ConstantUtility.commerce_image_comparison__mail_body);
	}

}
