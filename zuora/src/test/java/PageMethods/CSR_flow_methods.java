package PageMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import ExcelUtility.ConstantUtility;
import ExcelUtility.ExcelReader;
import PageObjects.CSR_flow_objects;
import PageObjects.Zuora_flow_objects;
import TestBase.TestBase;

public class CSR_flow_methods extends TestBase {

	public static void search_csr_for_zuora(List<WebElement> searchbox, List<WebElement> submit,
			List<WebElement> activate_btn, String mail) throws InterruptedException {
		zuora_objects = PageFactory.initElements(driver, Zuora_flow_objects.class);
		search_csr_user(searchbox, submit, mail, activate_btn);
		try {
			if (csr_objects.csr_search_message.size() > 0) {
				if (csr_objects.csr_search_message.get(0).getText().toString().trim()
						.equalsIgnoreCase("Unable to find a user for specified search criteria!")) {
					System.out.println("No user found");
					test.log(LogStatus.INFO, "No user found in CSR , need to create new account");
					System.out.println("Need to create a user in CSR ");
					create_new_CSR_CUSTOMER(csr_objects.csr_add_customer, csr_objects.csr_customer_fname,
							csr_objects.csr_customer_Lname, csr_objects.csr_customer_company_name,
							csr_objects.csr_customer_phone, csr_objects.csr_customer_email,
							csr_objects.csr_customer_email_formt_html, csr_objects.csr_customer_user_name,
							csr_objects.csr_customer_password, csr_objects.csr_customer_confirm_password,
							csr_objects.csr_customer_address1, csr_objects.csr_customer_city,
							csr_objects.csr_customer_state, csr_objects.csr_customer_zipcode,
							csr_objects.csr_customer_investor_type, csr_objects.csr_customer_investing_style,
							csr_objects.csr_customer_user_type, csr_objects.csr_customer_company_profiletype,
							csr_objects.csr_customer_payment_type_none, csr_objects.csr_customer_submit);

					String Account_id = get_account_id_from_csr(csr_objects.csr_customer_account_history,
							csr_objects.csr_customer_account_id);
					System.out.println(Account_id);
					Load_Url(ConstantUtility.Zuora_url);
					
					Zuora_flow_methods.login_to_zuora(zuora_objects.zuora_login_username, zuora_objects.zuora_login_password,
							zuora_objects.zuora_login_submit, ConstantUtility.zuora_username, ConstantUtility.zuora_password);
					Thread.sleep(4000);

					Zuora_flow_methods.create_zuora_customer_with_csr_id(Account_id,mail);
					
				}
			} else {
				test.log(LogStatus.INFO, "User found in CSR , So need to Verify in Zuora");
				System.out.println("user found");
				System.out.println("Need to verify the user in ZUORA");
				String Account_id = get_account_id_from_csr(csr_objects.csr_customer_account_history,
						csr_objects.csr_customer_account_id);
				System.out.println(Account_id);
				Thread.sleep(2000);
				Zuora_flow_methods.verify_zuora_user(ConstantUtility.zuora_username, ConstantUtility.zuora_password, mail,Account_id);


			}
		} catch (Exception e) {

		}
	}

	public static void create_new_CSR_CUSTOMER(List<WebElement> add_customer, List<WebElement> fname,
			List<WebElement> lname, List<WebElement> company, List<WebElement> phone, List<WebElement> email,
			List<WebElement> email_format, List<WebElement> username, List<WebElement> password,
			List<WebElement> confirm, List<WebElement> address, List<WebElement> city, List<WebElement> state,
			List<WebElement> zipcode, List<WebElement> investor_type, List<WebElement> investing_style,
			List<WebElement> user_type, List<WebElement> cmnty_profile, List<WebElement> none_payment,
			List<WebElement> submit) throws InterruptedException {

		try {
			if (add_customer.size() > 0) {
				Commerce_all_methods.click_button(add_customer);
				System.out.println("Add customer clicked");
			}

			if (fname.size() > 0) {
				Thread.sleep(2000);

				Commerce_all_methods.sendkeys(fname, ConstantUtility.csr_newuser_firstname);
				System.out.println("First name entered");
			}
			if (lname.size() > 0) {
				Commerce_all_methods.sendkeys(lname, ConstantUtility.csr_newuser_lastname);
				System.out.println("Last name entered");
			}
			if (company.size() > 0) {
				Commerce_all_methods.sendkeys(company, ConstantUtility.csr_newuser_company);
				System.out.println("Company name entered");
			}
			if (phone.size() > 0) {
				Commerce_all_methods.sendkeys(phone, ConstantUtility.csr_newuser_phone);
				System.out.println("Phone name entered");
			}
			if (email.size() > 0) {
				Commerce_all_methods.sendkeys(email, ConstantUtility.csr_newuser_email);
				System.out.println("Email name entered");
			}
			if (email_format.size() > 0) {
				Commerce_all_methods.click_button(email_format);
				System.out.println("Email format HTML clicked");
			}
			if (username.size() > 0) {
				Commerce_all_methods.sendkeys(username, ConstantUtility.csr_newuser_username);
				System.out.println("user name entered");
			}
			if (password.size() > 0) {
				Commerce_all_methods.sendkeys(password, ConstantUtility.csr_newuser_password);
				System.out.println("password name entered");
			}
			if (confirm.size() > 0) {
				Commerce_all_methods.sendkeys(confirm, ConstantUtility.csr_newuser_confirmpwd);
				System.out.println("confirm password name entered");
			}
			if (address.size() > 0) {
				Commerce_all_methods.sendkeys(address, ConstantUtility.csr_newuser_address1);
				System.out.println("address1 name entered");
			}
			if (city.size() > 0) {
				Commerce_all_methods.sendkeys(city, ConstantUtility.csr_newuser_city);
				System.out.println("city name entered");
			}
			if (state.size() > 0) {
				Commerce_all_methods.select_dropdown(state, ConstantUtility.csr_newuser_state);
				System.out.println("State entered");
			}
			if (zipcode.size() > 0) {
				Commerce_all_methods.sendkeys(zipcode, ConstantUtility.csr_newuser_zipcode);
				System.out.println("zipcode  entered");
			}
			Thread.sleep(3000);

			if (investor_type.size() > 0) {
				Commerce_all_methods.select_dropdown(investor_type, ConstantUtility.csr_newuser_investor_type);
				System.out.println("investor_type entered");
			}
			if (investing_style.size() > 0) {
				Commerce_all_methods.select_dropdown(investing_style, ConstantUtility.csr_newuser_investing_style);
				System.out.println("investing_style entered");
			}
			if (user_type.size() > 0) {
				Commerce_all_methods.select_dropdown(user_type, ConstantUtility.csr_newuser_user_type);
				System.out.println("user_type entered");
			}
			if (cmnty_profile.size() > 0) {
				Commerce_all_methods.select_dropdown(cmnty_profile, ConstantUtility.csr_newuser_community_profile_type);
				System.out.println("cmnty_profile entered");
			}
			if (none_payment.size() > 0) {
				Commerce_all_methods.click_button(none_payment);
				System.out.println("none_payment clicked");
			}
			Thread.sleep(3000);
			if (submit.size() > 0) {
				Commerce_all_methods.click_button(submit);
				System.out.println("submit clicked");
			}
			test.log(LogStatus.PASS, "CSR Account creation Passed");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "CSR Account creation Failed");
		}
	}

	public static String get_account_id_from_csr(List<WebElement> acc_history, List<WebElement> acc_id)
			throws InterruptedException {
		String accountid = null;

		try {
			if (acc_history.size() > 0) {
				Commerce_all_methods.click_button(acc_history);
			}

			if (acc_id.size() > 0) {

				accountid = acc_id.get(0).getText().toString().trim();
			}
			test.log(LogStatus.PASS, "Fetching CSR Account id  Validation Passed");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Fetching CSR Account id Validation Failed");
		}
		return accountid;

	}

	public static void CSR_Table_information(String sheet, String email, WebElement product, WebElement Promotion,
			WebElement Offer, WebElement Status, WebElement Start, WebElement End, WebElement Marketing,
			WebElement FreeTrial, WebElement price, WebElement payment_method, WebElement Autorenew, WebElement tax,
			String pwd) {
		try {

			String sProduct = product.getText().toString().trim();
			String sPromotion = Promotion.getText().toString().trim();
			String sOffer = Offer.getText().toString().trim();
			String sStatus = Status.getText().toString().trim();
			String sStart = Start.getText().toString().trim();
			String sEnd = End.getText().toString().trim();
			String sMarketing = Marketing.getText().toString().trim();
			String sFreeTrial = FreeTrial.getText().toString().trim();
			String sprice = price.getText().toString().trim();
			String spayment_method = payment_method.getText().toString().trim();
			String sAutorenew = Autorenew.getText().toString().trim();
			String stax = tax.getText().toString().trim();

			String csr_data[] = { sPromotion, sOffer, sStatus, sStart, sEnd, sMarketing, sFreeTrial, sprice,
					spayment_method, sAutorenew, stax, Currentdate1(), email, pwd, sProduct };
			ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\Testdata\\Outputs\\", "result.xlsx",
					sheet, csr_data);
			
			test.log(LogStatus.PASS, "CSR Validation PASSED ");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "CSR Validation FAILED");
		}
	}

	public static void check_csr_product(List<WebElement> accountid, List<WebElement> status_field, String status,
			String sheet_csr, String email, String pwd) throws InterruptedException, IOException {

		try {
			if (accountid.size() > 0) {
				System.out.println("account id present");

				if (status_field.size() > 0) {
					String status_content = status_field.get(0).getText().toString().trim();

					if (status_content.equalsIgnoreCase(status)) {
						System.out.println("status active paid");
						accountid.get(0).click();
					}
				}
			} else {
				System.out.println("None of the offer and product matched");
			}
			CSR_Table_information(sheet_csr, email, csr_objects.csr_product_details, csr_objects.csr_promotion_details,
					csr_objects.csr_offer_details, csr_objects.csr_status_details, csr_objects.csr_start_details,
					csr_objects.csr_end_details, csr_objects.csr_marketing_details, csr_objects.csr_freetrial_details,
					csr_objects.csr_price_details, csr_objects.csr_paymentmethod_details, csr_objects.csr_autorenew_details,
					csr_objects.csr_tax_details, pwd);
			Back();
			Thread.sleep(2000);
		} catch (Exception e) {
		}

	}

	public static void login_csr(List<WebElement> username, List<WebElement> pwd, List<WebElement> submit,
			String username_data, String password) throws InterruptedException {

		try {
			if (username.size() > 0) {
				Thread.sleep(3000);
				Commerce_all_methods.sendkeys(username, username_data);
				System.out.println("username entered");
			}
			if (pwd.size() > 0) {
				Thread.sleep(3000);

				Commerce_all_methods.sendkeys(pwd, password);
				System.out.println("password entered");
			}
			if (submit.size() > 0) {
				Thread.sleep(3000);

				Commerce_all_methods.click_button(submit);
				System.out.println("submit clicked");
			}
//			test.log(LogStatus.PASS, "CSR Login Validation Passed");
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL, "CSR Login Validation Failed");
		}
	}

	public static void Get_Subscribed_user_data_from_THANKYOU_PAGE(String email,String pwd,String subscription_product,
			String outputsheet) throws InterruptedException, IOException {
		
		
			 try {
				check_csr_data(email, pwd, subscription_product, outputsheet);
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "CSR Validation FAILED for ____" + subscription_product);

			}
		/*try {
			ExcelReader xlsreader = new ExcelReader(
					System.getProperty("user.dir") + "//src//test//java//Testdata//" + "result.xlsx");
			int RowSize = xlsreader.getRowCount(inputsheet);
			for (int i = 2; i <= RowSize; i++) {

				String pwd = xlsreader.getCellData(inputsheet, 7, i);
				String email = xlsreader.getCellData(inputsheet, 6, i);
				String product = xlsreader.getCellData(inputsheet, 8, i);
				System.out.println(email + product);
				if (product.equals(subscription_product)) {
					System.out.println("yes product is matched ");
					check_csr_data(email, pwd, product, outputsheet);
				} else {
					System.out.println("product not matched");
				}

			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "CSR Validation FAILED for ____" + subscription_product);

		}*/
	}

	public static void search_csr_user(List<WebElement> email, List<WebElement> submit, String email_id,
			List<WebElement> activebtn) throws InterruptedException {
		Thread.sleep(5000);
		try {
			if (email.size() > 0) {
				Commerce_all_methods.sendkeys(email, email_id);
				System.out.println("Search email entered-----------   " + email_id);
			} else {
				System.out.println("Search email field not found");
			}
			if (submit.size() > 0) {
				Commerce_all_methods.click_button(submit);
				System.out.println("submit clicked");
			} else {
				System.out.println("Submit field not found");
			}
			if (activebtn.size() > 0) {
				Commerce_all_methods.click_button(activebtn);
				System.out.println("Actvate button clicked");
			} else {
				System.out.println("May be activated already");
			}
			
//			test.log(LogStatus.PASS, "Search Email Validation Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Search Email Validation Failed");

		}

	}

	public static void check_csr_data(String email, String pwd, String product, String outputsheet)
			throws InterruptedException, IOException {

		try {
			csr_objects = PageFactory.initElements(driver, CSR_flow_objects.class);

			search_csr_user(csr_objects.csr_search_mail, csr_objects.csr_search_submit, email,
					csr_objects.csr_activateaccount_btn);

			if (product.equalsIgnoreCase("Action Alerts PLUS")) {
				check_csr_product(csr_objects.csr_product_table_aap, csr_objects.csr_product_status_aap, "Active, Paid",
						outputsheet, email, pwd);
				Back();

			} else if (product.equalsIgnoreCase("Income Seeker")) {
				check_csr_product(csr_objects.csr_product_table_incomeseeker,
						csr_objects.csr_product_status_incomeseeker, "Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("TheStreet Trifecta Stocks")) {
				check_csr_product(csr_objects.csr_product_table_trifecta, csr_objects.csr_product_status_trifecta,
						"Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("TheStreet.com Stocks Under $10")) {
				check_csr_product(csr_objects.csr_product_table_stocksunder, csr_objects.csr_product_status_stocksunder,
						"Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("TheStreet.com Top Stocks")) {
				check_csr_product(csr_objects.csr_product_table_topstocks, csr_objects.csr_product_status_topstocks,
						"Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("TheStreet.com Chairman's Club")) {
				check_csr_product(csr_objects.csr_product_table_chairman, csr_objects.csr_product_status_chairman,
						"Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("RealMoney")) {
				check_csr_product(csr_objects.csr_product_table_rmy, csr_objects.csr_product_status_rmy, "Active, Paid",
						outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("RealMoney Pro")) {
				check_csr_product(csr_objects.csr_product_table_rmypro, csr_objects.csr_product_status_rmypro,
						"Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("RealMoney Pro Portfolio")) {
				check_csr_product(csr_objects.csr_product_table_rmypro_portfolio,
						csr_objects.csr_product_status_rmypro_portfolio, "Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("Chatter on the Street")) {
				check_csr_product(csr_objects.csr_product_table_chatter, csr_objects.csr_product_status_chatter,
						"Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("TheStreet Quant Ratings")) {
				check_csr_product(csr_objects.csr_product_table_quantratings,
						csr_objects.csr_product_status_quantratings, "Active, Paid", outputsheet, email, pwd);
				Back();
			} else if (product.equalsIgnoreCase("Retirement Daily")) {
				check_csr_product(csr_objects.csr_product_table_retirement, csr_objects.csr_product_status_retirement,
						"Active, Paid", outputsheet, email, pwd);
				Back();
			} else {
				System.out.println("No data found or invalid user");
			}
			

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "CSR Validation FAILED for ____" + product);

		}

		System.out.println(email + "_____" + product);
	}

}
