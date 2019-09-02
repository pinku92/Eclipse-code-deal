package PageMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import PageObjects.Ashots_Comparison_flow_objects;
import TestBase.TestBase;

public class Ashot_comparison_methods extends TestBase {

	public static void action_alerts_plus_ashots(String email, String product, String dir,
			List<WebElement> click_element_1, List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws Exception {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void income_seeker_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws InterruptedException, IOException {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void trifecta_stocks_ashots(String email, String product, String dir,
			List<WebElement> click_element_1, List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws InterruptedException, IOException {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void quant_ratings_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws InterruptedException, IOException {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void real_money_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2, List<WebElement> clickelement3)
			throws InterruptedException, IOException {
		clickelement3.get(0).click();
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void stocks_under_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws InterruptedException, IOException {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void top_stocks_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws InterruptedException, IOException {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void chairmans_club_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2, List<WebElement> clickelement3)
			throws InterruptedException, IOException {
		clickelement3.get(0).click();
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void rmp_portfolio_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws InterruptedException, IOException {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void chatter_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws InterruptedException, IOException {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void retirement_ashots(String email, String product, String dir, List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2)
			throws InterruptedException, IOException {
		ashots_qa_vs_live_navigation_flow(click_element_1, sendkeys_field, click_element_2, email, product, dir);
	}

	public static void handle_popup(List<WebElement> popup, List<WebElement> close) throws InterruptedException {

		Thread.sleep(5000);
		if (popup.size() > 0) {
			System.out.println("Yes PopUp is present");
			if (close.size() > 0) {
				Thread.sleep(7000);
				System.out.println("Yes Close is present");
				close.get(0).click();
				System.out.println("Close is Clicked");

			}else {
				System.out.println("No POP up to handle");
			}
		}else {
			System.out.println("No POP up to handle");
		}

	}

	public static void ashots_qa_vs_live_navigation_flow(List<WebElement> click_element_1,
			List<WebElement> sendkeys_field, List<WebElement> click_element_2, String sendkeys_data, String product,
			String dir) throws InterruptedException, IOException {

		ashots_flow_objects = PageFactory.initElements(driver, Ashots_Comparison_flow_objects.class);

		
		ashot_screenshot(product, "MLP", dir);
		
		Thread.sleep(2000);
		Commerce_all_methods.click_button(click_element_1);
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		ashot_screenshot(product, "EC", dir);
		Thread.sleep(2000);
		
		Commerce_all_methods.sendkeys(sendkeys_field, sendkeys_data);
		Thread.sleep(2000);
		

		Commerce_all_methods.click_button(click_element_2);
		Thread.sleep(5000);
		
		ashot_screenshot(product, "CC", dir);
	}
}
