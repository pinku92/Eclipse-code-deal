package PageMethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import ExcelUtility.ExcelReader;
import PageObjects.Selfservice_flow_objects;
import TestBase.TestBase;

public class Selfservice_flow_methods extends TestBase {

	public static Selfservice_flow_objects self_objects;

	public static void login_link(List<WebElement> login_link) throws InterruptedException {

		if (login_link.size() > 0) {
			Commerce_all_methods.click_button(login_link);
			System.out.println("login clicked");
		}
	}

	public static void login_tstng(List<WebElement> username, List<WebElement> pwd, List<WebElement> submit,
			String username_data, String password) throws InterruptedException {

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.switchTo().frame("formFrame");

		if (username.size() > 0) {
			Commerce_all_methods.sendkeys(username, username_data);
			System.out.println("username entered");
		}
		if (pwd.size() > 0) {
			Commerce_all_methods.sendkeys(pwd, password);
			System.out.println("password entered");
		}
		if (submit.size() > 0) {
			Commerce_all_methods.click_button(submit);
			System.out.println("submit clicked");
		}

		driver.switchTo().defaultContent();
		Thread.sleep(6000);
	}

	public static void check_self_service(String email, String password, String subscription_product,
			String outputsheet) throws InterruptedException {

		self_objects = PageFactory.initElements(driver, Selfservice_flow_objects.class);
		try {
			Wait_Manual_Escape();
			Thread.sleep(8000);
			/*List<WebElement> close = driver.findElements(By.xpath(".//*[@id='pf-widget-headline']/..//button[@class='pf-widget-close']"));
			if(close.size()>0) {
				close.get(0).click();
				System.out.println("Popup Presnet and closed");
			}else {
				System.out.println("No New Pop Up to handle here ");
			}
			Thread.sleep(4000);
*/
			login_link(self_objects.tstng_login_link);
			
			
			Thread.sleep(4000);
			login_tstng(self_objects.tstng_login_username, self_objects.tstng_login_password,
					self_objects.tstng_login_submit, email, password);
			Thread.sleep(4000);
			Load_Url("https://stagesecure2.thestreet.com/cap/selfserve/SSMainMenu.jsp?site=tsc&url=https://www.thestreet.com/index.html&_ga=2.152301241.1029281905.1527246131-1493100615.1527246131");
			access_to_selfservice(self_objects.account, self_objects.account_dropdown, self_objects.account_pref,
					self_objects.account_premium);
			Thread.sleep(4000);
			check_selfservice_data(email, subscription_product, outputsheet);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Self Service Validation FAILED for ____" + subscription_product);

		}
	}

	public static void check_selfservice_data(String email, String product, String outputsheet) {

		try {
			self_objects = PageFactory.initElements(driver, Selfservice_flow_objects.class);

			Thread.sleep(4000);

			if (product.equalsIgnoreCase("Action Alerts PLUS")) {

				checkselfservice(email, product, outputsheet, self_objects.aap_selfservice_product_premiumservice,
						self_objects.aap_selfservice_product_category, self_objects.aap_selfservice_product_status,
						self_objects.aap_selfservice_product_price, self_objects.aap_selfservice_product_startdate,
						self_objects.aap_selfservice_product_enddate, self_objects.aap_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("Retirement Daily")) {

				checkselfservice(email, product, outputsheet,
						self_objects.retirement_selfservice_product_premiumservice,
						self_objects.retirement_selfservice_product_category,
						self_objects.retirement_selfservice_product_status,
						self_objects.retirement_selfservice_product_price,
						self_objects.retirement_selfservice_product_startdate,
						self_objects.retirement_selfservice_product_enddate,
						self_objects.retirement_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("Income Seeker")) {

				checkselfservice(email, product, outputsheet, self_objects.income_selfservice_product_premiumservice,
						self_objects.income_selfservice_product_category,
						self_objects.income_selfservice_product_status, self_objects.income_selfservice_product_price,
						self_objects.income_selfservice_product_startdate,
						self_objects.income_selfservice_product_enddate,
						self_objects.income_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("TheStreet Trifecta Stocks")) {

				checkselfservice(email, product, outputsheet, self_objects.trifecta_selfservice_product_premiumservice,
						self_objects.trifecta_selfservice_product_category,
						self_objects.trifecta_selfservice_product_status,
						self_objects.trifecta_selfservice_product_price,
						self_objects.trifecta_selfservice_product_startdate,
						self_objects.trifecta_selfservice_product_enddate,
						self_objects.trifecta_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("TheStreet.com Stocks Under $10")) {

				checkselfservice(email, product, outputsheet,
						self_objects.stocksunder_selfservice_product_premiumservice,
						self_objects.stocksunder_selfservice_product_category,
						self_objects.stocksunder_selfservice_product_status,
						self_objects.stocksunder_selfservice_product_price,
						self_objects.stocksunder_selfservice_product_startdate,
						self_objects.stocksunder_selfservice_product_enddate,
						self_objects.stocksunder_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("TheStreet.com Top Stocks")) {

				checkselfservice(email, product, outputsheet,
						self_objects.top_stocks_selfservice_product_premiumservice,
						self_objects.top_stocks_selfservice_product_category,
						self_objects.top_stocks_selfservice_product_status,
						self_objects.top_stocks_selfservice_product_price,
						self_objects.top_stocks_selfservice_product_startdate,
						self_objects.top_stocks_selfservice_product_enddate,
						self_objects.top_stocks_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("TheStreet.com Chairman's Club")) {

				checkselfservice(email, product, outputsheet, self_objects.chairman_selfservice_product_premiumservice,
						self_objects.chairman_selfservice_product_category,
						self_objects.chairman_selfservice_product_status,
						self_objects.chairman_selfservice_product_price,
						self_objects.chairman_selfservice_product_startdate,
						self_objects.chairman_selfservice_product_enddate,
						self_objects.chairman_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("RealMoney")) {

				checkselfservice(email, product, outputsheet, self_objects.rmy_selfservice_product_premiumservice,
						self_objects.rmy_selfservice_product_category, self_objects.rmy_selfservice_product_status,
						self_objects.rmy_selfservice_product_price, self_objects.rmy_selfservice_product_startdate,
						self_objects.rmy_selfservice_product_enddate, self_objects.rmy_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("RealMoney Pro")) {

				checkselfservice(email, product, outputsheet, self_objects.rmypro_selfservice_product_premiumservice,
						self_objects.rmypro_selfservice_product_category,
						self_objects.rmypro_selfservice_product_status, self_objects.rmypro_selfservice_product_price,
						self_objects.rmypro_selfservice_product_startdate,
						self_objects.rmypro_selfservice_product_enddate,
						self_objects.rmypro_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("RealMoney Pro Portfolio")) {

				checkselfservice(email, product, outputsheet,
						self_objects.rmypro_portfolio_selfservice_product_premiumservice,
						self_objects.rmypro_portfolio_selfservice_product_category,
						self_objects.rmypro_portfolio_selfservice_product_status,
						self_objects.rmypro_portfolio_selfservice_product_price,
						self_objects.rmypro_portfolio_selfservice_product_startdate,
						self_objects.rmypro_portfolio_selfservice_product_enddate,
						self_objects.rmypro_portfolio_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("Chatter on the Street")) {

				checkselfservice(email, product, outputsheet, self_objects.chatter_selfservice_product_premiumservice,
						self_objects.chatter_selfservice_product_category,
						self_objects.chatter_selfservice_product_status, self_objects.chatter_selfservice_product_price,
						self_objects.chatter_selfservice_product_startdate,
						self_objects.chatter_selfservice_product_enddate,
						self_objects.chatter_selfservice_product_renewal);

			} else if (product.equalsIgnoreCase("TheStreet Quant Ratings")) {

				checkselfservice(email, product, outputsheet,
						self_objects.quant_ratings_selfservice_product_premiumservice,
						self_objects.quant_ratings_selfservice_product_category,
						self_objects.quant_ratings_selfservice_product_status,
						self_objects.quant_ratings_selfservice_product_price,
						self_objects.quant_ratings_selfservice_product_startdate,
						self_objects.quant_ratings_selfservice_product_enddate,
						self_objects.quant_ratings_selfservice_product_renewal);

			} else {
				System.out.println("No data found");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		// System.out.println(email + "_____" + product);
	}

	public static void checkselfservice(String email, String product, String sheet, WebElement premium,
			WebElement category, WebElement status, WebElement price, WebElement start, WebElement end,
			WebElement renew) throws Exception {

		try {
			Thread.sleep(4000);
			String premiuma = premium.getText().toString().trim();
			String categorya = category.getText().toString().trim();
			String statusa = status.getText().toString().trim();
			String pricea = price.getText().toString().trim();
			String starta = start.getText().toString().trim();
			String enda = end.getText().toString().trim();
			String renewa = renew.getText().toString().trim();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String systemdate = df.format(date);
			String self_data[] = { premiuma, categorya, statusa, pricea, starta, enda, renewa, systemdate, email,
					product };
			ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\Testdata\\Outputs\\", "result.xlsx",
					sheet, self_data);
 
			test.log(LogStatus.PASS, "SelfService Validation PASSED for____" + product);
		} catch (Exception e) {
			test.log(LogStatus.FAIL,"SelfService Validation Failed or Unable to update Self service page information for____"
							+ product);
		}
	}

	public static void access_to_selfservice(WebElement account, WebElement accountdrop, WebElement accpref,
			WebElement account_premium) {
//		//button[@class='pf-widget-close']
		try {

			/*Thread.sleep(6000);
			Actions actions = new Actions(driver);
			Action sample = actions.moveToElement(account).build();
			sample.perform();

			Actions actions1 = new Actions(driver);
			actions1.moveToElement(accountdrop).click().build().perform();
			Thread.sleep(6000);
			Actions actions2 = new Actions(driver);
			actions2.moveToElement(accpref).click().build().perform();*/
			Thread.sleep(8000);
			List<WebElement> close = driver.findElements(By.xpath(".//*[@id='pf-widget-headline']/..//button[@class='pf-widget-close']"));
			if(close.size()>0) {
				close.get(0).click();
				System.out.println("Popup Presnet and closed");
			}else {
				System.out.println("No New Pop Up to handle here ");
			}
			Thread.sleep(3000);
			account_premium.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
