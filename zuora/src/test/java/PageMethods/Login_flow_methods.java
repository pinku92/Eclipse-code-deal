package PageMethods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.Login_flow_objects;
import TestBase.TestBase;

public class Login_flow_methods extends TestBase {

	public static Login_flow_objects login_objects;

	public static void login_premium_products(String product, String user, String pwd) throws InterruptedException

	{
		try {
			login_objects = PageFactory.initElements(driver, Login_flow_objects.class);
			Thread.sleep(5000);
			if (product.equalsIgnoreCase("Action Alerts PLUS")) {
				// login_objects.stage_aap_login_link.get(0).click();
				login_method(login_objects.stage_aap_login_username, login_objects.stage_aap_login_pwd,
						login_objects.stage_aap_submitbtn, user, pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle().equalsIgnoreCase("- Action Alerts PLUS")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			} else if (product.equalsIgnoreCase("RealMoney")) {
				login_objects.stage_rmy_mlp_btn.get(0).click();
				login_method(login_objects.stage_aap_login_username, login_objects.stage_aap_login_pwd,
						login_objects.stage_aap_submitbtn, user, pwd, product);
			} else if (product.equalsIgnoreCase("RealMoney Pro")) {
				login_objects.stage_rmypro_login_link.get(0).click();
				login_method(login_objects.stage_rmypro_login_username, login_objects.stage_rmypro_login_pwd,
						login_objects.stage_rmypro_submitbtn, user, pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle()
						.equalsIgnoreCase("RealMoney Pro - Trading Strategies, Financial Blogs, Investment Ideas")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			} else if (product.equalsIgnoreCase("RealMoney Pro Portfolio")) {
				login_objects.stage_rmypro_portfolio_mlp_btn.get(0).click();
				login_objects.stage_rmypro__portfolio_login_link.get(0).click();
				login_method(login_objects.stage_rmypro_portfolio_login_username,
						login_objects.stage_rmypro_portfolio_login_pwd, login_objects.stage_rmypro_portfolio_submitbtn,
						user, pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle().equalsIgnoreCase("TheStreet | Realmoney Pro Portfolio")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}

			} else if (product.equalsIgnoreCase("TheStreet.com Top Stocks")) {
				login_objects.stage_topstocks_login_link.get(0).click();
				login_method(login_objects.stage_topstocks_login_username, login_objects.stage_topstocks_login_pwd,
						login_objects.stage_topstocks_submitbtn, user, pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle().equalsIgnoreCase("Top Stocks | TheStreet")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			} else if (product.equalsIgnoreCase("TheStreet.com Stocks Under $10")) {
				login_objects.stage_stocksunder_login_link.get(0).click();
				login_method(login_objects.stage_stocksunder_login_username, login_objects.stage_stocksunder_login_pwd,
						login_objects.stage_stocksunder_submitbtn, user, pwd, product);
			} else if (product.equalsIgnoreCase("TheStreet.com Chairman's Club")) {
				login_objects.stage_chairman_login_link.get(0).click();
				login_method(login_objects.stage_chairman_login_username, login_objects.stage_chairman_login_pwd,
						login_objects.stage_chairman_submitbtn, user, pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle().equalsIgnoreCase("TheStreet | Chairman's Club")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			} else if (product.equalsIgnoreCase("Income Seeker")) {
				login_objects.stage_income_login_link.get(0).click();
				login_method(login_objects.stage_income_login_username, login_objects.stage_income_login_pwd,
						login_objects.stage_income_submitbtn, user, pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle().equalsIgnoreCase("Income Seeker | TheStreet")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			} else if (product.equalsIgnoreCase("TheStreet Quant Ratings")) {
				login_objects.stage_quantratings_login_link.get(0).click();
				login_method(login_objects.stage_quantratings_login_username,
						login_objects.stage_quantratings_login_pwd, login_objects.stage_quantratings_submitbtn, user,
						pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle().equalsIgnoreCase("Quant Ratings | TheStreet")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			} else if (product.equalsIgnoreCase("TheStreet Trifecta Stocks")) {
				login_objects.stage_trifecta_login_link.get(0).click();
				login_method(login_objects.stage_trifecta_login_username, login_objects.stage_trifecta_login_pwd,
						login_objects.stage_trifecta_submitbtn, user, pwd, product);
				Thread.sleep(3000);

				if (driver.getTitle().equalsIgnoreCase("Trifecta Stocks | TheStreet")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			} else if (product.equalsIgnoreCase("Chatter on the Street")) {
				// login_objects.stage_chatter_login_link.get(0).click();
				login_method(login_objects.stage_chatter_login_username, login_objects.stage_chatter_login_pwd,
						login_objects.stage_chatter_submitbtn, user, pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle().equalsIgnoreCase("meta title - Chatter on the Street")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			} else if (product.equalsIgnoreCase("Retirement Daily")) {
				login_method(login_objects.stage_retirement_login_username, login_objects.stage_retirement_login_pwd,
						login_objects.stage_retirement_submitbtn, user, pwd, product);
				Thread.sleep(3000);
				if (driver.getTitle().equalsIgnoreCase("- Retirement Daily")) {
					test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
					System.out.println("Logged in Successfully");
				} else {
					test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
				}
			}
			// test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);
		}

	}

	public static void login_method(List<WebElement> username, List<WebElement> pwd, List<WebElement> submit,
			String username_data, String password, String product) throws InterruptedException {

		try {
			if (username.size() > 0) {
				Commerce_all_methods.sendkeys(username, username_data);
				System.out.println(username + "username entered");
			}
			if (pwd.size() > 0) {
				Commerce_all_methods.sendkeys(pwd, password);
				System.out.println(password + "password entered");
			}
			if (submit.size() > 0) {
				// Thread.sleep(5000);
				Commerce_all_methods.click_button(submit);
				System.out.println("submit clicked");
			}
			Thread.sleep(2000);
			// test.log(LogStatus.PASS, "Login To Product Passed for ____" + product);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login To Product Failed for ____" + product);

		}
	}

}
