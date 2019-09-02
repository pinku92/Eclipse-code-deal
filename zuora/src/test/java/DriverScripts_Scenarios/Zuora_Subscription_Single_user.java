package DriverScripts_Scenarios;

import java.io.IOException;

import ExcelUtility.ConstantUtility;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.Email_Utils;
import TestBase.TestBase;

public class Zuora_Subscription_Single_user extends TestBase {

	@DataProvider
	public Object[][] Data() throws IOException {
		return getData(ConstantUtility.input_excel, ConstantUtility.singleuser_input_excel_emailsheet);
	}

	@BeforeSuite
	public void beforesuite() throws IOException, InterruptedException {
		SINGLE_USER_START_CONFIGURATIONS();
	}

	@Test(dataProvider = "Data")
	public void Do_Parameterization(String execution, String Susbcription_status, String csr_status,
			String selfservice_status, String Login_status, String zuora_status, String Upsell, String crossell,
			String image_status, String product, String oid, String premium_product_url, String email, String Fname,
			String Lname, String pwd, String confirmpwd, String subscriptionType, String ccNumber, String cvvCode,
			String exMonth, String exYear, String nameOnCard, String address1, String address2, String city,
			String state, String country, String postalCode, String phoneNum, String stage_login_url, String type)
			throws Exception {

		START_SINGLE_USER_SUBSCRIPTION(execution, Susbcription_status, csr_status, selfservice_status, Login_status,
				zuora_status, Upsell, crossell, image_status, product, oid, premium_product_url, email, Fname, Lname,
				pwd, confirmpwd, subscriptionType, ccNumber, cvvCode, exMonth, exYear, nameOnCard, address1, address2,
				city, state, country, postalCode, phoneNum, stage_login_url, email + ConstantUtility.mail_suffix, type);

	}

	@Test(priority = 1)
	public static void aftertest() throws Exception, IOException {
		START_SINGLE_USER_ZUORA_VALIDATIONS();
	}

	@AfterSuite
	public void aftersuite() throws AddressException, MessagingException, IOException {
		SINGLE_USER_END_CONFIGURATIONS(ConstantUtility.singleuser_mail_attachment_filename,
				ConstantUtility.singleuser_mail_subject, ConstantUtility.singleuser_mail_body);
	}
}
