package ExcelUtility;

import java.util.List;
import java.util.Properties;

import javax.mail.Multipart;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebElement;

import TestBase.TestBase;

public class ConstantUtility extends TestBase {

	
	public static String input_excel_for_prodcsr = "thestreet_events.xlsx";
	public static String events_path = "\\\\chnnas02//TheStreet_Automation//Automation_Reports//Ashots_gallery//Events//Aug_17_2018";
	public static String upsell_crossell_path = "\\\\chnnas02//TheStreet_Automation//Automation_Reports//Ashots_gallery//upsell_crosssell/October_10";
	
	public static String compared_upsell_crosssell_x_path ="\\\\chnnas02//TheStreet_Automation//Automation_Reports//Ashots_gallery//upsell_crosssell//October_05";
	
	public static String compared_events_x_path = "\\\\chnnas02//TheStreet_Automation//Automation_Reports//Ashots_gallery//Events//Aug_17_2018";
	
	
	public static String input_excel = "Commerce_input.xlsx";
	public static String random_input_excel_emailsheet = "Zuora_Random_user";
	public static String commerce_report_location = "CommerceReports";
	public static String csr_url = "https://stagesecure2.thestreet.com/cap/csr/search.jsp";
	public static String stageTstng_url = "http://stagemobi.thestreet.com/personal-finance/real-estate/test-headline-2409-10667483";
	public static String csr_username = "shilpaba";
	public static String csr_pwd = "thestreet";
	public static String random_self_sheet = "Random_Selfservice";
	public static String random_thankyou_page = "Random_Subscriptions";
	public static String Event_subscription = "Event_Tickets";
	public static String upsell_crosssell_sheet = "Upsell_Crosssell_flow";
	public static String upsell_crosssell_pages_sheet_ = "Upsell_Crosssell_pages";

	
	
	public static String random_csr_sheet = "Random_csr";
	public static String random_zuora_sheet = "Zuora_Randomuser";
	public static String randomuser_scenario_report = "RandomUser_";
	public static String update_random_email = "Random_Email";
	public static String browser = "chrome";
	public static String mail_suffix = Currentdate_hyphen() + "@mailinator.com";
	// public static String mail_suffix =
	// Get_Random_values()+Currentdate_hyphen()+"@mailinator.com";
	public static String auto_email = "";
	public static String singleuser_scenario_report = "Singleuser_";
	public static String singleuser_input_excel_emailsheet = "Zuora_Singleuser";
	public static String singleuser_self_sheet = "Selfservice";
	public static String singleuser_thankyou_page = "Subscriptions";
	public static String singleuser_csr_sheet = "csr";
	public static String single_zuora_sheet = "Zuora_Singleuser";
	public static String update_single_email = "Single_Email";
	public static String ashot_input_sheet = "Ashot_Comparison";
	public static String LIVE = "Live";
	public static String QA = "QA";
	public static String ashots_location = "Ashots_commerce";
	public static String Ashot_Comparison_scenario_report = "Ashot_Comparison_report";
	public static String Zuora_url = "https://apisandbox.zuora.com/apps/newlogin.do";
	// public static String Zuora_url = "https://apisandbox.zuora.com/apps";
	public static String zuora_username = "SejalDoliaM.sbx@in.boardex.com";
	public static String zuora_password = "Thestreet20";
	public static String zuora_usernamea = "Jasbir.singh.sbx@thestreet.com";
	public static String zuora_passworda = "TheStreet18";
	public static String Zuora_Scenario_random = "Random";
	public static String Zuora_Scenario_normal = "Normal";
	public static String zuora_subscription = "Zuora_Subscription";
	public static String zuora_cancellation = "Zuora_Cancellation";
	public static String zuora_invoice_generate_url = "http://stagezuorapay.thestreet.com/login";
	public static String zuora_invoice_process_string_prefix = "http://stagezuorapay.thestreet.com";

	/*
	 * public static String zuora_invoice_generate_url =
	 * "http://192.168.70.247:11001/login?"; public static String
	 * zuora_invoice_process_string_prefix = "http://192.168.70.247:11001";
	 */

	public static String zuora_invoice_generate_username = "admin";
	public static String zuora_invoice_generate_pwd = "theStreet";
	public static String zuora_invoice_process_string_suffix = "/zuora/invoices/invoicenr/";
	public static String zuora_invoice_process_string_middle = "/unpaid";
	public static String zuora_subscription_outputsheet = "Zuora_Subscription";
	public static String zuora_subscription_scenario_report = "zuora_subscription_report";
	public static String path_of_excel = "P:/saravanan/TheStreet_Automation/TheStreet_Commerce_Zuora/src/test/java/TestData/Outputs/result.xlsx";
	public static String filename_of_excel = "result.xlsx";
	public static String html = ".html";
	 public static String to = "IndiaQAStr@in.boardex.com";
//	public static String to = "saravananr@in.boardex.com";

	public static String from = "saravananr@in.boardex.com";
	public static String username = "saravananr@in.boardex.com";// change accordingly
	public static String password = "Coolbuddy@1993";// change accordingly
	public static String host = "bxsmtppro";
	public static long time = System.currentTimeMillis();
	public static String system_Date = Currentdate_hyphen();
	public static String csr_newuser_firstname = "firstname";
	public static String csr_newuser_lastname = "lastname";
	public static String csr_newuser_password = "thestreet";
	public static String csr_newuser_confirmpwd = "thestreet";
	public static String csr_newuser_company = "automation";
	public static String csr_newuser_phone = "7894561230";
	public static String csr_newuser_email = "zuora_automation_user_" + Formated_Number() + system_Date
			+ "@mailinator.com";
	public static String csr_newuser_username = csr_newuser_email;
	public static String csr_newuser_address1 = "14th wall st";
	public static String csr_newuser_city = "NYC";
	public static String csr_newuser_state = "New York";
	public static String csr_newuser_zipcode = "12345";
	public static String csr_newuser_investor_type = "Individual";
	public static String csr_newuser_investing_style = "Both";
	public static String csr_newuser_user_type = "Individual";
	public static String csr_newuser_community_profile_type = "Member";
	public static String zuora_newcustomer_oid = "AUTO01";
	public static String zuora_newcustomer_firstname = "Automated_user_fname";
	public static String zuora_newcustomer_lastname = "Automated_user_lname";
	public static String zuora_newcustomer_workemail = csr_newuser_email;
	public static String zuora_newcustomer_country = "United States";
	public static String zuora_newcustomer_address1 = "14th Wall Street";
	public static String zuora_newcustomer_address2 = "14th Wall Street";
	public static String zuora_newcustomer_city = "New York";
	public static String zuora_newcustomer_state = "New York";
	public static String zuora_newcustomer_postalcode = "12345";
	public static String zuora_newcustomer_card_number = "4100200300011001";
	// public static String zuora_newcustomer_card_number = "4111111111111111";
	public static String zuora_newcustomer_card_month = "07";
	public static String zuora_newcustomer_card_year = "2020";
	public static String zuora_newcustomer_card_holder_name = "Automation";
	public static String zuora_newcustomer_card_billing_country = "United States";
	public static String zuora_newcustomer_card_billing_address = "14th Wall Street";
	public static String zuora_newcustomer_card_billing_city = "NYC";
	public static String zuora_newcustomer_card_billing_state = "New York";
	public static String zuora_newcustomer_card_billing_postalcode = "12345";
	public static String zuora_newcustomer_card_billing_email = csr_newuser_email;
	public static String zuora_newcustomer_card_billing_phone = csr_newuser_phone;
	public static String Signup_flow_firstname = "fname";
	public static String Signup_flow_lastname = "lname";
	public static String Signup_flow_password = "thestreet";
	public static String Signup_flow_confirm_password = "thestreet";
	public static String Signup_flow_creditcard_number = "4100200300011001";
	public static String Signup_flow_cvv_code = "123";
	public static String Signup_flow_expiry_month = "07";
	public static String Signup_flow_expiry_year = "2020";
	public static String Signup_flow_cardname = "Automation";
	public static String Signup_flow_address1 = "14 wall street";
	public static String Signup_flow_address2 = "New York";
	public static String Signup_flow_city = "New York";
	public static String Signup_flow_state = "New Jersey";
	public static String Signup_flow_country = "United states";
	public static String Signup_flow_postalcode = "55555";
	public static String Signup_flow_phonenumber = "9876543210";
	
	public static String Production_CSR_user = "vijayalakshmi.ts@thestreet.com";
	public static String Production_CSR_pwd = "TheStreet";
	public static String Production_CSR_url ="https://secure2.thestreet.com/cap/csr/";
	

	public static String upsell_crossell_mail_attachment_filename = "Upsell_Cross-sell_Flow";
	public static String Upsell_crossell_mail_subject = "Upsell/Cross-sell Automation Report -STAGE";
	public static String Upsell_crossell_mail_body = "Hi Please Find the" + '"' + ConstantUtility.upsell_crosssell_sheet
			+ '"' + "sheet in the Attached Excel to verify the details of subscription";

	public static String event_mail_attachment_filename = "Event_Ticket_Subscription";
	public static String event_mail_subject = "Event Tickets Subscription Automation Report -STAGE";
	public static String event_mail_body = "Hi Please Find the" + '"' + ConstantUtility.Event_subscription + '"'
			+ "sheet in the Attached Excel to verify the details of subscription";

	public static String singleuser_mail_attachment_filename = "Singleuser_Subscription";
	public static String singleuser_mail_subject = "Commerce-Single user Subscription Automation Report -STAGE";
	public static String singleuser_mail_body = "Hi Please Find the" + '"' + ConstantUtility.singleuser_thankyou_page
			+ "," + ConstantUtility.singleuser_csr_sheet + "," + ConstantUtility.singleuser_self_sheet + ","
			+ ConstantUtility.single_zuora_sheet + "," + ConstantUtility.update_single_email + '"'
			+ "sheets in the Attached Excel to verify the details of subscription";

	public static String randomuser_mail_attachment_filename = "Randomuser_Subscription";
	public static String randomuser_mail_subject = "Commerce-Random user Subscription Automation Report -STAGE";
	public static String randomuser_mail_body = "Hi Please Find the" + '"' + ConstantUtility.random_thankyou_page + ","
			+ ConstantUtility.random_csr_sheet + "," + ConstantUtility.random_self_sheet + ","
			+ ConstantUtility.random_zuora_sheet + "," + ConstantUtility.update_random_email + '"'
			+ "sheets in the Attached Excel to verify the details of subscription";

	public static String zuora_subscription_mail_attachment_filename = "Zuora_Subscription";
	public static String zuora_subscription_mail_subject = "Zuora Subscription Flow Automation Report - STAGE";
	public static String zuora_subscription_mail_body = "Hi Please Find the" + '"' + ConstantUtility.zuora_subscription
			+ '"' + "sheet in the Attached Excel to verify the details of subscription";

	public static String zuora_cancellation_mail_attachment_filename = "Zuora_cancellation";
	public static String zuora_cancellation_mail_subject = "Zuora Cancellation Flow Automation Report -STAGE";
	public static String zuora_cancellation_mail_body = "Hi Please Find the" + '"' + ConstantUtility.zuora_cancellation
			+ '"' + "sheet in the Attached Excel to verify the details of subscription";

	public static String commerce_image_comparison_mail_attachment_filename = "commerce_image_comparison";
	public static String commerce_image_comparison__mail_subject = "Commerce MLP,EC,CC pages Image comparison in Live & QA";
	public static String commerce_image_comparison__mail_body = "Hi Please Find the" + '"' + "commerce_image_comparison.html"
			+ '"' + "in the Attached document to Know the difference between QA and LIVE";

}
