package PageLibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ExcelUtility.ConstantUtility;
import PageMethods.Commerce_all_methods;
import PageMethods.Zuora_flow_methods;
import PageObjects.CSR_flow_objects;
import PageObjects.Zuora_flow_objects;
import TestBase.TestBase;

public class Zuora_flow_library extends TestBase {

	public Zuora_flow_library(WebDriver driver) {
		zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);
	}

	public static void START_ZUORA(String username_data, String password, String inputsheet, String outputsheet,
			String scenario) throws InterruptedException, IOException {
		Zuora_flow_methods.login_to_zuora(zuora_objects.zuora_login_username, zuora_objects.zuora_login_password,
				zuora_objects.zuora_login_submit, username_data, password);
		Zuora_flow_methods.search_user_in_zuora(driver, inputsheet, outputsheet, scenario);
	}

	public static void START_PROCESS_ZUORA_SUBSCRIPTION(String Product_name, String Rate_plan, String email,
			String outputsheet) throws Exception {
		Thread.sleep(5000);
		Zuora_flow_methods.create_new_subscription(zuora_objects.zuora_payment_method_id, Product_name, Rate_plan,
				email, outputsheet);
	}

	public static void BILL_RUN_PROCESS(String outputsheet, String email) throws InterruptedException, IOException {

		Zuora_flow_methods.Create_Bill_Run(zuora_objects.zuora_create_billrun_link,
				zuora_objects.zuora_create_billrun_button, zuora_objects.zuora_confirm_ok,
				zuora_objects.zuora_add_customer_accountname, zuora_objects.zuora_invoice_id_from_subscription_page,
				zuora_objects.zuora_invoice_status_from_subscription_page, outputsheet, email);
		Clear_Cookies();
		closebrowser();
		
	}

	public static void BILL_RUN_VALIDATION_PROCESS(String username,String pwd,String email) throws InterruptedException {
 		try {

			Zuora_flow_methods.login_to_zuora(zuora_objects.zuora_login_username, zuora_objects.zuora_login_password,
					zuora_objects.zuora_login_submit,username, pwd);
			Thread.sleep(8000);
			Zuora_flow_methods.INVOICE_VALIDATION(zuora_objects.zuora_invoice_id_from_subscription_page,
					zuora_objects.zuora_invoice_status_from_subscription_page, email);
		} catch (Exception e) {
			e.printStackTrace();
			}

	}
	
	public static void start_zuora_cancellation(String email, String username, String password, String outputsheet)
			throws InterruptedException {
		Zuora_flow_methods.login_to_zuora(zuora_objects.zuora_login_username, zuora_objects.zuora_login_password,
				zuora_objects.zuora_login_submit, username, password);
		Thread.sleep(4000);
		driver.get("https://apisandbox.zuora.com/apps/Subscription.do?menu=Z-Billing");
		Thread.sleep(5000);
		Zuora_flow_methods.Search_user(driver, zuora_objects.zuora_subscription_search_customer,
				zuora_objects.zuora_subscription_search_button, email,
				zuora_objects.zuora_customers_searched_user_list_view);
		Thread.sleep(8000);
		Zuora_flow_methods.Cancel_Subscription(email, outputsheet);
	}

}
