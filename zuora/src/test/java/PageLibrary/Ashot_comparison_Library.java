package PageLibrary;

import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import PageMethods.Ashot_comparison_methods;
import PageObjects.Ashots_Comparison_flow_objects;
import PageObjects.Signup_flow_objects;
import TestBase.TestBase;

public class Ashot_comparison_Library extends TestBase {
	public Ashot_comparison_Library() {
		ashots_flow_objects = PageFactory.initElements(driver, Ashots_Comparison_flow_objects.class);
	}

	public void ASHOTS_SIGNUP_FLOW_QA_Vs_PRODUCTION(String url, String product, String email, String dir)
			throws Exception

	{
		try {
			if (product.equalsIgnoreCase("Action Alerts PLUS")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.action_alerts_plus_ashots(email, product, dir, ashots_flow_objects.aap_mlp_btn,
						ashots_flow_objects.aap_email_field, ashots_flow_objects.aap_email_continuebtn);
			} else if (product.equalsIgnoreCase("Income Seeker")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.income_seeker_ashots(email, product, dir, ashots_flow_objects.income_mlp_btn,
						ashots_flow_objects.income_email_field, ashots_flow_objects.income_email_continuebtn);
			} else if (product.equalsIgnoreCase("TheStreet Trifecta Stocks")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.trifecta_stocks_ashots(email, product, dir,
						ashots_flow_objects.trifecta_mlp_btn, ashots_flow_objects.trifecta_email_field,
						ashots_flow_objects.trifecta_email_continuebtn);
			} else if (product.equalsIgnoreCase("TheStreet Quant Ratings")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.quant_ratings_ashots(email, product, dir,
						ashots_flow_objects.quantratings_mlp_btn, ashots_flow_objects.quantrtaings_email_field,
						ashots_flow_objects.quantratings_email_continuebtn);
			} else if (product.equalsIgnoreCase("RealMoney")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.real_money_ashots(email, product, dir, ashots_flow_objects.rmy_mlp_btn_second,
						ashots_flow_objects.rmy_email_field, ashots_flow_objects.rmy_email_continuebtn,
						ashots_flow_objects.rmy_mlp_btn_first);

			} else if (product.equalsIgnoreCase("TheStreet.com Stocks Under $10")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.stocks_under_ashots(email, product, dir,
						ashots_flow_objects.stocksunder_mlp_btn, ashots_flow_objects.stocksunder_email_field,
						ashots_flow_objects.stocksunder_email_continuebtn);
			} else if (product.equalsIgnoreCase("TheStreet.com Top Stocks")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.top_stocks_ashots(email, product, dir, ashots_flow_objects.topstocks_mlp_btn,
						ashots_flow_objects.topstocks_email_field, ashots_flow_objects.topstocks_email_continuebtn);

			} else if (product.equalsIgnoreCase("TheStreet.com Chairman Club")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.real_money_ashots(email, product, dir,
						ashots_flow_objects.chairman_mlp_btn_second, ashots_flow_objects.chairman_email_field,
						ashots_flow_objects.chairman_email_continuebtn, ashots_flow_objects.chairman_mlp_btn_first);
			} else if (product.equalsIgnoreCase("RealMoney Pro Portfolio")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.rmp_portfolio_ashots(email, product, dir, ashots_flow_objects.rmpp_mlp_btn,
						ashots_flow_objects.rmpp_email_field, ashots_flow_objects.rmpp_email_continuebtn);
			} else if (product.equalsIgnoreCase("Chatter on the Street")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.chatter_ashots(email, product, dir, ashots_flow_objects.chatter_mlp_btn,
						ashots_flow_objects.chatter_email_field, ashots_flow_objects.chatter_email_continuebtn);
			} else if (product.equalsIgnoreCase("Retirement Daily")) {
				ashots_configuration(product, dir);
				Ashot_comparison_methods.retirement_ashots(email, product, dir, ashots_flow_objects.retirement_mlp_btn,
						ashots_flow_objects.retirement_email_field, ashots_flow_objects.retirement_email_continuebtn);
			}

		}

		catch (Exception e) {
			test.log(LogStatus.FAIL, product + "is Failed to Compare the QA and Live");

		}
	}
}
