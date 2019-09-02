package PageLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ExcelUtility.ConstantUtility;
import PageMethods.CSR_flow_methods;
import PageMethods.Zuora_flow_methods;
import PageObjects.CSR_flow_objects;
import PageObjects.Zuora_flow_objects;
import TestBase.TestBase;

public class CSR_flow_library extends TestBase {

	// public static CSR_flow_objects csr_objects;

	public CSR_flow_library(WebDriver driver) {

		csr_objects = PageFactory.initElements(driver, CSR_flow_objects.class);
		zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);

		

	}

	public void START_CSR(String username, String password,String product, String outputsheet,String email,String pwd)
			throws InterruptedException, IOException {

		CSR_flow_methods.login_csr(csr_objects.csr_login_username, csr_objects.csr_login_password,
				csr_objects.csr_login_submit, username, password);

		CSR_flow_methods.Get_Subscribed_user_data_from_THANKYOU_PAGE(email,pwd, product, outputsheet);

	}

	
	public void ZUORA_FLOW_CSR_INTEGRATION(String username, String password, String email)
			throws Exception {

		CSR_flow_methods.login_csr(csr_objects.csr_login_username, csr_objects.csr_login_password,
				csr_objects.csr_login_submit, username, password);
		
		CSR_flow_methods.search_csr_for_zuora(csr_objects.csr_search_mail, csr_objects.csr_search_submit,
				csr_objects.csr_activateaccount_btn,email);
		
		
		
		/*
		 * driver.get("https://apisandbox.zuora.com/apps/newlogin.do");
		Zuora_flow_methods.login_to_zuora(zuora_objects.zuora_login_username, zuora_objects.zuora_login_password,
				zuora_objects.zuora_login_submit, ConstantUtility.zuora_username, ConstantUtility.zuora_password);
		Thread.sleep(3000);
		driver.get("https://apisandbox.zuora.com/apps/CustomerAccount.do?method=view&id=2c92c0f9638b8faa01638bad0b930698");
		Thread.sleep(3000);
		Zuora_flow_methods.create_new_subscription(zuora_objects.zuora_payment_method_id);*/
		 
		
		
		
	}
}
