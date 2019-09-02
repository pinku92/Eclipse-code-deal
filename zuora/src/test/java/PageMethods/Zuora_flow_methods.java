package PageMethods;

import java.io.IOException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ObjectArrays;
import com.relevantcodes.extentreports.LogStatus;

import ExcelUtility.ConstantUtility;
import ExcelUtility.ExcelReader;
import PageObjects.Zuora_flow_objects;
import TestBase.TestBase;

public class Zuora_flow_methods extends TestBase {

	/*
	 * public static Zuora_flow_objects zuora_objects; public static
	 * Commerce_all_methods commerce_methods;
	 */

	public static void create_zuora_customer_with_csr_id(String csr_id, String mail) throws InterruptedException {

		zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);
		commerce_methods = PageFactory.initElements(driver, Commerce_all_methods.class);

		Create_new_zuora_customer(csr_id, mail, zuora_objects.zuora_add_customer_accountname,
				zuora_objects.zuora_add_customer_userid, zuora_objects.zuora_add_customer_oid,
				zuora_objects.zuora_add_customer_bill_to_contact_fname,
				zuora_objects.zuora_add_customer_bill_to_contact_lname,
				zuora_objects.zuora_add_customer_bill_to_contact_work_email,
				zuora_objects.zuora_add_customer_bill_to_contact_country,
				zuora_objects.zuora_add_customer_bill_to_contact_address1,
				zuora_objects.zuora_add_customer_bill_to_contact_address2,
				zuora_objects.zuora_add_customer_bill_to_contact_city,
				zuora_objects.zuora_add_customer_bill_to_contact_state,
				zuora_objects.zuora_add_customer_bill_to_contact_postalcode,
				zuora_objects.zuora_add_customer_bill_to_contact_credit_card,
				zuora_objects.zuora_add_customer_bill_to_contact_card_number,
				zuora_objects.zuora_add_customer_bill_to_contact_card_select_month,
				zuora_objects.zuora_add_customer_bill_to_contact_card_select_year,
				zuora_objects.zuora_add_customer_bill_to_contact_card_holdername,
				zuora_objects.zuora_add_customer_bill_to_contact_card_select_country,
				zuora_objects.zuora_add_customer_bill_to_contact_card_address,
				zuora_objects.zuora_add_customer_bill_to_contact_card_city,
				zuora_objects.zuora_add_customer_bill_to_contact_card_select_state,
				zuora_objects.zuora_add_customer_bill_to_contact_card_postalcode,
				zuora_objects.zuora_add_customer_bill_to_contact_card_email,
				zuora_objects.zuora_add_customer_bill_to_contact_card_phone,
				zuora_objects.zuora_add_customer_bill_to_contact_card_save);
	}

	public static void INVOICE_VALIDATION(List<WebElement> invoice_id, List<WebElement> invoice_status, String email)
			throws InterruptedException {
		driver.get("https://apisandbox.zuora.com/apps/CustomerAccount.do?menu=Z-Billing#/page/1/tab/1");

		Thread.sleep(3000);

		Search_user(driver, zuora_objects.zuora_customers_search_customer, zuora_objects.zuora_customers_search_button,
				email, zuora_objects.zuora_customers_searched_user_list_view);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.linkText(email)).click();
		Thread.sleep(6000);
		String url = driver.getCurrentUrl();

		Thread.sleep(3000);

		if (invoice_id.size() > 0) {
			String id = invoice_id.get(0).getText();
			System.out.println("INVOICE ID        " + id);
			test.log(LogStatus.PASS, "INVOICE ID for Current Subscriptions" + id);

			if (invoice_status.size() > 0) {
				String status = invoice_status.get(0).getText();
				System.out.println("INVOICE STATUS        " + status);
				Thread.sleep(4000);
				if (status.equalsIgnoreCase("Posted")) {
					
					test.log(LogStatus.PASS, "INVOICE STATUS for Current Subscriptions" + status);
					zuora_pay_process(zuora_objects.zuora_invoice_status_invoice_username,
							zuora_objects.zuora_invoice_status_invoice_password,
							zuora_objects.zuora_invoice_status_invoice_signin, id,
							zuora_objects.zuora_invoice_status_invoice_process_status);
					
				}else if(status.equalsIgnoreCase("Cancelled")) {
					
					test.log(LogStatus.FAIL, "INVOICE STATUS for Current Subscriptions" + status);

				}
			}
		}

		Load_Url(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (int i = 1; i <= 20; i++) {
			Thread.sleep(3000);
			driver.navigate().refresh();
			System.out.println(i + "____Refreshed");
		}

		try {
			Go_Down();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String balance_info = zuora_objects.zuora_invoice_status_balanceinfo.get(0).getText();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if (balance_info.equalsIgnoreCase("0.00 USD")) {
				System.out.println(balance_info);
				System.out.println("No outstandings for this account");
				test.log(LogStatus.PASS, "No outstandings for this account" + balance_info);
				test.log(LogStatus.PASS, "Outstanding amount cleared");
				test.log(LogStatus.PASS, "Bill Run Process cleared");

			} else {
				System.out.println("Yes Outstandings for this account___" + balance_info);
				test.log(LogStatus.FAIL, "Yes Outstandings for this account___" + balance_info);
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Out standing amount still exists");
			test.log(LogStatus.FAIL, "Bill Run Process failed");

		}
	}

	public static void Create_Bill_Run(WebElement create_bill_run_link, List<WebElement> create_bill_run_btn,
			List<WebElement> ok, List<WebElement> email_field, List<WebElement> invoice_id,
			List<WebElement> invoice_status, String outputsheet, String email)
			throws InterruptedException, IOException {

		try {

			driver.get("https://apisandbox.zuora.com/apps/NewBillingRun.do?method=editSimple");
			driver.findElement(By.xpath(".//*[@id='singleAccount']/h2/span")).click();
			WebElement field = driver.findElement(By.xpath(".//*[@id='cusSearch']"));
			field.clear();
			field.sendKeys(email);
			driver.findElement(By.xpath(".//*[@id='listConten2']/a/span")).click();
			Thread.sleep(7000);
			driver.findElement(By.xpath(".//*[@id='ST_yes']/span")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(".//*[@id='confirm_yes']")).click();

			for (int i = 1; i <= 10; i++) {
				driver.navigate().refresh();
				System.out.println(i + "__refreshed");
				Thread.sleep(3000);
			}
			test.log(LogStatus.PASS, "Invoice Generation Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Invoice Generation  Failed");

		}

	}

	public static void Create_Bill_Run_1(WebElement create_bill_run_link, List<WebElement> create_bill_run_btn,
			List<WebElement> ok, List<WebElement> email_field, List<WebElement> invoice_id,
			List<WebElement> invoice_status, String outputsheet, String email)
			throws InterruptedException, IOException {

		try {
			String url = driver.getCurrentUrl();

			Thread.sleep(5000);
			Search_user_by_navigating_to_customer_page_url(url, create_bill_run_link);
			Thread.sleep(2000);
			create_bill_run_link.click();
			if (create_bill_run_btn.size() > 0) {
				commerce_methods.click_button(create_bill_run_btn);
				System.out.println("create_bill_run_btn clicked");
			}
			Thread.sleep(2000);
			if (ok.size() > 0) {
				commerce_methods.click_button(ok);
				System.out.println("subscription_btn clicked");
			}
			for (int i = 1; i <= 10; i++) {
				driver.navigate().refresh();
				System.out.println(i + "__refreshed");
				Thread.sleep(4000);
			}

			Search_user_by_navigating_to_customer_page_url(url, create_bill_run_link);

			if (invoice_id.size() > 0) {
				String id = invoice_id.get(0).getText();
				System.out.println("INVOICE ID        " + id);
				test.log(LogStatus.PASS, "INVOICE ID for Current Subscriptions" + id);

				if (invoice_status.size() > 0) {
					String status = invoice_status.get(0).getText();
					System.out.println("INVOICE STATUS        " + status);
					test.log(LogStatus.PASS, "INVOICE STATUS for Current Subscriptions" + status);
					Thread.sleep(4000);
					if (status.equalsIgnoreCase("Posted")) {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						zuora_pay_process(zuora_objects.zuora_invoice_status_invoice_username,
								zuora_objects.zuora_invoice_status_invoice_password,
								zuora_objects.zuora_invoice_status_invoice_signin, id,
								zuora_objects.zuora_invoice_status_invoice_process_status);
					}
				}
			}
			Search_user_by_navigating_to_customer_page_url(url, create_bill_run_link);
			Thread.sleep(10000);
			driver.navigate().refresh();
			String balance_info = driver.findElement(By.xpath(".//*[@id='invoices']//tr//th[2]/../../tr//td[5]"))
					.getText();
			if (balance_info.equalsIgnoreCase("0.00 USD")) {
				System.out.println(balance_info);
				System.out.println("No outstandings for this account");
				test.log(LogStatus.PASS, "No outstandings for this account" + balance_info);

			} else {
				System.out.println("Yes Outstandings for this account___" + balance_info);
				test.log(LogStatus.FAIL, "Yes Outstandings for this account___" + balance_info);

			}

			Verify_view_all_subscription(outputsheet, email,
					zuora_objects.zuora_customers_subscription_detail_auto_renew,
					zuora_objects.zuora_customers_subscription_detail_promo_code,
					zuora_objects.zuora_customers_subscription_detail_promo_campaign,
					zuora_objects.zuora_customers_subscription_detail_payment_methodid,
					zuora_objects.zuora_customers_subscription_detail_c3orgin_id,
					zuora_objects.zuora_customers_subscription_label,
					zuora_objects.zuora_customers_subscription_product_label, zuora_objects.zuora_subscription_status);
			test.log(LogStatus.PASS, "Bill Run Process Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Bill Run Proces Failed");

		}

	}

	public static void Verify_view_all_subscription(String outputsheet, String email, List<WebElement> auto,
			List<WebElement> code, List<WebElement> camp, List<WebElement> payid, List<WebElement> c3orgin,
			List<WebElement> label, List<WebElement> prod_label, List<WebElement> status)
			throws InterruptedException, IOException {
		// zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);
		/*
		 * jse.executeScript("window.scrollTo(0," +
		 * zuora_objects.zuora_customers_search_list_subscriptiontable_viewall.
		 * getLocation().x + ")");
		 */
		Thread.sleep(2000);
		zuora_objects.zuora_customers_search_list_subscriptiontable_viewall.click();
		Thread.sleep(8000);

		List<WebElement> link = driver.findElements(By.xpath("//a[contains(@onclick,'viewSubscription')]"));
		List<String> link_Text = new ArrayList<String>();

		for (WebElement ele : link) {
			link_Text.add(ele.getText());
			System.out.println(ele.getText());
		}

		Thread.sleep(4000);

		for (String text : link_Text) {
			Thread.sleep(3000);
			driver.findElement(By.linkText(text)).click();
			Access_subscription_detail(outputsheet, email, auto, code, camp, payid, c3orgin, label, prod_label, status);
			Thread.sleep(3000);
			driver.navigate().back();
		}
	}

	public static void Search_user_by_navigating_to_customer_page_url(String url, WebElement bill_run)
			throws InterruptedException {

		Load_Url(url);
		Thread.sleep(6000);

		/*
		 * jse.executeScript("window.scrollBy(0,250)", ""); Thread.sleep(5000);
		 * jse.executeScript("window.scrollTo(0," + bill_run.getLocation().x + ")");
		 */
		Thread.sleep(2000);
	}

	public static void zuora_pay_process(List<WebElement> username, List<WebElement> pwd, List<WebElement> sign,
			String invoice_id, List<WebElement> process_status) throws InterruptedException {

		try {
			Load_Url(ConstantUtility.zuora_invoice_generate_url);
			if (username.size() > 0) {
				commerce_methods.sendkeys(username, ConstantUtility.zuora_invoice_generate_username);
				System.out.println("username entered");
			}
			if (pwd.size() > 0) {
				commerce_methods.sendkeys(pwd, ConstantUtility.zuora_invoice_generate_pwd);
				System.out.println("password entered");
			}
			if (sign.size() > 0) {
				commerce_methods.click_button(sign);
				System.out.println("sign in clicked");
			}

			Thread.sleep(5000);

			Load_Url(ConstantUtility.zuora_invoice_process_string_prefix
					+ ConstantUtility.zuora_invoice_process_string_suffix + invoice_id
					+ ConstantUtility.zuora_invoice_process_string_middle);
			Thread.sleep(3000);

			Load_Url("http://stagezuorapay.thestreet.com/zuora/invoices/instantRunNoLimit");
			// Load_Url("http://192.168.70.247:11001/zuora/invoices/instantRunNoLimit");

			Thread.sleep(10000);
			if (process_status.size() > 0) {
				String output = process_status.get(0).getText();
				if (output.contains("Success")) {
					Takescreenshot(driver,
							"P:\\saravanan\\TheStreet_Automation\\TheStreet_Commerce_Zuora\\src\\test\\java\\Screenshots\\",
							"zuora_pass" + Currentdate_hyphen());

					test.log(LogStatus.PASS, "Invoice Processed successfully");

					System.out.println("Invoice Processed successfully");
				} else {
					Takescreenshot(driver,
							"P:\\saravanan\\TheStreet_Automation\\TheStreet_Commerce_Zuora\\src\\test\\java\\Screenshots\\",
							"zuora_fail" + Currentdate_hyphen());

					test.log(LogStatus.FAIL, "Invoice not Processed ");
					System.out.println("Unable to process your invoice");
					System.out.println(output);

				}
			}
			test.log(LogStatus.PASS, "Payment Process for Current Subscriptions Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Payment Process for Current Subscriptions Failed");
		}

	}

	public static String Get_payment_method_id(List<WebElement> payment_id_link) {

		String pay = payment_id_link.get(0).getAttribute("href");
		String prefix = "javascript:switchPaymentMethodStatus('";
		String suffix = "','Closed',false)";
		String suffix2 = "','Active')";
		String first_txt = pay.replace(prefix, "");
		String first_text = first_txt.replace(suffix, "");
		String second_text = first_text.replace(suffix2, "");

		return second_text;
	}

	public static void create_new_subscription(List<WebElement> payment_id_place, String Product_name, String Rate_plan,
			String email, String outputsheet) throws Exception {
		zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);

		String payment_id = null;
		try {
			Thread.sleep(8000);

			payment_id = Get_payment_method_id(payment_id_place);
			test.log(LogStatus.PASS, "Fetching Payment id Validation Passed ");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Fetching Payment id Validation Failed");

		}
		System.out.println(payment_id);
		zuora_subscription_process(zuora_objects.zuora_create_subscription_btn,
				zuora_objects.zuora_create_subscription_paymentid, payment_id,
				zuora_objects.zuora_create_subscription_productname, Product_name,
				zuora_objects.zuora_create_subscription_legtype, Product_name, Rate_plan,
				zuora_objects.zuora_create_subscription_prodct_dropdown_field,
				zuora_objects.zuora_create_subscription_prodct_dropdown_list,
				zuora_objects.zuora_create_subscription_rateplan_dropdown_field,
				zuora_objects.zuora_create_subscription_rateplan_dropdown_list,
				zuora_objects.zuora_create_subscription_save_activate,
				zuora_objects.zuora_create_subscription_contract_effective,
				zuora_objects.zuora_create_subscription_start_activate, zuora_objects.zuora_create_subscription_save,
				zuora_objects.zuora_create_subscription_invoice_owner, outputsheet, email);

	}

	public static void zuora_subscription_process(List<WebElement> subscription_btn, List<WebElement> payid,
			String payid_data, List<WebElement> product_name, String productname, List<WebElement> legtype,
			String product_id_name, String productid_rateplan, List<WebElement> product_dropdown,
			List<WebElement> product_list_dropdown, List<WebElement> rateplan_dropdown,
			List<WebElement> rateplan_list_dropdown, List<WebElement> send_activate_btn, List<WebElement> CE_date_field,
			List<WebElement> SA_date_field, List<WebElement> save_btn, List<WebElement> invoice_owner,
			String outputsheet, String email) throws Exception {

		try {

			if (subscription_btn.size() > 0) {
				commerce_methods.click_button(subscription_btn);
				System.out.println("subscription_btn clicked");
			}
			if (payid.size() > 0) {
				commerce_methods.sendkeys(payid, payid_data);
				System.out.println("payment id_data  entered");
			}
			if (product_name.size() > 0) {
				commerce_methods.sendkeys(product_name, productname);
				System.out.println("productname data  entered");
			}
			if (legtype.size() > 0) {
				commerce_methods.select_dropdown_1(legtype, "Free Trial");
				System.out.println("legtype  entered");
			}
			Thread.sleep(5000);

			if (product_dropdown.size() > 0) {
				commerce_methods.sendkeys(product_dropdown, product_id_name.trim().toString());
				System.out.println("productname data  entered");
			}
			Thread.sleep(8000);
			if (product_list_dropdown.size() > 0) {
				commerce_methods.select_dropdown_1(product_list_dropdown, product_id_name.trim().toString());
				System.out.println("product_id_name  entered and selected");
			}
			Thread.sleep(5000);

			if (rateplan_dropdown.size() > 0) {
				commerce_methods.sendkeys(rateplan_dropdown, productid_rateplan.trim().toString());
				System.out.println("productname data  entered");
			}
			Thread.sleep(8000);
			if (rateplan_list_dropdown.size() > 0) {
				commerce_methods.select_dropdown_1(rateplan_list_dropdown, productid_rateplan.trim().toString());
				System.out.println("productid_rateplan  entered and selected");
			}
			if (send_activate_btn.size() > 0) {
				commerce_methods.click_button(send_activate_btn);
				System.out.println("send_activate_btn clicked");
			}
			Thread.sleep(7000);
			if (CE_date_field.size() > 0) {
				commerce_methods.sendkeys(CE_date_field, Currentdate1());
				System.out.println("productname data  entered");
			}
			Thread.sleep(5000);

			if (SA_date_field.size() > 0) {
				commerce_methods.sendkeys(SA_date_field, Currentdate1());
				System.out.println("productname data  entered");
			}

			Thread.sleep(3000);

			if (save_btn.size() > 0) {
				commerce_methods.click_button(save_btn);
				System.out.println("save_btn clicked");
			}
			Thread.sleep(10000);

			Access_subscription_detail(outputsheet, email, zuora_objects.zuora_customers_subscription_detail_auto_renew,
					zuora_objects.zuora_customers_subscription_detail_promo_code,
					zuora_objects.zuora_customers_subscription_detail_promo_campaign,
					zuora_objects.zuora_customers_subscription_detail_payment_methodid,
					zuora_objects.zuora_customers_subscription_detail_c3orgin_id,
					zuora_objects.zuora_customers_subscription_label,
					zuora_objects.zuora_customers_subscription_product_label, zuora_objects.zuora_subscription_status);

			if (invoice_owner.size() > 0) {
				commerce_methods.click_button(invoice_owner);
				System.out.println("invoice ownerlink  clicked");
			}
			test.log(LogStatus.PASS, "Subscription Passed for" + productname);
			System.out.println("Subscription Passed for" + productname);
		} catch (Exception e) {
			System.out.println("Subscription Failed for" + productname);
			test.log(LogStatus.FAIL, "Subscription Failed for" + productname);
		}
	}

	public static void Create_new_zuora_customer(String csr_id, String mail, List<WebElement> accountname,
			List<WebElement> userid, List<WebElement> oid, List<WebElement> firstname, List<WebElement> lastname,
			List<WebElement> workemail, List<WebElement> country, List<WebElement> address1, List<WebElement> address2,
			List<WebElement> city, List<WebElement> state, List<WebElement> postalcode, List<WebElement> creditcard,
			List<WebElement> card_no, List<WebElement> card_exp_month, List<WebElement> card_exp_year,
			List<WebElement> card_holder_name, List<WebElement> billing_country, List<WebElement> billing_address,
			List<WebElement> billing_city, List<WebElement> billing_state, List<WebElement> billing_postalcode,
			List<WebElement> billing_email, List<WebElement> billing_phone, List<WebElement> save_customer)
			throws InterruptedException {

		try {
			Load_Url("https://apisandbox.zuora.com/apps/CustomerAccount.do?method=create");

			if (accountname.size() > 0) {
				commerce_methods.sendkeys(accountname, mail);
				System.out.println("CSR id email entered");
			}
			if (userid.size() > 0) {
				commerce_methods.sendkeys(userid, csr_id);
				System.out.println("Userid entered");
			}
			if (oid.size() > 0) {
				commerce_methods.sendkeys(oid, ConstantUtility.zuora_newcustomer_oid);
				System.out.println("OID  entered");
			}
			if (firstname.size() > 0) {
				commerce_methods.sendkeys(firstname, ConstantUtility.zuora_newcustomer_firstname);
				System.out.println("firstname  entered");
			}
			if (lastname.size() > 0) {
				commerce_methods.sendkeys(lastname, ConstantUtility.zuora_newcustomer_lastname);
				System.out.println("lastname  entered");
			}
			if (workemail.size() > 0) {
				commerce_methods.sendkeys(workemail, ConstantUtility.zuora_newcustomer_workemail);
				System.out.println("workemail  entered");
			}
			if (country.size() > 0) {
				commerce_methods.select_dropdown_1(country, ConstantUtility.zuora_newcustomer_country);
				System.out.println("Country  entered");
			}
			if (address1.size() > 0) {
				commerce_methods.sendkeys(address1, ConstantUtility.zuora_newcustomer_address1);
				System.out.println("Address1  entered");
			}
			if (address2.size() > 0) {
				commerce_methods.sendkeys(address2, ConstantUtility.zuora_newcustomer_address2);
				System.out.println("Address2  entered");
			}
			if (city.size() > 0) {
				commerce_methods.sendkeys(city, ConstantUtility.zuora_newcustomer_city);
				System.out.println("City  entered");
			}
			if (state.size() > 0) {
				commerce_methods.select_dropdown_1(state, ConstantUtility.zuora_newcustomer_state);
				System.out.println("State  entered");
			}
			if (postalcode.size() > 0) {
				commerce_methods.sendkeys(postalcode, ConstantUtility.zuora_newcustomer_postalcode);
				System.out.println("Postalcode  entered");
			}
			Thread.sleep(5000);

			if (creditcard.size() > 0) {
				commerce_methods.click_button(creditcard);
				System.out.println("creditcard clicked");
			}
			Thread.sleep(5000);

			if (card_no.size() > 0) {
				commerce_methods.sendkeys(card_no, ConstantUtility.zuora_newcustomer_card_number);
				System.out.println("card_no  entered");
			}
			Thread.sleep(3000);

			if (card_exp_month.size() > 0) {
				commerce_methods.select_dropdown_1(card_exp_month, ConstantUtility.zuora_newcustomer_card_month);
				System.out.println("card_month  entered");
			}
			Thread.sleep(3000);

			if (card_exp_year.size() > 0) {
				commerce_methods.select_dropdown_1(card_exp_year, ConstantUtility.zuora_newcustomer_card_year);
				System.out.println("card_exp_year  entered");
			}
			Thread.sleep(3000);

			if (card_holder_name.size() > 0) {
				commerce_methods.sendkeys(card_holder_name, ConstantUtility.zuora_newcustomer_card_holder_name);
				System.out.println("card_holder_name  entered");
			}
			Thread.sleep(3000);

			if (billing_country.size() > 0) {
				commerce_methods.select_dropdown_1(billing_country,
						ConstantUtility.zuora_newcustomer_card_billing_country);
				System.out.println("billing_country  entered");
			}
			Thread.sleep(3000);

			if (billing_address.size() > 0) {
				commerce_methods.sendkeys(billing_address, ConstantUtility.zuora_newcustomer_card_billing_address);
				System.out.println("billing_address  entered");
			}
			if (billing_city.size() > 0) {
				commerce_methods.sendkeys(billing_city, ConstantUtility.zuora_newcustomer_card_billing_city);
				System.out.println("billing_city  entered");
			}
			Thread.sleep(3000);

			if (billing_state.size() > 0) {
				commerce_methods.select_dropdown_1(billing_state, ConstantUtility.zuora_newcustomer_card_billing_state);
				System.out.println("billing_state  entered");
			}
			Thread.sleep(3000);

			if (billing_postalcode.size() > 0) {
				commerce_methods.sendkeys(billing_postalcode,
						ConstantUtility.zuora_newcustomer_card_billing_postalcode);
				System.out.println("billing_postalcode  entered");
			}
			if (billing_email.size() > 0) {
				commerce_methods.sendkeys(billing_email, ConstantUtility.zuora_newcustomer_card_billing_email);
				System.out.println("billing_email  entered");
			}
			Thread.sleep(3000);

			if (billing_phone.size() > 0) {
				commerce_methods.sendkeys(billing_phone, ConstantUtility.zuora_newcustomer_card_billing_phone);
				System.out.println("billing_phone  entered");
			}
			Thread.sleep(3000);

			if (save_customer.size() > 0) {
				commerce_methods.click_button(save_customer);
				System.out.println("save_customer clicked");
			}
			test.log(LogStatus.PASS, "ZUORA Customer creation Validation Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "ZUORA Customer creation Validation Failed");

		}

	}

	public static void login_to_zuora(List<WebElement> username, List<WebElement> pwd, List<WebElement> submit,
			String username_data, String password) throws InterruptedException {

		try {

			Thread.sleep(8000);

			System.out.println("inside login to zuora1");

			if (username.size() > 0) {

				System.out.println("inside login to zuora2");

				commerce_methods.sendkeys(username, username_data);

				System.out.println("inside login to zuora3");
				System.out.println("username entered");
			}
			if (pwd.size() > 0) {
				commerce_methods.sendkeys(pwd, password);
				System.out.println("password entered");
			}
			if (submit.size() > 0) {
				commerce_methods.click_button(submit);
				System.out.println("submit clicked");
			}

			test.log(LogStatus.PASS, "Login in to Zuora Validation Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login in to  Zuora Validation Failed");

			System.out.println(e);

		}
	}

	public static void Search_user(WebDriver driver, List<WebElement> searchbox, List<WebElement> searchbtn,
			String email, List<WebElement> list_viewbtn) throws InterruptedException {

		try {
			Thread.sleep(5000);

			if (searchbox.size() > 0) {

				commerce_methods.sendkeys(searchbox, email);
				System.out.println("Search email  entered");
			}
			if (searchbtn.size() > 0) {
				commerce_methods.click_button(searchbtn);
				System.out.println("Search submit clicked");
			}
			
			driver.findElement(By.xpath("//div[@id='listView']")).click();

			Thread.sleep(12000);
			test.log(LogStatus.PASS, "Search user in Zuora Validation Passed for ____" + email);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Search user in Zuora Validation Failed ");
		}

	}

	/*public static String[] check_and_update_subscription_table_data(List<WebElement> number, List<WebElement> product,
			List<WebElement> startdate, List<WebElement> enddate, List<WebElement> status) throws IOException {

		String snumber = number.get(0).getText().toString().trim();
		String sproduct = product.get(0).getText().toString().trim();
		String sstartdate = startdate.get(0).getText().toString().trim();
		String senddate = enddate.get(0).getText().toString().trim();
		String sstatus = status.get(0).getText().toString().trim();
		String subscriptiontable_data[] = { snumber, sproduct, sstartdate, senddate, sstatus };
		return subscriptiontable_data;

	}*/

	public static void Access_user_detail(List<WebElement> email_link, List<WebElement> email_link2, String outputsheet,
			String email) throws InterruptedException, IOException {

		try {
			Thread.sleep(10000);
			if (email_link.size() > 0) {
				String text = email_link.get(0).getText();
				driver.findElement(By.linkText(text)).click();
			} else if (email_link2.size() > 0) {
				String text1 = email_link2.get(0).getText();
				driver.findElement(By.linkText(text1)).click();
			} else {
				System.out.println("No email found in zuora");
			}
			Thread.sleep(5000);

			/*
			 * jse.executeScript("window.scrollBy(0,250)", ""); Thread.sleep(5000);
			 * jse.executeScript("window.scrollTo(0," +
			 * zuora_objects.zuora_customers_search_list_subscriptiontable_viewall.
			 * getLocation().x + ")");
			 */
			Thread.sleep(2000);
			zuora_objects.zuora_customers_search_list_subscriptiontable_viewall.click();
			Thread.sleep(4000);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Zuora Validation Failed for__" + email);
		}
	}

	public static void Merge_data_array(String[] a, String[] b, String sheet) throws IOException {
		String[] joined = ObjectArrays.concat(a, b, String.class);
		ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\Testdata\\Outputs\\", "result.xlsx", sheet,
				joined);
	}

	public static void Access_subscription_detail(String sheet, String email, List<WebElement> auto_renew,
			List<WebElement> promo_code, List<WebElement> promo_camp, List<WebElement> pay_methods_id,
			List<WebElement> c3_oid, List<WebElement> sublabel, List<WebElement> subproduct_label,
			List<WebElement> status) throws InterruptedException, IOException {

		try {
			Thread.sleep(4000);
			String sauto_renew = auto_renew.get(0).getText().toString().trim();
			String spromo_code = promo_code.get(0).getText().toString().trim();
			String spromo_camp = promo_camp.get(0).getText().toString().trim();
			String spay_methods_id = pay_methods_id.get(0).getText().toString().trim();
			String sc3_oid = c3_oid.get(0).getText().toString().trim();
			String ssublabel = sublabel.get(0).getText().toString().trim();
			String ssubproduct_label = subproduct_label.get(0).getText().toString().trim();
			String sstatus = status.get(0).getText().toString().trim();

			String subscriptiontable_data[] = { ssublabel, ssubproduct_label, sauto_renew, spromo_code, spromo_camp,
					spay_methods_id, sc3_oid, email, sstatus };

			ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\Testdata\\Outputs\\", "result.xlsx",
					sheet, subscriptiontable_data);

			test.log(LogStatus.PASS, "Zuora Validation and subscription details fetched  for __"
					+ zuora_objects.zuora_customers_subscription_product_label.get(0).getText());

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to fetch Zuora Validation and subscription details for __"
					+ zuora_objects.zuora_customers_subscription_product_label.get(0).getText());
			System.out.println(e);
		}
	}

	public static void search_user_in_zuora(WebDriver driver, String inputsheet, String outputsheet, String scenario)
			throws InterruptedException, IOException {
		zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);

		try {

			if (scenario.equalsIgnoreCase("Random")) {
				Thread.sleep(5000);
				ExcelReader xlsreader = new ExcelReader(
						System.getProperty("user.dir") + "//src//test//java//Testdata//Outputs//" + "result.xlsx");
				int RowSize = xlsreader.getRowCount(inputsheet);
				for (int i = 2; i <= RowSize; i++) {
					try {
						String email = xlsreader.getCellData(inputsheet, 0, i);
						System.out.println(email);
						Thread.sleep(5000);
						
						// subscription_page

						driver.get("https://apisandbox.zuora.com/apps/Subscription.do?menu=Z-Billing");
						Thread.sleep(5000);
						
						
						
						Search_user(driver, zuora_objects.zuora_subscription_search_customer,
								zuora_objects.zuora_subscription_search_button, email,
								zuora_objects.zuora_customers_searched_user_list_view);
						
						
						Thread.sleep(8000);
						List<WebElement> list_view = driver.findElements(By.xpath("//div[@id='listView']"));
						highlighElement(driver, list_view);
						list_view.get(0).click();
						List<WebElement> link = driver.findElements(By.xpath(
								".//*[@id='subscription_list']//table//tr//td//a[contains(@onclick,'viewSubscription')]"));
						for (int j = 0; j < link.size(); j++) {
							System.out.println("size of subscription ids" + link.size());
							System.out.println(link.get(j).getText());
							String subid = link.get(j).getText();
							Thread.sleep(6000);
							Search_user(driver, zuora_objects.zuora_subscription_search_customer,
									zuora_objects.zuora_subscription_search_button, subid,
									zuora_objects.zuora_customers_searched_user_list_view);
							Thread.sleep(6000);
							List<WebElement> subscription_id = driver.findElements(By.linkText(subid));
							highlighElement(driver, subscription_id);
							subscription_id.get(0).click();
							
							Thread.sleep(6000);

							Access_subscription_detail(outputsheet, email,
									zuora_objects.zuora_customers_subscription_detail_auto_renew,
									zuora_objects.zuora_customers_subscription_detail_promo_code,
									zuora_objects.zuora_customers_subscription_detail_promo_campaign,
									zuora_objects.zuora_customers_subscription_detail_payment_methodid,
									zuora_objects.zuora_customers_subscription_detail_c3orgin_id,
									zuora_objects.zuora_customers_subscription_label,
									zuora_objects.zuora_customers_subscription_product_label,
									zuora_objects.zuora_subscription_status);
							// driver.navigate().back();
						}
					} catch (Exception e) {
						System.out.println(e);
					}

				}

			} else if (scenario.equalsIgnoreCase("Normal")) {
				Thread.sleep(5000);

				ExcelReader xlsreader = new ExcelReader(
						System.getProperty("user.dir") + "//src//test//java//Testdata//Outputs//" + "result.xlsx");
				int RowSize = xlsreader.getRowCount(inputsheet);

				String email = xlsreader.getCellData(inputsheet, 0, 2);
				Thread.sleep(5000);

				driver.get("https://apisandbox.zuora.com/apps/Subscription.do?menu=Z-Billing");
				Thread.sleep(5000);

				Search_user(driver, zuora_objects.zuora_subscription_search_customer,
						zuora_objects.zuora_subscription_search_button, email,
						zuora_objects.zuora_customers_searched_user_list_view);

				Thread.sleep(8000);
				List<WebElement> list_view = driver.findElements(By.xpath("//div[@id='listView']"));
				highlighElement(driver, list_view);
				list_view.get(0).click();
//				driver.findElement(By.xpath("//div[@id='listView']")).click();

				List<WebElement> link = driver.findElements(By.xpath(
						".//*[@id='subscription_list']//table//tr//td//a[contains(@onclick,'viewSubscription')]"));
				List<String> link_Text = new ArrayList<String>();

				for (WebElement ele : link) {
					link_Text.add(ele.getText());
					System.out.println(ele.getText());
				}

				for (String text : link_Text) {

					Search_user(driver, zuora_objects.zuora_subscription_search_customer,
							zuora_objects.zuora_subscription_search_button, text,
							zuora_objects.zuora_customers_searched_user_list_view);

					List<WebElement> subscription_id2 = driver.findElements(By.linkText(text));
					highlighElement(driver, subscription_id2);
					subscription_id2.get(0).click();
					
//					driver.findElement(By.linkText(text)).click();
					Thread.sleep(6000);

					Access_subscription_detail(outputsheet, email,
							zuora_objects.zuora_customers_subscription_detail_auto_renew,
							zuora_objects.zuora_customers_subscription_detail_promo_code,
							zuora_objects.zuora_customers_subscription_detail_promo_campaign,
							zuora_objects.zuora_customers_subscription_detail_payment_methodid,
							zuora_objects.zuora_customers_subscription_detail_c3orgin_id,
							zuora_objects.zuora_customers_subscription_label,
							zuora_objects.zuora_customers_subscription_product_label,
							zuora_objects.zuora_subscription_status);
					driver.get("https://apisandbox.zuora.com/apps/Subscription.do?menu=Z-Billing");

					// driver.navigate().back();
				}

			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Zuora Validation Failed  ");

		}

	}

	public static void verify_zuora_user(String username_data, String password, String mailid, String accid)
			throws InterruptedException {

		zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);

		try {
			Load_Url("https://apisandbox.zuora.com/apps");

			login_to_zuora(zuora_objects.zuora_login_username, zuora_objects.zuora_login_password,
					zuora_objects.zuora_login_submit, username_data, password);
			Thread.sleep(4000);

			Load_Url("https://apisandbox.zuora.com/apps/CustomerAccount.do?menu=Z-Billing#/page/1/tab/1");
			Thread.sleep(4000);

			Search_user(driver, zuora_objects.zuora_customers_search_customer,
					zuora_objects.zuora_customers_search_button, mailid,
					zuora_objects.zuora_customers_searched_user_list_view);
			Thread.sleep(4000);

			String result_mail = null;
			if (zuora_objects.zuora_subscription_search_user_list.size() > 0) {
				result_mail = zuora_objects.zuora_subscription_search_user_list.get(0).getText().toString().trim();
				if (result_mail.equalsIgnoreCase(mailid)) {
					System.out.println("Account already exists");
					test.log(LogStatus.INFO, "User found in Zuora Validation  ");

					zuora_objects.zuora_subscription_search_user_list.get(0).click();

				} else {
					test.log(LogStatus.INFO, "No User found in Zuora Validation  ");
					System.out.println("No Account  exists");

				}
			} else {
				System.out.println("No search list So need to create a new customer in ZUORA");
				Thread.sleep(4000);
				create_zuora_customer_with_csr_id(accid, mailid);
			}

			test.log(LogStatus.PASS, "Zuora user Validation Passed  ");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Zuora user Validation Failed  ");

		}

	}

	public static String Get_contract_date(List<WebElement> morebtn, List<WebElement> previewlink,
			List<WebElement> contractdate, List<WebElement> done) throws InterruptedException {

		String date = null;

		try {
			if (morebtn.size() > 0) {
				commerce_methods.click_button(morebtn);
				System.out.println("More button clicked");
			}

			if (previewlink.size() > 0) {
				commerce_methods.click_button(previewlink);
				System.out.println("previewlink button clicked");
			}

			date = contractdate.get(0).getAttribute("value");
			System.out.println(date);

			if (done.size() > 0) {
				commerce_methods.click_button(done);
				System.out.println("done button clicked");
			}
			test.log(LogStatus.PASS, "Contract Effective date Fetched");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to fetch Contract Effective date");

		}

		return date;

	}

	public static void Cancel_individual_susbcription(List<WebElement> cancel_btn,
			List<WebElement> contract_effectivedate, List<WebElement> cancellation_effectivedate,
			List<WebElement> cancellationdate, List<WebElement> savebtn, String date, String currentdate)
			throws InterruptedException {

		try {
			if (cancel_btn.size() > 0) {
				commerce_methods.click_button(cancel_btn);
				System.out.println("cancel_btn button clicked");
				if (contract_effectivedate.size() > 0) {
					Thread.sleep(2000);
					commerce_methods.click_button(contract_effectivedate);
					commerce_methods.sendkeys(contract_effectivedate, date);
					System.out.println("contract_effectivedate  entered");
				}
				if (cancellation_effectivedate.size() > 0) {
					Thread.sleep(2000);

					commerce_methods.select_dropdown(cancellation_effectivedate, "Enter a Date");
					System.out.println("Enter a Date  entered");
				}

				if (cancellationdate.size() > 0) {
					Thread.sleep(2000);

					commerce_methods.sendkeys(cancellationdate, currentdate);
					System.out.println("contract_effectivedate  entered");
				}
				Thread.sleep(2000);

				if (savebtn.size() > 0) {
					commerce_methods.click_button(savebtn);
					System.out.println("savebtn button clicked");
				}
				Thread.sleep(2000);

			} else {
				System.out.println("Cancel button is not available");

			}

			test.log(LogStatus.PASS, "Zuora cancel process passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Zuora cancel process failed");

			System.out.println("Cancel process failed");
		}

	}

	public static void Cancel_Subscription(String email, String outputsheet) throws InterruptedException {
		zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);

		try {
			Thread.sleep(2000);
			// driver.findElement(By.linkText(email)).click();
			Thread.sleep(8000);

			/*
			 * jse.executeScript("window.scrollBy(0,250)", "");
			 * jse.executeScript("window.scrollBy(0,250)", "");
			 * jse.executeScript("window.scrollBy(0,250)", "");
			 * jse.executeScript("window.scrollBy(0,250)", "");
			 */

			List<WebElement> link = driver.findElements(
					By.xpath(".//*[@id='subscription_list']//table//tr//td//a[contains(@onclick,'viewSubscription')]"));
			List<String> link_Text = new ArrayList<String>();

			for (WebElement ele : link) {
				link_Text.add(ele.getText());
				System.out.println(ele.getText());
			}

			for (String text : link_Text) {

				Search_user(driver, zuora_objects.zuora_subscription_search_customer,
						zuora_objects.zuora_subscription_search_button, text,
						zuora_objects.zuora_customers_searched_user_list_view);

				driver.findElement(By.linkText(text)).click();

				String date = Get_contract_date(zuora_objects.zuora_subscription_more_btn,
						zuora_objects.zuora_subscription_more_preview_link,
						zuora_objects.zuora_subscription_contract_effective_date,
						zuora_objects.zuora_subscription_more_preview_done_button);
				System.out.println(date);

				Thread.sleep(5000);

				try {
					Cancel_individual_susbcription(zuora_objects.zuora_subscription_cancel_btn,
							zuora_objects.zuora_subscription_cancel_contract_effectivedate,
							zuora_objects.zuora_subscription_cancel_effetcive_date,
							zuora_objects.zuora_subscription_cancel_date,
							zuora_objects.zuora_subscription_cancel_save_button, date, Currentdate1());
				} catch (Exception e1) {

				}

				Thread.sleep(5000);

				try {

					Access_subscription_detail(outputsheet, email,
							zuora_objects.zuora_customers_subscription_detail_auto_renew,
							zuora_objects.zuora_customers_subscription_detail_promo_code,
							zuora_objects.zuora_customers_subscription_detail_promo_campaign,
							zuora_objects.zuora_customers_subscription_detail_payment_methodid,
							zuora_objects.zuora_customers_subscription_detail_c3orgin_id,
							zuora_objects.zuora_customers_subscription_label,
							zuora_objects.zuora_customers_subscription_product_label,
							zuora_objects.zuora_subscription_status);
					driver.navigate().back();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			test.log(LogStatus.PASS, "Zuora Cancellation  PASSED for __" + email);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Zuora Cancellation Failed for __" + email);

			System.out.println(e);
		}

	}

	public static void bill_run_validation(String browser, String url, String username, String pwd, String email)
			throws InterruptedException {

	}

}
