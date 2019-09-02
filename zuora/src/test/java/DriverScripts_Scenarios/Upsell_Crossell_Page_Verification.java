package DriverScripts_Scenarios;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ConstantUtility;
import TestBase.TestBase;

public class Upsell_Crossell_Page_Verification extends TestBase{

	
	@DataProvider
	public Object[][] Data() throws IOException {
		return getData(ConstantUtility.input_excel, "Upsell_Crosssell_pages");
	}

	@BeforeSuite
	public void beforesuite() throws IOException, InterruptedException {
		UPSELL_CROSSSELL_USER_START_CONFIGURATIONS();
	}

	@Test(dataProvider = "Data")
	public void Do_Parameterization(String execution, String Susbcription_status, String csr_status,
			String selfservice_status, String Login_status, String zuora_status, String Upsell, String crossell	,String image_status,String product,
			String oid,String premium_product_url, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String cvvCode, String exMonth, String exYear, String nameOnCard,
			String address1, String address2, String city, String state, String country, String postalCode,
			String phoneNum,  String stage_login_url,String type) throws Exception {

		
		START_UPSELL_CROSSELL_PAGE_VALIDATION(execution, Susbcription_status, csr_status, selfservice_status, Login_status,
				zuora_status, Upsell, crossell,image_status,product, oid,premium_product_url, email, Fname, Lname, pwd, confirmpwd, subscriptionType,
				ccNumber, cvvCode, exMonth, exYear, nameOnCard, address1, address2, city, state, country, postalCode,
				phoneNum,  stage_login_url,type,ConstantUtility.upsell_crosssell_sheet);
		
	}
	
	@AfterSuite
	public void aftersuite() throws AddressException, MessagingException, IOException {
		UPSELL_CROSSSELL_USER_END_CONFIGURATION("upsell_crosssell_ec_cc_pages_navigation",ConstantUtility.Upsell_crossell_mail_subject,
				ConstantUtility.Upsell_crossell_mail_body);
	}
	
	
}
