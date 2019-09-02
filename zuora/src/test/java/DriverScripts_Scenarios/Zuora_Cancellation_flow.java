package DriverScripts_Scenarios;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ConstantUtility;
import TestBase.Email_Utils;
import TestBase.TestBase;

public class Zuora_Cancellation_flow extends TestBase {

	@DataProvider
	public Object[][] Data() throws IOException {
		return getData(ConstantUtility.input_excel, ConstantUtility.zuora_cancellation);
	}

	@BeforeSuite
	public static void beforesuite() throws Exception {
		ZUORA_CANCELLATION_START_CONFIGURATION();
	}

	@Test(dataProvider = "Data")
	public void do_parameterization(String Exe_status, String Email) throws Exception, IOException {
		DO_ZUORA_CANCELLATION_PROCESS(Exe_status, Email);
	}

	@AfterSuite
	public static void aftersuite() throws IOException, InterruptedException {
		ZUORA_CANCELLATION_END_CONFIGURATION(ConstantUtility.zuora_cancellation_mail_attachment_filename,
				ConstantUtility.zuora_cancellation_mail_subject, ConstantUtility.zuora_cancellation_mail_body);
	}

}
