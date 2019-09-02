package PageLibrary;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import PageMethods.Commerce_all_methods;
import PageObjects.Signup_flow_objects;
import TestBase.TestBase;

public class Signupflow_library extends TestBase

{
	public static Signup_flow_objects signupflow_objects;

	public Signupflow_library(WebDriver driver) {
		signupflow_objects = PageFactory.initElements(driver, Signup_flow_objects.class);
	}

	
	
	
	public void SUBSCRIBE_STAGE_EVENTS(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		String[] a = null;

		String[] b = null;
		try {
			System.out.println(email);

			try {
				Commerce_all_methods.start_event_subscription(driver, signupflow_objects.aap_stage_mlp_btn,
						signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
						signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
						signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
						signupflow_objects.aap_stage_cc_subscriptionplan_Monthly,
						signupflow_objects.aap_stage_cc_subscriptionplan_Annual,
						signupflow_objects.aap_stage_cc_subscriptionplan_Two_year,
						signupflow_objects.aap_stage_cc_creditcard_holder_name,
						signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
						signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
						signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
						signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
						signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
						signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
						email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
						nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell,
						crossell, image_status);
				test.log(LogStatus.PASS,
						"Event Ticket Subscription Passed");
			} catch (Exception e1) {
				test.log(LogStatus.FAIL,
						"Event Ticket Subscription Failed");
			}

			try {
				Thread.sleep(3000);

				a = Commerce_all_methods.Update_Event_Thankyou_page_information_array(oid,
						signupflow_objects.events_stage_ty_email_data, signupflow_objects.events_stage_ty_tickets_data,
						signupflow_objects.events_stage_ty_amount_data, sheetname);
				System.out.println(a);
				
				test.log(LogStatus.PASS,
						"Event Ticket Subscription Details Fetched");
				
			} catch (Exception e2) {
				test.log(LogStatus.FAIL,
						"Event Ticket Subscription Details Failed to Fetch");
			}

			try {

				Scroll_Down(600);

				Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
						signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
						signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);
				
				
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						"Event Ticket Subscription Upsell/crossell Failed");
			}

			
			List<WebElement> return_to_event = driver.findElements(By.xpath("//a[@class=' btn-submit'][contains(.,'Return to Event Site')]"));
			if(return_to_event.size()>0) {
				System.out.println("No need to do Upsell or cross-sell");
			}else {
				try {
					Thread.sleep(3000);

					b = Commerce_all_methods.Update_Thankyou_page_information_array(
							signupflow_objects.dummy_stage_ty_email_data, signupflow_objects.aap_stage_ty_email_data,
							signupflow_objects.aap_stage_ty_accountid_data,
							signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
							signupflow_objects.aap_stage_ty_freetrialdays_data,
							signupflow_objects.aap_stage_ty_subscribedon_data, signupflow_objects.access_new_product_data,
							sheetname, product, url);
					System.out.println(b);

				} catch (Exception e) {
					test.log(LogStatus.FAIL,
							"Event Ticket Subscription Upsell/crossell detail failed to fetch");
				}
			}
			
			try {
				Commerce_all_methods.Merge_data_array(a, b, sheetname);
			} catch (Exception e) {

			}

		} catch (Exception e) {
		}
	}

	
	public void SUBSCRIBE_STAGE_VALIDATION(WebDriver driver, String url, String upsell, String crossell, String image_status,
			String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {
		try {
			System.out.println(email);

			Commerce_all_methods.start_subscription_validation(driver, signupflow_objects.aap_stage_mlp_btn,
					signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
					signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
					signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
					signupflow_objects.aap_stage_cc_subscriptionplan_Monthly,
					signupflow_objects.aap_stage_cc_subscriptionplan_Annual,
					signupflow_objects.aap_stage_cc_subscriptionplan_Two_year,
					signupflow_objects.aap_stage_cc_creditcard_holder_name,
					signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
					signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
					signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
					signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
					signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
					signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
					email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell,
					crossell, image_status);

	
		} catch (Exception e) {
		}
	}
	
	public void SUBSCRIBE_STAGE_AAP(WebDriver driver, String url, String upsell, String crossell, String image_status,
			String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {
		try {
			System.out.println(email);

			Commerce_all_methods.start_product_subscription(driver, signupflow_objects.aap_stage_mlp_btn,
					signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
					signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
					signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
					signupflow_objects.aap_stage_cc_subscriptionplan_Monthly,
					signupflow_objects.aap_stage_cc_subscriptionplan_Annual,
					signupflow_objects.aap_stage_cc_subscriptionplan_Two_year,
					signupflow_objects.aap_stage_cc_creditcard_holder_name,
					signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
					signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
					signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
					signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
					signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
					signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
					email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell,
					crossell, image_status);

			Thread.sleep(5000);

			Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
					signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
					signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

			Thread.sleep(5000);

			Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
					signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
					signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
					signupflow_objects.aap_stage_ty_freetrialdays_data,
					signupflow_objects.aap_stage_ty_subscribedon_data, signupflow_objects.access_new_product_data,
					sheetname, product, url);
		} catch (Exception e) {
		}
	}

	public void SUBSCRIBE_STAGE_RMY(WebDriver driver, String url, String upsell, String crossell, String image_status,
			String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.aap_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.NULL_Element, signupflow_objects.rmy_stage_cc_subscriptionplan_Annual,
				signupflow_objects.rmy_stage_cc_subscriptionplan_Two_year,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_INCOME_SEEKER(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.income_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.NULL_Element, signupflow_objects.income_stage_cc_subscriptionplan_Annual,
				signupflow_objects.NULL_Element, signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_RMY_PRO(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.rmypro_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.rmypro_stage_cc_subscriptionplan_Monthly,
				signupflow_objects.rmypro_stage_cc_subscriptionplan_Annual, signupflow_objects.NULL_Element,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_QUANT_RATINGS(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.aap_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.quantratings_stage_cc_subscriptionplan_Monthly,
				signupflow_objects.quantratings_stage_cc_subscriptionplan_Annual, signupflow_objects.NULL_Element,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_STOCKS_UNDER(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.aap_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.stocksunder_stage_cc_subscriptionplan_Monthly,
				signupflow_objects.stocksunder_stage_cc_subscriptionplan_Annual,
				signupflow_objects.stocksunder_stage_cc_subscriptionplan_twoyear,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_TRIFECTA(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.trifecta_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.trifecta_stage_cc_subscriptionplan_Monthly,
				signupflow_objects.trifecta_stage_cc_subscriptionplan_Annual,
				signupflow_objects.trifecta_stage_cc_subscriptionplan_twoyear,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_RMY_PRO_PORTFOLIO(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.rmypro_portfolio_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.rmyportfolio_stage_cc_subscriptionplan_Monthly,
				signupflow_objects.rmyportfolio_stage_cc_subscriptionplan_Annual, signupflow_objects.NULL_Element,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_TOP_STOCKS(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.top_stocks_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.topstocks_stage_cc_subscriptionplan_Monthly,
				signupflow_objects.topstocks_stage_cc_subscriptionplan_Annual, signupflow_objects.NULL_Element,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_CHAIRMAN_CLUB(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.chairman_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.NULL_Element, signupflow_objects.chairman_stage_cc_subscriptionplan_Annual,
				signupflow_objects.NULL_Element, signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_CHATTER(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.chatter_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.chatter_stage_cc_subscriptionplan_Monthly,
				signupflow_objects.chatter_stage_cc_subscriptionplan_Annual, signupflow_objects.NULL_Element,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.dummy_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

	public void SUBSCRIBE_STAGE_RETIREMENT(WebDriver driver, String url, String upsell, String crossell,
			String image_status, String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type)
			throws InterruptedException, IOException {

		Commerce_all_methods.start_product_subscription(driver, signupflow_objects.aap_stage_mlp_btn,
				signupflow_objects.aap_stage_ec_emailfield, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				signupflow_objects.aap_stage_cc_fname, signupflow_objects.aap_stage_cc_lname,
				signupflow_objects.aap_stage_cc_password, signupflow_objects.aap_stage_cc_confirmpassword,
				signupflow_objects.retirement_stage_cc_subscriptionplan_Monthly,
				signupflow_objects.retirement_stage_cc_subscriptionplan_Annual,
				signupflow_objects.retirement_stage_cc_subscriptionplan_twoyear,
				signupflow_objects.aap_stage_cc_creditcard_holder_name,
				signupflow_objects.aap_stage_cc_creditcard_number, signupflow_objects.aap_stage_cc_creditcard_month,
				signupflow_objects.aap_stage_cc_creditcard_year, signupflow_objects.aap_stage_cc_creditcard_cvv,
				signupflow_objects.aap_stage_cc_address1, signupflow_objects.aap_stage_cc_address2,
				signupflow_objects.aap_stage_cc_city, signupflow_objects.aap_stage_cc_state,
				signupflow_objects.aap_stage_cc_postalcode, signupflow_objects.aap_stage_cc_country,
				signupflow_objects.aap_stage_cc_contactnum, signupflow_objects.aap_stage_ec_emailfield_continuebtn,
				email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
				nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, type, oid, upsell, crossell,
				image_status);

		Thread.sleep(5000);

		Commerce_all_methods.Validate_Upsell_Crossell(upsell, crossell, signupflow_objects.aap_upsell_yes,
				signupflow_objects.aap_upsell_no, signupflow_objects.aap_crossell_yes,
				signupflow_objects.aap_crossell_no, product, type, subscriptionType, oid, image_status);

		Thread.sleep(5000);
		Commerce_all_methods.Update_Thankyou_page_information(signupflow_objects.ret_stage_ty_email_data,
				signupflow_objects.aap_stage_ty_email_data, signupflow_objects.aap_stage_ty_accountid_data,
				signupflow_objects.aap_stage_ty_subscriptionid_data, signupflow_objects.aap_stage_ty_term_data,
				signupflow_objects.aap_stage_ty_freetrialdays_data, signupflow_objects.aap_stage_ty_subscribedon_data,
				signupflow_objects.access_new_product_data, sheetname, product, url);

	}

}
