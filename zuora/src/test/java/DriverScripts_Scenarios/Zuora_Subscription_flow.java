package DriverScripts_Scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ExcelUtility.ConstantUtility;
import PageMethods.CSR_flow_methods;
import PageMethods.Zuora_flow_methods;
import TestBase.Email_Utils;
import TestBase.TestBase;

public class Zuora_Subscription_flow extends TestBase {

	public static String email = ConstantUtility.csr_newuser_email;

	@DataProvider
	public Object[][] Data() throws IOException {
		return getData(ConstantUtility.input_excel, ConstantUtility.zuora_subscription);
	}

	@BeforeSuite
	public static void beforesuite() throws Exception {
		ZUORA_SUBSCRIPTION_START_CONFIGURATION(email);
	}

	@Test(priority = 0, dataProvider = "Data")
	public void do_parameterization(String Exe_status, String Product_name, String Rate_plan)
			throws Exception, IOException {
		DO_ZUORA_SUBSCRIPTION(Exe_status, Product_name, Rate_plan, email);
	}

	@Test(priority = 1)
	public static void aftertest() throws InterruptedException {
		START_ZUORA_BILL_RUN_PROCESS(email);
	}

	@Test(priority = 2)
	public static void aftertest1() throws InterruptedException {
		ZUORA_BILL_RUN_VALIDATION_PROCESS(email);

	}

	@AfterSuite
	public static void aftersuite() throws IOException {
		ZUORA_SUBSCRIPTION_END_CONFIGURATION(ConstantUtility.zuora_subscription_mail_attachment_filename,
				ConstantUtility.zuora_subscription_mail_subject,ConstantUtility.zuora_subscription_mail_body);
	}

}
