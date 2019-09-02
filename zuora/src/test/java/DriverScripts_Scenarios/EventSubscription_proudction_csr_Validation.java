package DriverScripts_Scenarios;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ConstantUtility;
import PageMethods.CSR_flow_methods;
import PageObjects.CSR_flow_objects;
import TestBase.TestBase;

public class EventSubscription_proudction_csr_Validation extends TestBase{
	@DataProvider
	public Object[][] Data() throws IOException {
		return getData(ConstantUtility.input_excel_for_prodcsr, "urls");
	}
	
	@BeforeSuite
	public void beforesuite() throws IOException, InterruptedException {
		UPSELL_CROSSSELL_USER_START_CONFIGURATIONS();
		/*Load_Url(ConstantUtility.Production_CSR_url);
		csr_objects = PageFactory.initElements(driver, CSR_flow_objects.class);
		CSR_flow_methods.login_csr(csr_objects.csr_login_username, csr_objects.csr_login_password,
				csr_objects.csr_login_submit, ConstantUtility.Production_CSR_user, ConstantUtility.Production_CSR_pwd);*/
	}
	
	/*@Test(dataProvider = "Data")
	public void Do_Parameterization(String execution, String product, String userID,
			String subscriptionID) throws Exception {
		if(execution.equalsIgnoreCase("Yes")) {
		Validate_Production_CSR(execution,product,userID,subscriptionID);
		}else {
		}
	}*/
	
	
	@Test(dataProvider = "Data")
	public void Do_Parameterization(String execution, String url, String email,
			String product) throws Exception {
		
		if(execution.equalsIgnoreCase("Yes")) {
			test = extent.startTest(product + "_" + email );

		Validate_Production_CSR(execution,url,email,product,"Sheet1");
		Clear_Cookies();
		}else {
			System.out.println("unable to execute");
		}
		
	}
	
	@Test
	public void aftersuite() throws AddressException, MessagingException, IOException {
		UPSELL_CROSSSELL_USER_END_CONFIGURATION(ConstantUtility.event_mail_attachment_filename,
				ConstantUtility.event_mail_subject, ConstantUtility.event_mail_body);
	}
}
