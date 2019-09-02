package TestBase;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExcelUtility.ConstantUtility;
import ExcelUtility.ExcelReader;
import PageLibrary.Ashot_comparison_Library;
import PageLibrary.CSR_flow_library;
import PageLibrary.Login_flow_library;
import PageLibrary.Selfservice_flow_library;
import PageLibrary.Signupflow_library;
import PageLibrary.Zuora_flow_library;
import PageMethods.Ashot_comparison_methods;
import PageMethods.CSR_flow_methods;
import PageMethods.Commerce_all_methods;
import PageMethods.Zuora_flow_methods;
import PageObjects.Ashots_Comparison_flow_objects;
import PageObjects.CSR_flow_objects;
import PageObjects.Login_flow_objects;
import PageObjects.Selfservice_flow_objects;
import PageObjects.Signup_flow_objects;
import PageObjects.Zuora_flow_objects;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class TestBase {

	public static WebDriver driver;
	public static Properties repo = new Properties();
	public File file;
	public FileInputStream fis;
	public String browser;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static File Folder = null;
	public static String timestamp = null;
	static int count = 0;
	public static Signupflow_library signupflow_library;
	public static Commerce_all_methods commerce_methods;
	public static CSR_flow_methods csr_methods;
	public static CSR_flow_objects csr_objects;
	public static CSR_flow_library csr_library;
	public static Selfservice_flow_objects self_objects;
	public static Selfservice_flow_library self_library;
	public static Login_flow_objects login_objects;
	public static Login_flow_library login_library;
	public static Signup_flow_objects signupflow_objects;
	public static Ashot_comparison_Library ashots_signup_library;
	public static Ashots_Comparison_flow_objects ashots_flow_objects;
	public static Zuora_flow_objects zuora_objects;
	public static Zuora_flow_library zuora_library;

	public static String x_path =ConstantUtility.compared_upsell_crosssell_x_path;
	
//	public static String compared_events_x_path = ConstantUtility.compared_events_x_path;

	public static void BASE_Directory_ashots_configuration(String name, String path) {

		File folder = new File(path + "/" + name + "/");
		folder.mkdir();

	}

	public static void SUB_Directory_ashots_configuration(String name, String product, String path) {

		File folder = new File(path + "/" + product + "/" + name);
		folder.mkdir();

	}

	public static void SUB_Directory_ashots_configuration_1(String name, String product, String path, String type) {

		File folder = new File(path + "/" + product + "/" + type + "/" + name);
		folder.mkdir();

	}

	public static void test_ashot_screenshot(String path, String name, String type, String filename, String type2)
			throws IOException {

		try {
			Screenshot fpScreenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000))
					.takeScreenshot(driver);
			ImageIO.write(fpScreenshot.getImage(), "PNG",
					new File(path + "/" + name + "/" + type + "/" + type2 + "/" + filename + ".png"));
		} catch (Exception e) {

		}

	}

	public static void TEST_COMPARE(String product, String oid, String plan) throws IOException {

		String Product_oid = product + "_" + oid;

		SUB_Directory_ashots_configuration("Compared", Product_oid, x_path);

		if (plan.equalsIgnoreCase("Monthly")) {

			SUB_Directory_ashots_configuration_1(plan, Product_oid, x_path, "Compared");

			try {
				Compare_Screeshots(Product_oid, plan + "_EC_with_details", "Compared_EC_with_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_EC_with_details");
			}

			try {
				Compare_Screeshots(Product_oid, plan + "_EC_without_details", "Compared_EC_without_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_EC_without_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CC_with_details", "Compared_CC_with_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CC_with_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CC_without_details", "Compared_CC_without_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CC_without_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_UPSELL", "Compared_UPSELL", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_UPSELL");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_UPSELL_YES_THANKYOU", "Compared_UPSELL_YES_THANKYOU", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_UPSELL_YES_THANKYOU");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL", "Compared_CROSSSELL", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL_NO_THANKYOU", "Compared_CROSSSELL_NO_THANKYOU",
						plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL_NO_THANKYOU");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL_YES_THANKYOU", "Compared_CROSSSELL_YES_THANKYOU",
						plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL_YES_THANBKYOU");

			}

		} else if (plan.equalsIgnoreCase("Annual")) {

			SUB_Directory_ashots_configuration_1(plan, Product_oid, x_path, "Compared");

			try {
				Compare_Screeshots(Product_oid, plan + "_EC_with_details", "Compared_EC_with_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_EC_with_details");
			}

			try {
				Compare_Screeshots(Product_oid, plan + "_EC_without_details", "Compared_EC_without_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_EC_without_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CC_with_details", "Compared_CC_with_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CC_with_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CC_without_details", "Compared_CC_without_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CC_without_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_UPSELL", "Compared_UPSELL", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_UPSELL");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_UPSELL_YES_THANKYOU", "Compared_UPSELL_YES_THANKYOU", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_UPSELL_YES_THANKYOU");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL", "Compared_CROSSSELL", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL_NO_THANKYOU", "Compared_CROSSSELL_NO_THANKYOU",
						plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL_NO_THANKYOU");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL_YES_THANKYOU", "Compared_CROSSSELL_YES_THANKYOU",
						plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL_YES_THANBKYOU");

			}
		} else if (plan.equalsIgnoreCase("Two Year")) {

			SUB_Directory_ashots_configuration_1(plan, Product_oid, x_path, "Compared");

			try {
				Compare_Screeshots(Product_oid, plan + "_EC_with_details", "Compared_EC_with_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_EC_with_details");
			}

			try {
				Compare_Screeshots(Product_oid, plan + "_EC_without_details", "Compared_EC_without_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_EC_without_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CC_with_details", "Compared_CC_with_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CC_with_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CC_without_details", "Compared_CC_without_details", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CC_without_details");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_UPSELL", "Compared_UPSELL", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_UPSELL");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_UPSELL_YES_THANKYOU", "Compared_UPSELL_YES_THANKYOU", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_UPSELL_YES_THANKYOU");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL", "Compared_CROSSSELL", plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL_NO_THANKYOU", "Compared_CROSSSELL_NO_THANKYOU",
						plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL_NO_THANKYOU");

			}

			try {
				Compare_Screeshots(Product_oid, plan + "_CROSSSELL_YES_THANKYOU", "Compared_CROSSSELL_YES_THANKYOU",
						plan);
			} catch (Exception e) {
				System.out.println("Failed to compare__" + plan + "_CROSSSELL_YES_THANBKYOU");

			}
		}

	}

	public static void EVENTS_TEST_COMPARE(String product, String oid, String plan) throws IOException {

		String Product_oid = oid;

		SUB_Directory_ashots_configuration("Compared", Product_oid, x_path);

		// SUB_Directory_ashots_configuration_1(plan, Product_oid, x_path, "Compared");

		try {
			EVENTS_Compare_Screeshots(Product_oid, "EC", "Compared_EC", "", "Old", "New");
		} catch (Exception e) {
			System.out.println("Failed to compare__" + plan + "_EC_with_details");
		}

		try {
			EVENTS_Compare_Screeshots(Product_oid, "CC_NO_DETAIL", "Compared_CC_No_Detail", "", "Old", "New");
		} catch (Exception e) {
			System.out.println("Failed to compare__" + plan + "_EC_without_details");

		}

		try {
			EVENTS_Compare_Screeshots(Product_oid, "CC_DETAIL", "Compared_CC_Detail", "", "Old", "New");
		} catch (Exception e) {
			System.out.println("Failed to compare__" + plan + "_CC_with_details");

		}

		try {
			EVENTS_Compare_Screeshots(Product_oid, "TY", "Compared_TY", "", "Old", "New");
		} catch (Exception e) {
			System.out.println("Failed to compare__" + plan + "_CC_without_details");

		}

	}

	public static void Compare_Screeshots(String Product_oid, String image, String resultant_image, String plan)
			throws IOException

	{

		File demo_monthy_EC = new File(x_path + "//" + Product_oid + "//Demo//" + plan + "//" + image + ".png");
		BufferedImage demo_buffered_monthy_EC = ImageIO.read(demo_monthy_EC);

		File stage_monthy_EC = new File(x_path + "//" + Product_oid + "//Stage//" + plan + "//" + image + ".png");
		BufferedImage stage_buffered_monthy_EC = ImageIO.read(stage_monthy_EC);

		ImageDiff diff_monthly_EC = new ImageDiffer().makeDiff(demo_buffered_monthy_EC, stage_buffered_monthy_EC);
		BufferedImage comparedImage_monthly_EC = diff_monthly_EC.getMarkedImage();

		System.out.println("Done Image Comparison process");

		ImageIO.write(comparedImage_monthly_EC, "PNG",
				new File(x_path + "\\" + Product_oid + "\\Compared\\" + plan + "\\" + resultant_image + ".png"));

		System.out.println("Done Image write process");
	}

	public static void EVENTS_Compare_Screeshots(String Product_oid, String image, String resultant_image, String plan,
			String type1, String type2) throws IOException

	{

		File demo_monthy_EC = new File(
				x_path + "//" + Product_oid + "//" + type1 + "//" + plan + "//" + image + ".png");
		BufferedImage demo_buffered_monthy_EC = ImageIO.read(demo_monthy_EC);

		File stage_monthy_EC = new File(
				x_path + "//" + Product_oid + "//" + type2 + "//" + plan + "//" + image + ".png");
		BufferedImage stage_buffered_monthy_EC = ImageIO.read(stage_monthy_EC);

		ImageDiff diff_monthly_EC = new ImageDiffer().makeDiff(demo_buffered_monthy_EC, stage_buffered_monthy_EC);
		BufferedImage comparedImage_monthly_EC = diff_monthly_EC.getMarkedImage();

		System.out.println("Done Image Comparison process");

		ImageIO.write(comparedImage_monthly_EC, "PNG",
				new File(x_path + "\\" + Product_oid + "\\Compared\\" + plan + "\\" + resultant_image + ".png"));

		System.out.println("Done Image write process");
	}

	public static String Get_Random_values() {
		Random random = new Random();
		String CHARS = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890";
		StringBuilder token = new StringBuilder(4);
		for (int i = 0; i <= 4; i++) {
			token.append(CHARS.charAt(random.nextInt(CHARS.length())));
		}
		System.out.println(token.toString());
		return token.toString();
	}

	public static void Wait_Manual_Escape() throws AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		System.out.println("Stopped Loading Manually");
	}

	public static void Scroll_Down(int pixel) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + pixel + ")", "");
	}

	public static void Go_Down() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public static void Load_Url(String url) {
		driver.get(url);
	}

	public static void Remove_results(String subscription, String csr, String selfservice, String Zuora,
			String random_mail, String zuora_subscription) throws IOException {
		ExcelReader.remove(subscription);
		ExcelReader.remove(csr);
		ExcelReader.remove(selfservice);
		ExcelReader.remove(Zuora);
		ExcelReader.remove(random_mail);
		ExcelReader.remove(zuora_subscription);

	}

	public static String dateStamp(String prefixString) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("_Y'_'MMM'_'dd");
		String foldername = ft.format(dNow);
		return prefixString + foldername;

	}

	public void optimizely_check(String pro) throws InterruptedException {

		/*
		 * String source = driver.getPageSource();
		 * 
		 * Thread.sleep(6000);
		 * if(source.contains("optimizely ")||(source.contains("optimizely"))||(source.
		 * contains("https://cdn.optimizely.com/js/8528040407.js"))) {
		 * 
		 * System.out.println(pro+"__Yes Optimizely  is present");
		 * 
		 * 
		 * }else { System.out.println(pro+"___NO Optimizely  is not  present"); }
		 */

	}

	public static String Formated_Number() {
		long random_number_withsuffix = System.nanoTime();
		String result = String.format("%04d", random_number_withsuffix % 10000);
		return result;

	}

	public static void SINGLE_USER_START_CONFIGURATIONS() throws InterruptedException {
		load_extentreport(ConstantUtility.commerce_report_location);
		selectBrowser(ConstantUtility.browser);
	}

	public static void RANDOM_USER_START_CONFIGURATIONS() throws InterruptedException {
		load_extentreport(ConstantUtility.commerce_report_location);
	}

	public static void UPSELL_CROSSSELL_USER_START_CONFIGURATIONS() throws InterruptedException {
		selectBrowser(ConstantUtility.browser);
		load_extentreport(ConstantUtility.commerce_report_location);
	}

	public static void START_SINGLE_USER_SUBSCRIPTION(String execution, String Susbcription_status, String csr_status,
			String selfservice_status, String Login_status, String zuora_status, String upsell, String image_status,
			String crossell, String product, String oid, String premium_product_url, String email, String Fname,
			String Lname, String pwd, String confirmpwd, String subscriptionType, String ccNumber, String cvvCode,
			String exMonth, String exYear, String nameOnCard, String address1, String address2, String city,
			String state, String country, String postalCode, String phoneNum, String stage_login_url, String auto_email,
			String type) {

		if (execution.equalsIgnoreCase("Yes")) {
			System.out.println("Execution status yes");
			test = extent.startTest(product);
			// SUBSCRIPTION PROCESS
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (Susbcription_status.equalsIgnoreCase("Yes")) {

				try {

					Load_Url(premium_product_url);
					START_ZUORA_SUBSCRIPTION(premium_product_url, upsell, crossell, image_status, oid, auto_email,
							Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth,
							exYear, nameOnCard, address1, address2, city, state, country, postalCode, phoneNum,
							ConstantUtility.singleuser_thankyou_page, type);

					update_random_emails(auto_email, product, ConstantUtility.update_single_email);
					Clear_Cookies();
				} catch (Exception e) {
				}
				System.out.println("subscription status yes");
			} else {
				System.out.println("Unable to Subscribe" + "__Product : " + product);
			}

			// CSR VALIDATION PROCESS
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (csr_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(ConstantUtility.csr_url);
					START_CSR_TEST(ConstantUtility.csr_username, ConstantUtility.csr_pwd, product,
							ConstantUtility.singleuser_csr_sheet, auto_email, pwd);
					Clear_Cookies();

				} catch (Exception e) {
				}
				System.out.println("CSR Status yes");
			} else {
				System.out.println("CSR Status is not ready");
			}

			// SELF SERVICE PAGE VALIDATION PROCESS
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (selfservice_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(ConstantUtility.stageTstng_url);
					START_SELFSERVICE_TEST(auto_email, pwd, product, ConstantUtility.singleuser_self_sheet);
					Clear_Cookies();

				} catch (Exception e) {
					closebrowser();
				}
				System.out.println("Self service  Status yes");
			} else {
				System.out.println("Self service  Status is not ready");
			}
			// LOGIN TO PREMIUM PRODUCTS PROCESS
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (Login_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(stage_login_url);
					START_LOGIN_TEST(product, auto_email, pwd);
					Clear_Cookies();

				} catch (Exception e) {
				}
				System.out.println("Login Status yes");
			} else {
				System.out.println("Login Status is not ready");
			}

			// REPORT GENERATION
			extent.endTest(test);

			System.out.println("The" + "___" + product + "___" + "is subscribed successfully");
		} else {
			System.out.println("Unable to execute for __" + product);
		}
	}

	public static void START_RANDOM_USER_SUBSCRIPTION(String execution, String Susbcription_status, String csr_status,
			String selfservice_status, String Login_status, String zuora_status, String Upsell, String crossell,
			String image_status, String product, String oid, String premium_product_url, String email, String Fname,
			String Lname, String pwd, String confirmpwd, String subscriptionType, String ccNumber, String cvvCode,
			String exMonth, String exYear, String nameOnCard, String address1, String address2, String city,
			String state, String country, String postalCode, String phoneNum, String stage_login_url, String type)
			throws InterruptedException {

		if (execution.equalsIgnoreCase("Yes")) {
			selectBrowser(ConstantUtility.browser);
			System.out.println("Execution status yes");
			/*
			 * long random_number_withsuffix = System.nanoTime(); String result =
			 * String.format("%04d", random_number_withsuffix % 10000);
			 */
			ConstantUtility.auto_email = email + Formated_Number() + Get_Random_values() + ConstantUtility.mail_suffix;
			System.out.println(ConstantUtility.auto_email);
			Thread.sleep(5000);
			test = extent.startTest(product + "_" + oid + "_" + subscriptionType);

			// SUBSCRIPTION PROCESS
			if (Susbcription_status.equalsIgnoreCase("Yes")) {
				try {

					Load_Url(premium_product_url);
					START_ZUORA_SUBSCRIPTION(premium_product_url, Upsell, crossell, image_status, oid,
							ConstantUtility.auto_email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber,
							product, cvvCode, exMonth, exYear, nameOnCard, address1, address2, city, state, country,
							postalCode, phoneNum, ConstantUtility.random_thankyou_page, type);
					update_random_emails(ConstantUtility.auto_email, product, ConstantUtility.update_random_email);
					Clear_Cookies();
				} catch (Exception e) {
				}
				System.out.println("subscription status yes");
			} else {
				System.out.println("Unable to Subscribe" + "__Product : " + product);
			}

			// CSR VALIDATION PROCESS
			if (csr_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(ConstantUtility.csr_url);
					START_CSR_TEST(ConstantUtility.csr_username, ConstantUtility.csr_pwd, product,
							ConstantUtility.random_csr_sheet, ConstantUtility.auto_email,
							ConstantUtility.Signup_flow_password);
					Clear_Cookies();

				} catch (Exception e) {
				}
				System.out.println("CSR Status yes");
			} else {
				System.out.println("CSR Status is not ready");
			}

			// SELF SERVICE PAGE VALIDATION PROCESS
			if (selfservice_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(ConstantUtility.stageTstng_url);
					START_SELFSERVICE_TEST(ConstantUtility.auto_email, pwd, product, ConstantUtility.random_self_sheet);
					Clear_Cookies();

				} catch (Exception e) {
				}
				System.out.println("Self service  Status yes");
			} else {
				System.out.println("Self service  Status is not ready");
			}

			// LOGIN TO PREMIUM PRODUCTS PROCESS
			if (Login_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(stage_login_url);
					START_LOGIN_TEST(product, ConstantUtility.auto_email, pwd);
					Clear_Cookies();

				} catch (Exception e) {
				}
				System.out.println("Login Status yes");
			} else {
				System.out.println("Login Status is not ready");
			}

			// REPORT GENERATION
			closebrowser();
			extent.endTest(test);

			System.out.println("The" + "___" + product + "___" + "is subscribed successfully");
		} else {
			System.out.println("Unable to execute for __" + product);
		}

	}

	public static void START_UPSELL_CROSSELL_PAGE_VALIDATION(String execution, String Susbcription_status,
			String csr_status, String selfservice_status, String Login_status, String zuora_status, String Upsell,
			String crossell, String image_status, String product, String oid, String premium_product_url, String email,
			String Fname, String Lname, String pwd, String confirmpwd, String subscriptionType, String ccNumber,
			String cvvCode, String exMonth, String exYear, String nameOnCard, String address1, String address2,
			String city, String state, String country, String postalCode, String phoneNum, String stage_login_url,
			String type, String subscription_thankyoupage_outputsheet) throws InterruptedException, IOException {

		if (execution.equalsIgnoreCase("Yes")) {

			test = extent.startTest(product + "_" + oid + "_" + subscriptionType);

			// SUBSCRIPTION PROCESS
			if (Susbcription_status.equalsIgnoreCase("Yes")) {
				Load_Url(premium_product_url);
				System.out.println(image_status);
				ConstantUtility.auto_email = email + Formated_Number() + Get_Random_values()
						+ ConstantUtility.mail_suffix;
				START_ZUORA_SUBSCRIPTION(premium_product_url, Upsell, crossell, image_status, oid,
						ConstantUtility.auto_email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product,
						cvvCode, exMonth, exYear, nameOnCard, address1, address2, city, state, country, postalCode,
						phoneNum, subscription_thankyoupage_outputsheet, type);

			} else {

			}
		} else {

		}

	}

	public static void START_UPSELL_CROSSSELL_USER_SUBSCRIPTION(String execution, String Susbcription_status,
			String csr_status, String selfservice_status, String Login_status, String zuora_status, String Upsell,
			String crossell, String image_status, String product, String oid, String premium_product_url, String email,
			String Fname, String Lname, String pwd, String confirmpwd, String subscriptionType, String ccNumber,
			String cvvCode, String exMonth, String exYear, String nameOnCard, String address1, String address2,
			String city, String state, String country, String postalCode, String phoneNum, String stage_login_url,
			String type, String subscription_thankyoupage_outputsheet) throws InterruptedException {

		if (execution.equalsIgnoreCase("Yes")) {
			// selectBrowser(ConstantUtility.browser);
			System.out.println("Execution status yes");
			/*
			 * long random_number_withsuffix = System.nanoTime(); String result =
			 * String.format("%04d", random_number_withsuffix % 10000);
			 */
			ConstantUtility.auto_email = email + Formated_Number() + Get_Random_values() + ConstantUtility.mail_suffix;
			System.out.println(ConstantUtility.auto_email);
			Thread.sleep(5000);
			test = extent.startTest(product + "_" + oid + "_" + subscriptionType);

			// SUBSCRIPTION PROCESS
			if (Susbcription_status.equalsIgnoreCase("Yes")) {
				try {

					Load_Url(premium_product_url);
					System.out.println(image_status);

					START_ZUORA_SUBSCRIPTION(premium_product_url, Upsell, crossell, image_status, oid,
							ConstantUtility.auto_email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber,
							product, cvvCode, exMonth, exYear, nameOnCard, address1, address2, city, state, country,
							postalCode, phoneNum, subscription_thankyoupage_outputsheet, type);
					// update_random_emails(ConstantUtility.auto_email, product,
					// ConstantUtility.update_random_email);
					Clear_Cookies();
				} catch (Exception e) {
				}
				System.out.println("subscription status yes");
			} else {
				System.out.println("Unable to Subscribe" + "__Product : " + product);
			}

			// CSR VALIDATION PROCESS
			if (csr_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(ConstantUtility.csr_url);
					START_CSR_TEST(ConstantUtility.csr_username, ConstantUtility.csr_pwd, product,
							ConstantUtility.random_csr_sheet, ConstantUtility.auto_email,
							ConstantUtility.Signup_flow_password);
					Clear_Cookies();

				} catch (Exception e) {
				}
				System.out.println("CSR Status yes");
			} else {
				System.out.println("CSR Status is not ready");
			}

			// SELF SERVICE PAGE VALIDATION PROCESS
			if (selfservice_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(ConstantUtility.stageTstng_url);
					START_SELFSERVICE_TEST(ConstantUtility.auto_email, pwd, product, ConstantUtility.random_self_sheet);
					Clear_Cookies();

				} catch (Exception e) {
				}
				System.out.println("Self service  Status yes");
			} else {
				System.out.println("Self service  Status is not ready");
			}

			// LOGIN TO PREMIUM PRODUCTS PROCESS
			if (Login_status.equalsIgnoreCase("Yes")) {
				try {
					Load_Url(stage_login_url);
					START_LOGIN_TEST(product, ConstantUtility.auto_email, pwd);
					Clear_Cookies();

				} catch (Exception e) {
				}
				System.out.println("Login Status yes");
			} else {
				System.out.println("Login Status is not ready");
			}

			// REPORT GENERATION
			// closebrowser();
			extent.endTest(test);

			System.out.println("The" + "___" + product + "___" + "is subscribed successfully");
		} else {
			System.out.println("Unable to execute for __" + product);
		}

	}

	public static void START_SINGLE_USER_ZUORA_VALIDATIONS() {
		try {
			Thread.sleep(15000);
			test = extent.startTest("Zuora Validations");
			Load_Url(ConstantUtility.Zuora_url);
			START_ZUORA_TEST(ConstantUtility.zuora_username, ConstantUtility.zuora_password,
					ConstantUtility.update_single_email, ConstantUtility.single_zuora_sheet,
					ConstantUtility.Zuora_Scenario_normal);
			Clear_Cookies();
			extent.endTest(test);
		} catch (Exception e) {
		}
	}

	public static void START_RANDOM_USER_VALIDATION() {
		try {
			Thread.sleep(15000);
			test = extent.startTest("Zuora Validations");
			selectBrowser(ConstantUtility.browser);
			Load_Url(ConstantUtility.Zuora_url);
			START_ZUORA_TEST(ConstantUtility.zuora_username, ConstantUtility.zuora_password,
					ConstantUtility.update_random_email, ConstantUtility.random_zuora_sheet,
					ConstantUtility.Zuora_Scenario_random);
			Clear_Cookies();
			closebrowser();
			extent.endTest(test);
		} catch (Exception e) {

		}
	}

	public static void SINGLE_USER_END_CONFIGURATIONS(String attachement_filename, String subject, String body)
			throws IOException {
		closebrowser();
		extent.flush();
		Email_Utils.commerce_subscription(attachement_filename, subject, body);
		Remove_results(ConstantUtility.singleuser_thankyou_page, ConstantUtility.singleuser_csr_sheet,
				ConstantUtility.singleuser_self_sheet, ConstantUtility.single_zuora_sheet,
				ConstantUtility.update_single_email, "");
	}

	public static void RANDOM_USER_END_CONFIGURATION(String attachement_filename, String subject, String body)
			throws IOException {
		extent.flush();
		Email_Utils.commerce_subscription(attachement_filename, subject, body);
		Remove_results(ConstantUtility.random_thankyou_page, ConstantUtility.random_csr_sheet,
				ConstantUtility.random_self_sheet, ConstantUtility.random_zuora_sheet,
				ConstantUtility.update_random_email, "");
	}

	public static void UPSELL_CROSSSELL_USER_END_CONFIGURATION(String attachement_filename, String subject, String body)
			throws IOException {
		 try {
			 closebrowser();
			 extent.flush();
			  Email_Utils.commerce_subscription(attachement_filename,subject,body);
			  Remove_results(ConstantUtility.upsell_crosssell_sheet, "", "",
			  "",ConstantUtility.update_random_email, ConstantUtility.Event_subscription);
		} catch (Exception e) {
			System.out.println(e);
		}
		 
	}

	public static void Validate_Production_CSR(String execution, String url, String email,
			String product,String sheet)throws InterruptedException, IOException {
	
//	String execution, String product, String userID, String subscriptionID
			
		/*Access_csr_user_production(csr_objects.csr_search_specific_type, csr_objects.csr_search_specific_type_userid,
				userID, csr_objects.csr_search_specific_type_submit, csr_objects.csr_customer_email,
				csr_objects.csr_product_status_thestreet_event);*/
		
		signupflow_objects = PageFactory.initElements(driver, Signup_flow_objects.class);
		try {
			Load_Url(url);
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
					email, "test", "test", "test", "test", "test", "test", "test", "test", "test", "test",
					"test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test",
					url, sheet);
			
			System.out.println(email);
			System.out.println(url);
			System.out.println("signup flow done");
			
						
			test.log(LogStatus.PASS, url + "_Working");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, url + "_Not Working");

		}
	} 

	public static void Access_csr_user_production(List<WebElement> specific_type, List<WebElement> userid,
			String user_id_csr, List<WebElement> submit, List<WebElement> email, List<WebElement> status)
			throws InterruptedException, IOException {

		/*try {
			commerce_methods.click_button(specific_type);

			commerce_methods.sendkeys(userid, user_id_csr);

			commerce_methods.click_button(submit);

			Fetch_details_of_event_subscribers_production_CSR(email, status,user_id_csr);
			
			driver.navigate().back();

		} catch (Exception e) {
			System.out.println(e);
		}*/

	}

	public static void Fetch_details_of_event_subscribers_production_CSR(List<WebElement> email,
			List<WebElement> status,String userid) throws IOException {

		String email_data = email.get(0).getAttribute("value").toString();
		System.out.println("email is_____" + email_data);

		String status_data = status.get(0).getText().toString().trim();
		System.out.println("status is_____" + status_data);

		String csr_data[] = { email_data,userid, status_data };
		ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\Testdata\\Outputs\\", "result.xlsx",
				"events_prod_csr", csr_data);

	}

	public static void IMAGE_COMPARISON_START_CONFIGURATION() throws InterruptedException {
		load_extentreport(ConstantUtility.ashots_location);
		selectBrowser(ConstantUtility.browser);
	}

	public static void START_IMAGE_COMPARISON_PROCESS(String Ex_Status, String QA_Url, String Live_Url, String Product,
			String Email) {
		if (Ex_Status.equalsIgnoreCase("Yes") || Ex_Status.equalsIgnoreCase("yes")) {
			test = extent.startTest(Product);

			Load_Url(QA_Url);
			System.out.println(QA_Url);
			System.out.println(ConstantUtility.QA);
			try {
				START_ASHOTS_COMPARISON(QA_Url, Product, Email, ConstantUtility.QA);
			} catch (Exception e) {
				test.log(LogStatus.FAIL, Product + "is Failed to Compare the QA");
			}
			Load_Url(Live_Url);
			System.out.println(Live_Url);
			System.out.println(ConstantUtility.LIVE);
			try {
				START_ASHOTS_COMPARISON(QA_Url, Product, Email, ConstantUtility.LIVE);
			} catch (Exception e) {
				test.log(LogStatus.FAIL, Product + "is Failed to Compare Live");
			}
			try {
				compare_ashots(Product);
			} catch (Exception e) {
				test.log(LogStatus.FAIL, Product + "is Failed to Compare the QA and Live");
			}

			System.out.println("The" + "___" + Product + "___" + "is Compared successfully");
		} else {

			System.out.println("Unable to Compare" + "__Product : " + Product);
		}

		extent.endTest(test);
		extent.flush();
	}

	public static void IMAGE_COMPARISON_END_CONFIGURATION(String filename, String subject, String body) {
		closebrowser();
		Email_Utils.commerce_comparison(filename, subject, body);
	}

	public static void ashots_configuration(String product, String dir_name) {
		// String x_path1 =
		// "X://Technology//QA//TheStreet//SeleniumReports//Ashots_gallery//";

		String x_path = "\\\\chnnas02//TheStreet_Automation//Automation_Reports//Ashots_gallery//";
		File folder = new File(x_path + dir_name + "/" + dateStamp(product) + "/");
		folder.mkdir();

	}

	public static void ashot_screenshot(String product, String page, String dir_name) throws IOException {

		String x_path = "\\\\chnnas02//TheStreet_Automation//Automation_Reports//Ashots_gallery//";

		try {
			Screenshot fpScreenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000))
					.takeScreenshot(driver);
			ImageIO.write(fpScreenshot.getImage(), "PNG",
					new File(x_path + dir_name + "/" + dateStamp(product) + "/", page + ".png"));
		} catch (Exception e) {

		}

	}

	public static void compare_ashots(String product) throws IOException

	{
		try {
			// File Path

			String x_path = "\\\\chnnas02//TheStreet_Automation//Automation_Reports//Ashots_gallery";
			String merge_path = "\\\\chnnas02//TheStreet_Automation//Automation_Reports//Ashots_gallery//Merged//"
					+ dateStamp(product);

			// QA File Creation

			File QA_MLP = new File(x_path + "//QA//" + dateStamp(product) + "/MLP.png");
			File QA_EC = new File(x_path + "//QA//" + dateStamp(product) + "/EC.png");
			File QA_CC = new File(x_path + "//QA//" + dateStamp(product) + "/CC.png");

			// QA File Creation

			File Live_MLP = new File(x_path + "//Live//" + dateStamp(product) + "/MLP.png");
			File Live_EC = new File(x_path + "//Live//" + dateStamp(product) + "/EC.png");
			File Live_CC = new File(x_path + "//Live//" + dateStamp(product) + "/CC.png");

			// Find QA MLP Dimensions

			BufferedImage qa_mlp = ImageIO.read(QA_MLP);
			int width_qa_mlp = qa_mlp.getWidth();
			int height_qa_mlp = qa_mlp.getHeight();

			// Find LIVE MLP Dimensions

			BufferedImage live_mlp = ImageIO.read(Live_MLP);
			int width_live_mlp = live_mlp.getWidth();
			int height_live_mlp = live_mlp.getHeight();

			// Differ QA MLP and LIVE MLP

			int new_height_mlp = (height_qa_mlp + height_live_mlp) / 2;
			ImageDiff differ_mlp = new ImageDiffer().makeDiff(live_mlp, qa_mlp);

			// MERGE QA MLP and LIVE MLP
			BufferedImage mlp_concate = new BufferedImage(width_qa_mlp + width_live_mlp, height_live_mlp,
					BufferedImage.TYPE_INT_RGB);
			boolean mlp1 = mlp_concate.createGraphics().drawImage(qa_mlp, 0, 0, null);
			boolean mlp2 = mlp_concate.createGraphics().drawImage(live_mlp, width_qa_mlp, 0, null);
			ashots_configuration(product, "Merged");
			File final_mlp1 = new File(merge_path + "/merged_mlp.png");
			boolean final_mlp2 = ImageIO.write(mlp_concate, "png", final_mlp1);

			// Find QA EC Dimensions

			BufferedImage qa_ec = ImageIO.read(QA_EC);
			int width_qa_ec = qa_ec.getWidth();
			int height_qa_ec = qa_ec.getHeight();

			// Find QA LIVE Dimensions

			BufferedImage live_ec = ImageIO.read(Live_EC);
			int width_live_ec = live_ec.getWidth();
			int height_live_ec = live_ec.getHeight();

			// Differ QA EC and LIVE EC

			int new_height_ec = (height_qa_ec + height_live_ec) / 2;
			ImageDiff differ_ec = new ImageDiffer().makeDiff(qa_ec, live_ec);

			// MERGE QA EC and LIVE EC

			BufferedImage ec_concate = new BufferedImage(width_qa_ec + width_live_ec, height_live_ec,
					BufferedImage.TYPE_INT_RGB);
			boolean ec1 = ec_concate.createGraphics().drawImage(qa_ec, 0, 0, null);
			boolean ec2 = ec_concate.createGraphics().drawImage(live_ec, width_qa_ec, 0, null);
			ashots_configuration(product, "Merged");
			File final_ec1 = new File(merge_path + "//merged_ec.png");
			boolean final_ec2 = ImageIO.write(ec_concate, "png", final_ec1);

			// Find QA CC Dimensions

			BufferedImage qa_cc = ImageIO.read(QA_CC);
			int width_qa_cc = qa_cc.getWidth();
			int height_qa_cc = qa_cc.getHeight();

			// Find LIVE CC Dimensions

			BufferedImage live_cc = ImageIO.read(Live_CC);
			int width_live_cc = live_cc.getWidth();
			int height_live_cc = live_cc.getHeight();

			// Differ QA CC and LIVE CC

			int new_height_cc = (height_qa_cc + height_live_cc) / 2;
			ImageDiff differ_cc = new ImageDiffer().makeDiff(qa_cc, live_cc);

			// MERGE QA CC and LIVE CC

			BufferedImage cc_concate = new BufferedImage(width_qa_cc + width_live_cc, height_live_cc,
					BufferedImage.TYPE_INT_RGB);
			boolean cc1 = cc_concate.createGraphics().drawImage(qa_cc, 0, 0, null);
			boolean cc2 = cc_concate.createGraphics().drawImage(live_cc, width_qa_cc, 0, null);
			ashots_configuration(product, "Merged");
			File final_cc1 = new File(merge_path + "//merged_cc.png");
			boolean final_cc2 = ImageIO.write(cc_concate, "png", final_cc1);

			// Get Compared Image

			BufferedImage comparedImage_mlp = differ_mlp.getMarkedImage();
			BufferedImage comparedImage_ec = differ_ec.getMarkedImage();
			BufferedImage comparedImage_cc = differ_cc.getMarkedImage();

			// Size of Differentiation

			int size_mlp = differ_mlp.getDiffSize();
			int size_ec = differ_ec.getDiffSize();
			int size_cc = differ_cc.getDiffSize();
			int percent = 100;
			float mlp_answer = size_mlp / percent;
			float ec_answer = size_ec / percent;
			float cc_answer = size_cc / percent;

			// Compare Directory Creation
			ashots_configuration(product, "Compare");

			// Write Compared Images

			ImageIO.write(comparedImage_mlp, "PNG",
					new File(x_path + "//Compare//" + dateStamp(product) + "//compare_mlp.png"));

			ImageIO.write(comparedImage_ec, "PNG",
					new File(x_path + "//Compare//" + dateStamp(product) + "/compare_ec.png"));

			ImageIO.write(comparedImage_cc, "PNG",
					new File(x_path + "//Compare//" + dateStamp(product) + "/compare_cc.png"));

			// Log into Extent report

			test.log(LogStatus.PASS,
					"QA & Live_MLP"
							+ test.addScreenCapture(x_path + "//Merged//" + dateStamp(product) + "//merged_mlp.png"),
					"Different size of MLP=" + mlp_answer
							+ test.addScreenCapture(x_path + "//Compare//" + dateStamp(product) + "//compare_mlp.png"));

			test.log(LogStatus.PASS,
					"QA & Live_EC"
							+ test.addScreenCapture(x_path + "//Merged//" + dateStamp(product) + "//merged_ec.png"),
					"Different size size of EC=" + ec_answer
							+ test.addScreenCapture(x_path + "//Compare//" + dateStamp(product) + "//compare_ec.png"));

			test.log(LogStatus.PASS,
					"QA & Live_CC"
							+ test.addScreenCapture(x_path + "//Merged//" + dateStamp(product) + "//merged_cc.png"),
					"Different size size of CC=" + cc_answer
							+ test.addScreenCapture(x_path + "//Compare//" + dateStamp(product) + "//compare_cc.png"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static String date() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		String foldername = ft.format(dNow);
		return foldername;
	}

	public static void load_extentreport(String dir_loc)

	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY-HH-mm-ss");
		timestamp = format.format(cal.getTime());
		File dir = new File("\\\\chnnas02\\TheStreet_Automation\\Automation_Reports\\" + dir_loc + "\\" + timestamp);
		dir.mkdir();
		Folder = dir;
		extent = new ExtentReports(dir + "\\testoutputReport -" + timestamp + ".html", true);
		extent.addSystemInfo("Author", "Saravanan");
		extent.loadConfig(new File(""));
	}

	/*
	 * public void load_extentreport_ashot(String dir_loc)
	 * 
	 * { Calendar cal = Calendar.getInstance(); SimpleDateFormat format = new
	 * SimpleDateFormat("dd-MMM-YYYY-HH-mm-ss"); timestamp =
	 * format.format(cal.getTime()); File dir = new
	 * File("X:\\Technology\\QA\\TheStreet\\SeleniumReports\\" + dir_loc + "\\" +
	 * timestamp); dir.mkdir(); Folder = dir; extent = new ExtentReports(dir +
	 * "\\testoutputReport -" + timestamp + ".html", true);
	 * extent.addSystemInfo("Author", "Saravanan"); extent.loadConfig(new File(""));
	 * }
	 */

	/*
	 * To highlight the input fields using javascript, gets implemented
	 */
	public static void highlighElement(WebDriver driver, List<WebElement> element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].style.border='3px solid red'", element);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element.get(0),
					"color: black; border: 4px solid red;");
		} catch (Exception e) {

		}

	}

	/*
	 * Based on the excel information given browser will call and navigate to given
	 * url
	 */
	public static void selectBrowser(String browser) throws InterruptedException

	{

		if (browser.equalsIgnoreCase("firefox"))

		{
			driver = new FirefoxDriver();
			// driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(3000);

		} else if (browser.equalsIgnoreCase("chrome"))

		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\chromedriver.exe");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			LoggingPreferences pref = new LoggingPreferences();
			pref.enable(LogType.BROWSER, Level.ALL);
			cap.setCapability(CapabilityType.LOGGING_PREFS, pref);
			driver = new ChromeDriver(cap);
			// driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(3000);

		}

	}

	public boolean GetJSErrosLog() throws FileNotFoundException {
		// Capture all JSerrors and print In console.
		LogEntries jserrors = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry error : jserrors) {
			System.out.println(error.toString());
		}

		return true;
	}

	public LogStatus breakjs_names() throws FileNotFoundException {
		/*
		 * System.out.println(driver.getTitle());
		 * System.out.println(driver.getCurrentUrl()); System.out.println(
		 * "=============================================================");
		 * GetJSErrosLog();
		 */
		return null;
	}

	public static void Back() {
		driver.navigate().back();
	}

	public void Failures(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;

				File source = ts.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(source, new File(
						"P://saravanan//TheStreet_Automation//TheStreetCommerce_Zuora//src//test//java//Screenshots//"
								+ result.getName() + ".png"));

				System.out.println("Screenshot taken");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

	}

	public static void Takescreenshot(WebDriver driver, String path, String filename) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path + filename + ".png"));
		System.out.println("Screen captured successfully");
	}

	public static String getscreenshotjs(WebDriver driver, String path, String filename) throws Exception {
		count++;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String absolutepath = path + filename + count + ".png";
		// System.out.println(absolutepath);

		FileHandler.copy(scrFile, new File(absolutepath));
		return absolutepath;
	}

	public static void ZUORA_SUBSCRIPTION_START_CONFIGURATION(String email) throws Exception {
		load_extentreport(ConstantUtility.commerce_report_location);
		selectBrowser(ConstantUtility.browser);
		Load_Url(ConstantUtility.csr_url);
		test = extent.startTest("Zuora Subscription Flow");
		ZUORA_FLOW_CSR_FLOW(ConstantUtility.csr_username, ConstantUtility.csr_pwd, email);
	}

	public static void ZUORA_SUBSCRIPTION_END_CONFIGURATION(String filename, String subject, String body)
			throws IOException {
		extent.endTest(test);
		extent.flush();
		closebrowser();
		Email_Utils.commerce_subscription(filename, subject, body);
		Remove_results("", "", "", "", "", ConstantUtility.zuora_subscription);
	}

	public static void DO_ZUORA_SUBSCRIPTION(String Exe_status, String Product_name, String Rate_plan, String email)
			throws Exception {
		if (Exe_status.equalsIgnoreCase("Yes")) {
			PROCESS_ZUORA_SUBSCRIPTION(Product_name, Rate_plan, email, ConstantUtility.zuora_subscription_outputsheet);
		} else {
			System.out.println("Unable to subscribe ___" + Product_name);
		}
	}

	public static void START_ZUORA_BILL_RUN_PROCESS(String email) {
		try {
			Thread.sleep(15000);
			ZUORA_BILL_RUN_PROCESS(ConstantUtility.zuora_subscription_outputsheet, email);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void START_ZUORA_TEST(String username, String password, String inputsheet, String outputsheet,
			String scenario) throws InterruptedException, IOException {
		try {
			zuora_library = PageFactory.initElements(driver, Zuora_flow_library.class);
			zuora_library.START_ZUORA(username, password, inputsheet, outputsheet, scenario);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void PROCESS_ZUORA_SUBSCRIPTION(String Product_name, String Rate_plan, String email,
			String outputsheet) throws Exception {
		try {
			zuora_library = PageFactory.initElements(driver, Zuora_flow_library.class);
			zuora_library.START_PROCESS_ZUORA_SUBSCRIPTION(Product_name, Rate_plan, email, outputsheet);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void ZUORA_BILL_RUN_PROCESS(String outputsheet, String email) throws InterruptedException {

		try {
			zuora_library = PageFactory.initElements(driver, Zuora_flow_library.class);
			zuora_library.BILL_RUN_PROCESS(outputsheet, email);
		} catch (Exception e) {
		}

	}

	public static void ZUORA_BILL_RUN_VALIDATION_PROCESS(String email) throws InterruptedException {

		try {
			selectBrowser(ConstantUtility.browser);
			Load_Url(ConstantUtility.Zuora_url);
			zuora_library = PageFactory.initElements(driver, Zuora_flow_library.class);
			zuora_library.BILL_RUN_VALIDATION_PROCESS(ConstantUtility.zuora_username, ConstantUtility.zuora_password,
					email);
		} catch (Exception e) {
		}

	}

	public static void ZUORA_CANCELLATION_START_CONFIGURATION() throws InterruptedException {
		load_extentreport(ConstantUtility.commerce_report_location);
		selectBrowser(ConstantUtility.browser);
		Load_Url(ConstantUtility.Zuora_url);
		test = extent.startTest("Zuora Cancellation Flow");
	}

	public static void ZUORA_CANCELLATION_END_CONFIGURATION(String filename, String subject, String body)
			throws InterruptedException, IOException {
		extent.endTest(test);
		extent.flush();
		closebrowser();
		Email_Utils.commerce_subscription(filename, subject, body);
		Remove_results("", "", "", "", "", ConstantUtility.zuora_cancellation);
	}

	public static void DO_ZUORA_CANCELLATION_PROCESS(String Exe_status, String Email) {
		if (Exe_status.equalsIgnoreCase("Yes")) {
			ZUORA_CANCELLATION(Email, ConstantUtility.zuora_cancellation, ConstantUtility.zuora_username,
					ConstantUtility.zuora_password);
		} else {
			System.out.println("Unable to cancel for this email_______" + Email);
		}
	}

	public static void ZUORA_CANCELLATION(String email, String outputsheet, String username, String password) {
		try {
			zuora_library = PageFactory.initElements(driver, Zuora_flow_library.class);
			zuora_library.start_zuora_cancellation(email, username, password, outputsheet);

		} catch (Exception e) {
		}
	}

	public static void START_ASHOTS_COMPARISON(String url, String product, String email, String dir) {

		try {
			ashots_signup_library = PageFactory.initElements(driver, Ashot_comparison_Library.class);
			ashots_signup_library.ASHOTS_SIGNUP_FLOW_QA_Vs_PRODUCTION(url, product, email, dir);
		} catch (Exception e) {

		}

	}

	public static void START_LOGIN_TEST(String product, String user, String pwd) {
		try {
			login_library = PageFactory.initElements(driver, Login_flow_library.class);
			login_library.START_LOGIN(product, user, pwd);

		} catch (Exception e) {

		}
	}

	public static void ZUORA_FLOW_CSR_FLOW(String username, String password, String email) throws Exception {
		csr_library = PageFactory.initElements(driver, CSR_flow_library.class);
		csr_library.ZUORA_FLOW_CSR_INTEGRATION(username, password, email);
	}

	public static void START_CSR_TEST(String username, String password, String product, String csr_sheet, String email,
			String pwd) throws InterruptedException, IOException {
		try {
			csr_library = PageFactory.initElements(driver, CSR_flow_library.class);
			csr_library.START_CSR(username, password, product, csr_sheet, email, pwd);

		} catch (Exception e) {

		}
	}

	public static void START_SELFSERVICE_TEST(String email, String pwd, String product, String self_sheet)
			throws InterruptedException {

		try {
			self_library = PageFactory.initElements(driver, Selfservice_flow_library.class);
			self_library.START_SELFSERVICE(email, pwd, product, self_sheet);

		} catch (Exception e) {

		}

	}

	public static void START_ZUORA_SUBSCRIPTION(String url, String upsell, String crossell, String image_status,
			String oid, String email, String Fname, String Lname, String pwd, String confirmpwd,
			String subscriptionType, String ccNumber, String product, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String sheetname, String type) throws InterruptedException, IOException

	{
		signupflow_library = PageFactory.initElements(driver, Signupflow_library.class);
		commerce_methods = PageFactory.initElements(driver, Commerce_all_methods.class);

		// need to move when i create new scenario for random user
		String source = driver.getTitle();
		// String auto_email = email + "@yopmail.com";

		switch (product) {
		case "Validation": {
			// if (source.equalsIgnoreCase("Action Alerts PLUS")) {

			signupflow_library.SUBSCRIBE_STAGE_VALIDATION(driver, url, upsell, crossell, image_status, oid, email,
					Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);

			// } else {
			// }
			break;
		}

		case "Events": {
			// if (source.equalsIgnoreCase("Action Alerts PLUS")) {

			signupflow_library.SUBSCRIBE_STAGE_EVENTS(driver, url, upsell, crossell, image_status, oid, email, Fname,
					Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear, nameOnCard,
					address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);

			// } else {
			// }
			break;
		}
		case "Action Alerts PLUS": {
			// if (source.equalsIgnoreCase("Action Alerts PLUS")) {

			signupflow_library.SUBSCRIBE_STAGE_AAP(driver, url, upsell, crossell, image_status, oid, email, Fname,
					Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear, nameOnCard,
					address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);

			// } else {
			// }
			break;
		}
		case "RealMoney": {
			// if (source.equalsIgnoreCase("TheStreet Real Money")) {

			signupflow_library.SUBSCRIBE_STAGE_RMY(driver, url, upsell, crossell, image_status, oid, email, Fname,
					Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear, nameOnCard,
					address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "Income Seeker": {
			// if (source.equalsIgnoreCase("Income Seeker | Final Step - Provide Billing
			// Information")) {
			signupflow_library.SUBSCRIBE_STAGE_INCOME_SEEKER(driver, url, upsell, crossell, image_status, oid, email,
					Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "RealMoney Pro": {
			// if (source.equalsIgnoreCase("TheStreet Real Money Pro")) {
			signupflow_library.SUBSCRIBE_STAGE_RMY_PRO(driver, url, upsell, crossell, image_status, oid, email, Fname,
					Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear, nameOnCard,
					address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "TheStreet Quant Ratings": {
			// if (source.equalsIgnoreCase("TheStreet Quant Ratings")) {
			signupflow_library.SUBSCRIBE_STAGE_QUANT_RATINGS(driver, url, upsell, crossell, image_status, oid, email,
					Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "TheStreet.com Stocks Under $10": {
			// if (source.equalsIgnoreCase("TheStreet Stocks Under $10")) {
			signupflow_library.SUBSCRIBE_STAGE_STOCKS_UNDER(driver, url, upsell, crossell, image_status, oid, email,
					Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "TheStreet Trifecta Stocks": {
			// if (source.equalsIgnoreCase("TheStreet Trifecta Stocks")) {
			signupflow_library.SUBSCRIBE_STAGE_TRIFECTA(driver, url, upsell, crossell, image_status, oid, email, Fname,
					Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear, nameOnCard,
					address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "RealMoney Pro Portfolio": {
			// if (source.equalsIgnoreCase("TheStreet Real Money Pro Portfolio")) {
			signupflow_library.SUBSCRIBE_STAGE_RMY_PRO_PORTFOLIO(driver, url, upsell, crossell, image_status, oid,
					email, Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "TheStreet.com Top Stocks": {
			// if (source.equalsIgnoreCase("TheStreet Top Stocks")) {
			signupflow_library.SUBSCRIBE_STAGE_TOP_STOCKS(driver, url, upsell, crossell, image_status, oid, email,
					Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "TheStreet.com Chairman's Club": {
			// if (source.equalsIgnoreCase("TheStreet Chairman's Club")) {
			signupflow_library.SUBSCRIBE_STAGE_CHAIRMAN_CLUB(driver, url, upsell, crossell, image_status, oid, email,
					Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}

		case "Chatter on the Street": {
			// if (source.equalsIgnoreCase("Chatter on the Street | Final Step - Provide
			// Billing Information")) {
			signupflow_library.SUBSCRIBE_STAGE_CHATTER(driver, url, upsell, crossell, image_status, oid, email, Fname,
					Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear, nameOnCard,
					address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}
		case "Retirement Daily": {
			// if (source.equalsIgnoreCase("Retirement Daily")) {
			signupflow_library.SUBSCRIBE_STAGE_RETIREMENT(driver, url, upsell, crossell, image_status, oid, email,
					Fname, Lname, pwd, confirmpwd, subscriptionType, ccNumber, product, cvvCode, exMonth, exYear,
					nameOnCard, address1, address2, city, state, country, postalCode, phoneNum, sheetname, type);
			// } else {
			// }
			break;
		}
		default: {
			System.out.println("Not matched any product from subscription input sheet");
		}
		}
	}

	public static void update_random_emails(String email, String product, String sheet_to_write) throws IOException {
		String array[] = { email, product };
		ExcelReader.writeExcel(System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\Outputs\\", "result.xlsx",
				sheet_to_write, array);
	}

	public static Object[][] getData(String excelname, String sheetname) throws IOException {

		ExcelReader xlsreader = new ExcelReader(
				System.getProperty("user.dir") + "//src//test//java//TestData//Inputs//" + excelname);
		int RowSize = xlsreader.getRowCount(sheetname);
		int ColSize = xlsreader.getColumnCount(sheetname);
		Object[][] exceldata = new Object[RowSize - 1][ColSize];

		for (int i = 2; i <= RowSize; i++) {

			for (int j = 0; j < ColSize; j++) {
				exceldata[i - 2][j] = xlsreader.getCellData(sheetname, j, i);
			}
		}
		return exceldata;

	}

	public static String Currentdate_hyphen() {
		DateFormat df = new SimpleDateFormat("_dd_MM_yyyy");
		Date date = new Date();
		String systemdate = df.format(date);
		return systemdate;

	}

	public static String Currentdate1() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String systemdate = df.format(date);
		return systemdate;

	}

	/*
	 * This method will print the current sheet product information while execution
	 */
	public static void print_subscription(String execution, String Susbcription_status, String csr_status,
			String selfservice_status, String Login_status, String zuora_status, String Upsell, String crossell,
			String product, String premium_product_url, String email, String Fname, String Lname, String pwd,
			String confirmpwd, String subscriptionType, String ccNumber, String cvvCode, String exMonth, String exYear,
			String nameOnCard, String address1, String address2, String city, String state, String country,
			String postalCode, String phoneNum, String stage_login_url) {
		System.out.println("\nURL : " + premium_product_url + "\nemail : " + email + "\nFname : " + Fname + "\nLname : "
				+ Lname + "\nCC Number : " + ccNumber + "\nsubscriptionType : " + subscriptionType + "\nCVV Code : "
				+ cvvCode + "\nEx.month : " + exMonth + "\nEx.year : " + exYear + "\nName on card : " + nameOnCard
				+ "\nAddress1 : " + address1 + "\nAddress2 : " + address2 + "\nCity : " + city + "\nState : " + state
				+ "\nCountry : " + country + "\n Postal Code : " + postalCode + "\nPhone Number : " + phoneNum
				+ "\nUpsell : " + Upsell);
	}

	public void print_login_ids(String Urls, String Product, String Email, String Password) {
		System.out.println(
				"\nURL : " + Urls + "\nemail : " + Email + "\nPassword : " + Password + "\nProduct : " + Product);
	}

	/*
	 * Urls,Product,Email,Password Put a wait for 4 sec using this method
	 */
	public void wait_sec() throws InterruptedException {
		Thread.sleep(5000);
	}

	/*
	 * This method will convert the particular texts from pagesource into strings
	 */
	public static String StringFinder(String searchString, String webpagesource, int numberofchar) {
		int index = webpagesource.lastIndexOf(searchString);
		int len = searchString.length();
		return webpagesource.substring(index + len, index + numberofchar + len);
	}

	/*
	 * This method will get the thankyou page information and update the
	 * informations into excel sheet for to cross check the csr results
	 */
	public static void closebrowser() {

		driver.close();

	}

	public static void Clear_Cookies() {
		driver.manage().deleteAllCookies();
	}

}
