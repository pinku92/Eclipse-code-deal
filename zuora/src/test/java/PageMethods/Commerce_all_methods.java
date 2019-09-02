package PageMethods;

import java.io.IOException;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ObjectArrays;
import com.relevantcodes.extentreports.LogStatus;

import ExcelUtility.ConstantUtility;
import ExcelUtility.ExcelReader;
import TestBase.TestBase;

public class Commerce_all_methods extends TestBase {

	public static String upsell_crossell_path = ConstantUtility.upsell_crossell_path;
	public static String events_path = ConstantUtility.events_path;

	public static void Validate_Upsell_Crossell(String upsell, String crossell, List<WebElement> upsell_yes,
			List<WebElement> upsell_no, List<WebElement> crossell_yes, List<WebElement> crosssell_no, String product,
			String type, String subscription_type, String oid, String image_status)
			throws InterruptedException, IOException {

		String product_with_oid = product + "_" + oid;

		Thread.sleep(4000);

		try {

			if ((upsell.equalsIgnoreCase("Yes")) || (upsell.equalsIgnoreCase("No"))) {
				if (image_status.equalsIgnoreCase("Yes")) {
					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type, subscription_type + "_UPSELL",
							subscription_type);
				}
				Scroll_Down(-2500);
			} else {

			}

			if (upsell.equalsIgnoreCase("Yes")) {
				System.out.println("upsell process is ready to start");
				if (upsell_yes.size() > 0) {
					click_button(upsell_yes);
					if (image_status.equalsIgnoreCase("Yes")) {
						test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
								subscription_type + "_UPSELL_YES" + "_THANKYOU", subscription_type);
					}
					test.log(LogStatus.PASS, "Clicked Yes to do upsell");
					System.out.println("Done an UPSELL");
				} else {
					test.log(LogStatus.FAIL, "Failed to Clicked Yes to do upsell");
					System.out.println("UPSELL FAILED");
					SUB_Directory_ashots_configuration_1(subscription_type + "_ERROR", product_with_oid,
							upsell_crossell_path, type);

					if (image_status.equalsIgnoreCase("Yes")) {
						test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
								subscription_type + "_ERROR" + System.currentTimeMillis(), subscription_type);
					}
					System.out.println("Failed screenshot");
				}
			} else if (upsell.equalsIgnoreCase("No")) {
				System.out.println("UPSELL is not ready to start");

				if (upsell_no.size() > 0) {
					click_button(upsell_no);
					if (image_status.equalsIgnoreCase("Yes")) {
						test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
								subscription_type + "_CROSSSELL", subscription_type);
					}
					Scroll_Down(-2500);

					test.log(LogStatus.PASS, "Clicked No to do upsell");
					System.out.println("Done  No to UPSELL");
				} else {
					test.log(LogStatus.FAIL, "Failed to Clicked Yes to do upsell");
					System.out.println("UPSELL FAILED");
					SUB_Directory_ashots_configuration_1(subscription_type + "_ERROR", product_with_oid,
							upsell_crossell_path, type);

					if (image_status.equalsIgnoreCase("Yes")) {
						test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
								subscription_type + "_ERROR" + System.currentTimeMillis(), subscription_type);
					}
					System.out.println("Failed screenshot");
				}
				System.out.println("Checking crossell");
				if (crossell.equalsIgnoreCase("Yes")) {
					System.out.println("Crossell is ready to start crossell");
					if (crossell_yes.size() > 0) {
						click_button(crossell_yes);
						if (image_status.equalsIgnoreCase("Yes")) {
							test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
									subscription_type + "_CROSSSELL_YES" + "_THANKYOU", subscription_type);
						}
						test.log(LogStatus.PASS, "Clicked Yes to do crossell");
						System.out.println("Done an CROSSELL");
					} else {
						test.log(LogStatus.FAIL, "Failed to Clicked Yes to do Crossell");
						System.out.println("Crossell FAILED");
						SUB_Directory_ashots_configuration_1(subscription_type + "_ERROR", product_with_oid,
								upsell_crossell_path, type);

						if (image_status.equalsIgnoreCase("Yes")) {
							test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
									subscription_type + "_ERROR" + System.currentTimeMillis(), subscription_type);
						}
						System.out.println("Failed screenshot");
					}

				} else if (crossell.equalsIgnoreCase("No")) {
					System.out.println("CROSSELL is Yes not ready to start");
					System.out.println("Checking crossell No");
					if (crosssell_no.size() > 0) {
						click_button(crosssell_no);
						if (image_status.equalsIgnoreCase("Yes")) {
							test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
									subscription_type + "_CROSSSELL_NO" + "_THANKYOU", subscription_type);
						}
						test.log(LogStatus.PASS, "Clicked Yes to do No crossell");
						System.out.println("Done an No CROSSELL");
					} else {
						test.log(LogStatus.FAIL, "Failed to Clicked Yes to do No Crossell");
						System.out.println("Crossell FAILED");
						SUB_Directory_ashots_configuration_1(subscription_type + "_ERROR", product_with_oid,
								upsell_crossell_path, type);

						if (image_status.equalsIgnoreCase("Yes")) {
							test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
									subscription_type + "_ERROR" + System.currentTimeMillis(), subscription_type);
						}
						System.out.println("Failed screenshot");
					}

				} else if (crossell.equalsIgnoreCase("NA")) {
					System.out.println("UPSELL/CROSSELL is Not Applicable");
				}

			} else if (upsell.equalsIgnoreCase("NA")) {
				System.out.println("UPSELL/CROSSELL is Not Applicable");
			}
		} catch (Exception e) {

		}

	}

	public static void start_product_subscription(WebDriver driver, List<WebElement> mlp_btn, List<WebElement> email,
			List<WebElement> continue_btn, List<WebElement> fname, List<WebElement> lname, List<WebElement> pwd,
			List<WebElement> confirmpwd, List<WebElement> subscription_plan_monthly,
			List<WebElement> subscription_plan_annual, List<WebElement> subscription_plan_two_year,
			List<WebElement> cardholder_name, List<WebElement> cardholder_number, List<WebElement> month,
			List<WebElement> year, List<WebElement> cvv, List<WebElement> address1, List<WebElement> address2,
			List<WebElement> city, List<WebElement> state, List<WebElement> postalcode, List<WebElement> country,
			List<WebElement> phone, List<WebElement> continue_btn2, String emaildata, String Fname, String Lname,
			String pwddata, String confirmpwddata, String subscriptionType, String ccNumber, String product,
			String cvvCode, String exMonth, String exYear, String nameOnCard, String address1data, String address2data,
			String citydata, String statedata, String countrydata, String postalCode, String phoneNum, String type,
			String oid, String upsell, String crossell, String image_status) throws InterruptedException, IOException {

		String product_with_oid = product + "_" + oid;

		// String product_with_oid = oid;

		try {
			System.out.println("****************************************__" + oid + "__" + subscriptionType
					+ "__************************************************");

			try {
				// click mlp button
				click_button(mlp_btn);
			} catch (Exception e) {

			}

			try {
				// enter email

				if (image_status.equalsIgnoreCase("Yes")) {

					BASE_Directory_ashots_configuration(product_with_oid, upsell_crossell_path);

					SUB_Directory_ashots_configuration(type, product_with_oid, upsell_crossell_path);

					SUB_Directory_ashots_configuration_1(subscriptionType, product_with_oid, upsell_crossell_path,
							type);

					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
							subscriptionType + "_EC_without_details", subscriptionType);
				} else {

				}

				// SUB_Directory_ashots_configuration(type, product_with_oid, x_path);

				sendkeys(email, emaildata);

				if (image_status.equalsIgnoreCase("Yes")) {
					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
							subscriptionType + "_EC_with_details", subscriptionType);
					// test_ashot_screenshot(x_path, product_with_oid, type,"EC","");
				} else {

				}

			} catch (Exception e3) {

			}

			try {
				// click continue
				click_button(continue_btn);
			} catch (Exception e) {

			}

			try {

				if (image_status.equalsIgnoreCase("Yes")) {
					// test_ashot_screenshot(x_path, product_with_oid,
					// type,subscriptionType+"_CC_without_details",subscriptionType);
					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
							subscriptionType + "_CC_without_details", subscriptionType);
					// test_ashot_screenshot(x_path, product_with_oid, type,"CC_NO_DETAIL","");
				} else {

				}

				// enter first name
				sendkeys(fname, Fname);
			} catch (Exception e) {

			}

			try {
				// enter last name
				sendkeys(lname, Lname);
			} catch (Exception e) {

			}

			try {
				// enter password
				sendkeys(pwd, pwddata);
			} catch (Exception e) {

			}

			try {
				// enter confirm password
				sendkeys(confirmpwd, confirmpwddata);
			} catch (Exception e) {

			}
			try {
				// Select Plan
				if (subscriptionType.equalsIgnoreCase("Monthly")) {
					js_click(subscription_plan_monthly);
				} else if (subscriptionType.equalsIgnoreCase("Annual")) {
					js_click(subscription_plan_annual);
				} else if (subscriptionType.equalsIgnoreCase("Two Year")) {
					js_click(subscription_plan_two_year);
				}
			} catch (Exception e2) {

			}

			try {
				Thread.sleep(5000);
				driver.switchTo().frame("z_hppm_iframe");
			} catch (Exception e1) {

			}

			try {
				// enter card holder name
				sendkeys(cardholder_name, nameOnCard);
			} catch (Exception e) {

			}

			try {
				// enter card holder number
				sendkeys(cardholder_number, ccNumber);
			} catch (Exception e) {

			}

			try {
				// select month
				select_dropdown(month, exMonth);
			} catch (Exception e) {

			}

			try {
				// select year
				select_dropdown(year, exYear);
			} catch (Exception e) {

			}

			try {
				// enter card cvv
				sendkeys(cvv, cvvCode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// enter address1
				sendkeys(address1, address1data);
			} catch (Exception e) {

			}

			try {
				// enter address2
				sendkeys(address2, address2data);
			} catch (Exception e) {

			}

			try {
				// enter city
				sendkeys(city, citydata);
			} catch (Exception e) {

			}

			try {
				// select state
				select_dropdown(state, statedata);
			} catch (Exception e) {

			}

			try {
				// enter postalcode
				sendkeys(postalcode, postalCode);
			} catch (Exception e) {

			}

			try {
				// select country
				select_dropdown(country, countrydata);
			} catch (Exception e) {

			}

			try {
				// enter phone
				sendkeys(phone, phoneNum);
			} catch (Exception e) {

			}

			try {
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
			} catch (Exception e1) {
			}

			try {

				if (image_status.equalsIgnoreCase("Yes")) {
					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
							subscriptionType + "_CC_with_details", subscriptionType);
					// test_ashot_screenshot(x_path, product_with_oid, type,"CC_DETAIL","");
				}

			} catch (Exception e1) {

			}

			try {
				// click continue
				click_button(continue_btn2);
			} catch (Exception e) {

			}

			/*
			 * Thread.sleep(7000);
			 * if((upsell.equalsIgnoreCase("Yes"))||(upsell.equalsIgnoreCase("No"))) {
			 * test_ashot_screenshot(x_path, product_with_oid, type,"TY",""); }
			 */

		} catch (Exception e) {

			closebrowser();

			if (image_status.equalsIgnoreCase("Yes")) {
				SUB_Directory_ashots_configuration_1(subscriptionType + "_ERROR", product_with_oid,
						upsell_crossell_path, type);
				test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
						subscriptionType + "_ERROR" + System.currentTimeMillis(), subscriptionType + "_ERROR");
			} else {

			}
			System.out.println("Failed screenshot");

		}
	}

	public static void start_subscription_validation(WebDriver driver, List<WebElement> mlp_btn, List<WebElement> email,
			List<WebElement> continue_btn, List<WebElement> fname, List<WebElement> lname, List<WebElement> pwd,
			List<WebElement> confirmpwd, List<WebElement> subscription_plan_monthly,
			List<WebElement> subscription_plan_annual, List<WebElement> subscription_plan_two_year,
			List<WebElement> cardholder_name, List<WebElement> cardholder_number, List<WebElement> month,
			List<WebElement> year, List<WebElement> cvv, List<WebElement> address1, List<WebElement> address2,
			List<WebElement> city, List<WebElement> state, List<WebElement> postalcode, List<WebElement> country,
			List<WebElement> phone, List<WebElement> continue_btn2, String emaildata, String Fname, String Lname,
			String pwddata, String confirmpwddata, String subscriptionType, String ccNumber, String product,
			String cvvCode, String exMonth, String exYear, String nameOnCard, String address1data, String address2data,
			String citydata, String statedata, String countrydata, String postalCode, String phoneNum, String type,
			String oid, String upsell, String crossell, String image_status) throws InterruptedException, IOException {

		
		try {
			
		} catch (Exception e) {

		}
		
		try {
			sendkeys(email, emaildata);
			click_button(continue_btn);
 			test.log(LogStatus.PASS, "EC PAGE Navigated Successfully");
			if(driver.getTitle().contains("Provide Billing Information")) {
				test.log(LogStatus.PASS, "CC PAGE Navigated Successfully");
			}else {
				
			}
			
		} catch (Exception e) {
 			test.log(LogStatus.FAIL, " Upsell/Cross-sell PAGE Navigation Failed");
		}

		 

	}

	public static void start_event_subscription(WebDriver driver, List<WebElement> mlp_btn, List<WebElement> email,
			List<WebElement> continue_btn, List<WebElement> fname, List<WebElement> lname, List<WebElement> pwd,
			List<WebElement> confirmpwd, List<WebElement> subscription_plan_monthly,
			List<WebElement> subscription_plan_annual, List<WebElement> subscription_plan_two_year,
			List<WebElement> cardholder_name, List<WebElement> cardholder_number, List<WebElement> month,
			List<WebElement> year, List<WebElement> cvv, List<WebElement> address1, List<WebElement> address2,
			List<WebElement> city, List<WebElement> state, List<WebElement> postalcode, List<WebElement> country,
			List<WebElement> phone, List<WebElement> continue_btn2, String emaildata, String Fname, String Lname,
			String pwddata, String confirmpwddata, String subscriptionType, String ccNumber, String product,
			String cvvCode, String exMonth, String exYear, String nameOnCard, String address1data, String address2data,
			String citydata, String statedata, String countrydata, String postalCode, String phoneNum, String type,
			String oid, String emails, String url, String sheet) throws InterruptedException, IOException {

		String product_with_oid = product + "_" + oid;
		String EC_tab_title = null;
		String CC_tab_title = null;
		String MLP_tab_title= null;

		// String product_with_oid = oid;

		try {
			System.out.println("****************************************__" + oid + "__" + subscriptionType
					+ "__************************************************");

			try {
				// click mlp button
				click_button(mlp_btn);
				MLP_tab_title = driver.getTitle().toString();

			} catch (Exception e) {

			}

			try {
				// enter email

				/*if (image_status.equalsIgnoreCase("Yes")) {

					BASE_Directory_ashots_configuration(product_with_oid, upsell_crossell_path);

					SUB_Directory_ashots_configuration(type, product_with_oid, upsell_crossell_path);

					SUB_Directory_ashots_configuration_1(subscriptionType, product_with_oid, upsell_crossell_path,
							type);

					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
							subscriptionType + "_EC_without_details", subscriptionType);
				} else {

				}*/

				// SUB_Directory_ashots_configuration(type, product_with_oid, x_path);

				sendkeys(email, emaildata);
				EC_tab_title = driver.getTitle().toString();

				

			/*	if (image_status.equalsIgnoreCase("Yes")) {
					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
							subscriptionType + "_EC_with_details", subscriptionType);
					// test_ashot_screenshot(x_path, product_with_oid, type,"EC","");
				} else {

				}*/

			} catch (Exception e3) {

			}

			try {
				// click continue
				click_button(continue_btn);
				
				CC_tab_title = driver.getTitle().toString();
				
			} catch (Exception e) {

			}
			
			
			String subscriptiontable_data[] = { emaildata,url,MLP_tab_title, EC_tab_title,CC_tab_title };

			ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\Testdata\\Outputs\\", "events_result.xlsx",
					sheet, subscriptiontable_data);


			/*try {

				if (image_status.equalsIgnoreCase("Yes")) {
					// test_ashot_screenshot(x_path, product_with_oid,
					// type,subscriptionType+"_CC_without_details",subscriptionType);
					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
							subscriptionType + "_CC_without_details", subscriptionType);
					// test_ashot_screenshot(x_path, product_with_oid, type,"CC_NO_DETAIL","");
				} else {

				}

				// enter first name
				sendkeys(fname, Fname);
			} catch (Exception e) {

			}

			try {
				// enter last name
				sendkeys(lname, Lname);
			} catch (Exception e) {

			}

			try {
				// enter password
				sendkeys(pwd, pwddata);
			} catch (Exception e) {

			}

			try {
				// enter confirm password
				sendkeys(confirmpwd, confirmpwddata);
			} catch (Exception e) {

			}
			
			 * try { // Select Plan if (subscriptionType.equalsIgnoreCase("Monthly")) {
			 * js_click(subscription_plan_monthly); } else if
			 * (subscriptionType.equalsIgnoreCase("Annual")) {
			 * js_click(subscription_plan_annual); } else if
			 * (subscriptionType.equalsIgnoreCase("Two Year")) {
			 * js_click(subscription_plan_two_year); } } catch (Exception e2) {
			 * 
			 * }
			 

			try {
				Thread.sleep(5000);
				driver.switchTo().frame("z_hppm_iframe");
			} catch (Exception e1) {

			}

			try {
				// enter card holder name
				sendkeys(cardholder_name, nameOnCard);
			} catch (Exception e) {

			}

			try {
				// enter card holder number
				sendkeys(cardholder_number, ccNumber);
			} catch (Exception e) {

			}

			try {
				// select month
				select_dropdown(month, exMonth);
			} catch (Exception e) {

			}

			try {
				// select year
				select_dropdown(year, exYear);
			} catch (Exception e) {

			}

			try {
				// enter card cvv
				sendkeys(cvv, cvvCode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// enter address1
				sendkeys(address1, address1data);
			} catch (Exception e) {

			}

			try {
				// enter address2
				sendkeys(address2, address2data);
			} catch (Exception e) {

			}

			try {
				// enter city
				sendkeys(city, citydata);
			} catch (Exception e) {

			}

			try {
				// select state
				select_dropdown(state, statedata);
			} catch (Exception e) {

			}

			try {
				// enter postalcode
				sendkeys(postalcode, postalCode);
			} catch (Exception e) {

			}

			try {
				// select country
				select_dropdown(country, countrydata);
			} catch (Exception e) {

			}

			try {
				// enter phone
				sendkeys(phone, phoneNum);
			} catch (Exception e) {

			}

			try {
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
			} catch (Exception e1) {
			}

			try {

				if (image_status.equalsIgnoreCase("Yes")) {
					test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
							subscriptionType + "_CC_with_details", subscriptionType);
					// test_ashot_screenshot(x_path, product_with_oid, type,"CC_DETAIL","");
				}

			} catch (Exception e1) {

			}

			try {
				// click continue
				click_button(continue_btn2);
			} catch (Exception e) {

			}

			
			 * Thread.sleep(7000);
			 * if((upsell.equalsIgnoreCase("Yes"))||(upsell.equalsIgnoreCase("No"))) {
			 * test_ashot_screenshot(x_path, product_with_oid, type,"TY",""); }
			 
*/
		} catch (Exception e) {

		/*	closebrowser();

			if (image_status.equalsIgnoreCase("Yes")) {
				SUB_Directory_ashots_configuration_1(subscriptionType + "_ERROR", product_with_oid,
						upsell_crossell_path, type);
				test_ashot_screenshot(upsell_crossell_path, product_with_oid, type,
						subscriptionType + "_ERROR" + System.currentTimeMillis(), subscriptionType + "_ERROR");
			} else {

			}
			System.out.println("Failed screenshot");*/

		}
	}

	public static String[] Update_Event_Thankyou_page_information_array(String oid, List<WebElement> email,
			List<WebElement> ticket, List<WebElement> amount, String sheetname)
			throws IOException, InterruptedException {
		String subscription_data[] = null;
		Thread.sleep(2000);

		try {
			String email_id;
			if (email.size() > 0) {
				email_id = email.get(0).getText().toString().trim();
			} else {
				email_id = "Nil";
			}
			String ticket_data;

			if (ticket.size() > 0) {
				ticket_data = ticket.get(0).getText().toString().trim();

			} else {
				ticket_data = "Nil";
			}

			String Amount_data;

			if (amount.size() > 0) {
				Amount_data = amount.get(0).getText().toString().trim();

			} else {
				Amount_data = "Nil";
			}

			subscription_data = new String[] { oid, email_id, ConstantUtility.Signup_flow_password, ticket_data,
					Amount_data, Currentdate1() };
			/*
			 * ExcelReader.writeExcel(System.getProperty("user.dir") +
			 * "\\src\\test\\java\\TestData\\Outputs\\", "result.xlsx", sheetname,
			 * subscription_data);
			 */
			// test.log(LogStatus.PASS, "Subscription PASSED and Updated Thank you page
			// information for ____" + product);

		} catch (Exception e) {
			// test.log(LogStatus.FAIL,
			// "Subscription FAILED or Unable to update Thank you page information for ____"
			// + product);

		}
		return subscription_data;

	}

	public static void Update_Thankyou_page_information(List<WebElement> email_2, List<WebElement> email,
			List<WebElement> accid, List<WebElement> subid, List<WebElement> term, List<WebElement> freetrial,
			List<WebElement> subon, List<WebElement> new_product, String sheetname, String product, String oid_url)
			throws IOException, InterruptedException {

		Thread.sleep(2000);

		try {
			String email_id;
			if (email.size() > 0) {
				email_id = email.get(0).getText().toString().trim();
			} else if (email_2.size() > 0) {
				email_id = email_2.get(0).getText().toString().trim();
			} else {
				email_id = "Nil";
			}
			String account_id;

			if (accid.size() > 0) {
				account_id = accid.get(0).getText().toString().trim();

			} else {
				account_id = "Nil";
			}

			String subscription_id;

			if (subid.size() > 0) {
				subscription_id = subid.get(0).getText().toString().trim();

			} else {
				subscription_id = "Nil";
			}

			String term_id = term.get(0).getText().toString().trim();
			if (term.size() > 0) {
				term_id = term.get(0).getText().toString().trim();

			} else {
				term_id = "Nil";
			}

			String freetrial_id;
			if (freetrial.size() > 0) {
				freetrial_id = freetrial.get(0).getText().toString().trim();
			} else {
				freetrial_id = "Nil";
			}

			String subscribed_on_id;
			if (subon.size() > 0) {
				subscribed_on_id = subon.get(0).getText().toString().trim();
			} else {
				subscribed_on_id = "Nil";

			}

			String upsell_product;

			if (new_product.size() > 0) {
				upsell_product = new_product.get(0).getText().toString().trim();
			} else {
				upsell_product = "Nil";

			}

			String subscription_data[] = { oid_url, product, upsell_product, term_id, account_id, subscription_id,
					freetrial_id, subscribed_on_id, Currentdate1(), email_id, ConstantUtility.Signup_flow_password, };
			ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\Outputs\\",
					"result.xlsx", sheetname, subscription_data);
			test.log(LogStatus.PASS, "Subscription PASSED and Updated Thank you page information  for ____" + product);

		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Subscription FAILED  or Unable to update Thank you page information for ____" + product);

		}

	}

	public static String[] Update_Thankyou_page_information_array(List<WebElement> email_2, List<WebElement> email,
			List<WebElement> accid, List<WebElement> subid, List<WebElement> term, List<WebElement> freetrial,
			List<WebElement> subon, List<WebElement> new_product, String sheetname, String product, String oid_url)
			throws IOException, InterruptedException {

		String[] subscription_data = null;

		Thread.sleep(2000);

		try {

			String email_id;
			if (email.size() > 0) {
				email_id = email.get(0).getText().toString().trim();
			} else if (email_2.size() > 0) {
				email_id = email_2.get(0).getText().toString().trim();
			} else {
				email_id = "Nil";
			}
			String account_id;

			if (accid.size() > 0) {
				account_id = accid.get(0).getText().toString().trim();

			} else {
				account_id = "Nil";
			}

			String subscription_id;

			if (subid.size() > 0) {
				subscription_id = subid.get(0).getText().toString().trim();

			} else {
				subscription_id = "Nil";
			}

			String term_id = term.get(0).getText().toString().trim();
			if (term.size() > 0) {
				term_id = term.get(0).getText().toString().trim();

			} else {
				term_id = "Nil";
			}

			String freetrial_id;
			if (freetrial.size() > 0) {
				freetrial_id = freetrial.get(0).getText().toString().trim();
			} else {
				freetrial_id = "Nil";
			}

			String subscribed_on_id;
			if (subon.size() > 0) {
				subscribed_on_id = subon.get(0).getText().toString().trim();
			} else {
				subscribed_on_id = "Nil";

			}

			String upsell_product;

			if (new_product.size() > 0) {
				upsell_product = new_product.get(0).getText().toString().trim();
			} else {
				upsell_product = "Nil";

			}

			subscription_data = new String[] { oid_url, product, upsell_product, term_id, account_id, subscription_id,
					freetrial_id, subscribed_on_id, Currentdate1(), email_id, ConstantUtility.Signup_flow_password, };
			/*
			 * ExcelReader.writeExcel(System.getProperty("user.dir") +
			 * "\\src\\test\\java\\TestData\\Outputs\\", "result.xlsx", sheetname,
			 * subscription_data);
			 */
			// test.log(LogStatus.PASS, "Subscription PASSED and Updated Thank you page
			// information for ____" + product);

		} catch (Exception e) {
			/*
			 * test.log(LogStatus.FAIL,
			 * "Subscription FAILED  or Unable to update Thank you page information for ____"
			 * + product);
			 */

		}
		return subscription_data;

	}

	public static void Merge_data_array(String[] a, String[] b, String sheet) throws IOException {
		String[] joined = ArrayUtils.addAll(a, b);
		ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\Testdata\\Outputs\\", "result.xlsx",
				sheet, joined);
	}

	public static void click_button(List<WebElement> button) throws InterruptedException {
		TestBase.highlighElement(driver, button);
		// Thread.sleep(2000);
		if (button.size() > 0) {
			// System.out.println("enter into mlp");
			button.get(0).click();
		}
	}

	public static void sendkeys(List<WebElement> input_field, String data) throws InterruptedException {
		TestBase.highlighElement(driver, input_field);
		// Thread.sleep(2000);
		if (input_field.size() > 0) {
			input_field.get(0).click();
			input_field.get(0).clear();
			input_field.get(0).sendKeys(data);
		}
	}

	public static void select_dropdown(List<WebElement> collection, String data) throws InterruptedException {
		// Thread.sleep(2000);
		for (WebElement collection_data : collection) {

			if (collection_data.getText().contains(data)) {
				collection_data.click();
			}

		}
	}

	public static void js_click(List<WebElement> to_clicks) {

		WebElement to_click = to_clicks.get(0);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", to_click,
				"color: black; border: 4px solid red;");
		jse.executeScript("arguments[0].click()", to_click);

	}

	public static void select_dropdown_1(List<WebElement> collection, String data) throws InterruptedException {
		// Thread.sleep(2000);
		for (WebElement collection_data : collection) {

			if (collection_data.getText().equalsIgnoreCase(data)) {
				collection_data.click();
			}
		}
	}
}
