package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Signup_flow_objects {

	private WebDriver driver;

	public Signup_flow_objects(WebDriver driver) {

		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH, using = "")
	public List<WebElement> NULL_Element;
	
	
	// FOR ACTION ALERTS PLUS
	
	
	

	@FindBy(how = How.XPATH, using = ".//*[@id='areaOne']/div/a/img")
	public List<WebElement> aap_stage_mlp_btn;

	@FindBy(how = How.XPATH, using = ".//*[@id='emailAddress']")
	public List<WebElement> aap_stage_ec_emailfield;

	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> aap_stage_ec_emailfield_continuebtn;

	@FindBy(how = How.XPATH, using = ".//*[@id='firstName']")
	public List<WebElement> aap_stage_cc_fname;

	@FindBy(how = How.XPATH, using = ".//*[@id='lastName']")
	public List<WebElement> aap_stage_cc_lname;

	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	public List<WebElement> aap_stage_cc_password;

	@FindBy(how = How.XPATH, using = ".//*[@id='passwordConfirm']")
	public List<WebElement> aap_stage_cc_confirmpassword;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardHolderName']")
	public List<WebElement> aap_stage_cc_creditcard_holder_name;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardNumber']")
	public List<WebElement> aap_stage_cc_creditcard_number;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardExpirationMonth']//option")
	public List<WebElement> aap_stage_cc_creditcard_month;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardExpirationYear']//option")
	public List<WebElement> aap_stage_cc_creditcard_year;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-cardSecurityCode']")
	public List<WebElement> aap_stage_cc_creditcard_cvv;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardAddress1']")
	public List<WebElement> aap_stage_cc_address1;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardAddress2']")
	public List<WebElement> aap_stage_cc_address2;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardCity']")
	public List<WebElement> aap_stage_cc_city;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardState']//option")
	public List<WebElement> aap_stage_cc_state;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardPostalCode']")
	public List<WebElement> aap_stage_cc_postalcode;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-creditCardCountry']//option")
	public List<WebElement> aap_stage_cc_country;

	@FindBy(how = How.XPATH, using = ".//*[@id='input-phone']")
	public List<WebElement> aap_stage_cc_contactnum;

	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> aap_stage_cc_continue;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'MONTHLY')]//div/label")
	public List<WebElement> aap_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> aap_stage_cc_subscriptionplan_Annual;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'TWO YEAR')]//div/label")
	public List<WebElement> aap_stage_cc_subscriptionplan_Two_year;
	
	
	

	// AAP THank You Page

	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Account ID:')]/following::dd[1]")
	public List<WebElement> aap_stage_ty_accountid_data;

	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Subscription ID:')]/following::dd[1]")
	public List<WebElement> aap_stage_ty_subscriptionid_data;

	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Term:')]/following::dd[1]")
	public List<WebElement> aap_stage_ty_term_data;

	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Free Trial Days:')]/following::dd[1]")
	public List<WebElement> aap_stage_ty_freetrialdays_data;

	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Subscribed on:')]/following::dd[1]")
	public List<WebElement> aap_stage_ty_subscribedon_data;

	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Email Address:')]/following::dt[1]")
	public List<WebElement> aap_stage_ty_email_data;

	@FindBy(how = How.XPATH, using = "//*[@id='accountInformationHighlight']/span")
	public List<WebElement> ret_stage_ty_email_data;
	
	@FindBy(how = How.XPATH, using = "//*[@id='accountInformationHighlight']")
	public List<WebElement> dummy_stage_ty_email_data;
	
	@FindBy(how = How.XPATH, using = "//a[@class=' btn-submit']")
	public List<WebElement> access_new_product_data;
	
	
	
	

	// REAL MONEY PRO

	@FindBy(how = How.XPATH, using = ".//*[@id='leftList']/a/img")
	public List<WebElement> rmypro_stage_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'MONTHLY')]//div/label")
	public List<WebElement> rmypro_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> rmypro_stage_cc_subscriptionplan_Annual;
	
	

	// REAL MONEY PRO PORTFOLIO

	@FindBy(how = How.XPATH, using = ".//*[@id='sectionOne']/div/a/img")
	public List<WebElement> rmypro_portfolio_stage_mlp_btn;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'MONTHLY')]//div/label")
	public List<WebElement> rmyportfolio_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> rmyportfolio_stage_cc_subscriptionplan_Annual;
	
	

	// REAL MONEY

	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'TWO YEAR')]//div/label")
	public List<WebElement> rmy_stage_cc_subscriptionplan_Two_year;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> rmy_stage_cc_subscriptionplan_Annual;

	// CHAIRMANS CLUB

	@FindBy(how = How.XPATH, using = ".//*[@id='sectionOne']/div/a/img")
	public List<WebElement> chairman_stage_mlp_btn;

	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> chairman_stage_cc_subscriptionplan_Annual;
	
	// INCOME SEEKER

	@FindBy(how = How.XPATH, using = ".//*[@id='areaOne']/p[2]/a/img")
	public List<WebElement> income_stage_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> income_stage_cc_subscriptionplan_Annual;

	// TRIFECTA STOCKS

	@FindBy(how = How.XPATH, using = ".//*[@id='topLeft']/div/a/img")
	public List<WebElement> trifecta_stage_mlp_btn;

	// CHATTER ON THE STREET

	@FindBy(how = How.XPATH, using = "//a/span[@class='singup']")
	public List<WebElement> chatter_stage_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'MONTHLY')]//div/label")
	public List<WebElement> chatter_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> chatter_stage_cc_subscriptionplan_Annual;
	
	
	//QUANT RATINGS
	
	@FindBy(how = How.XPATH, using = "//div[@class='priceTerm'][contains(.,'MONTHLY')]/../../div[@class='radio-container']/label")
	public List<WebElement> quantratings_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = "//div[@class='priceTerm'][contains(.,'ANNUAL')]/../../div[@class='radio-container']/label")
	public List<WebElement> quantratings_stage_cc_subscriptionplan_Annual;
	
	//TOP STOCKS
	
	@FindBy(how = How.XPATH, using = ".//*[@id='leftList']/a/img")
	public List<WebElement> top_stocks_stage_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'MONTHLY')]//div/label")
	public List<WebElement> topstocks_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> topstocks_stage_cc_subscriptionplan_Annual;
	
	//STOCKSUNDER $10
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'MONTHLY')]//div/label")
	public List<WebElement> stocksunder_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> stocksunder_stage_cc_subscriptionplan_Annual;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'TWO YEAR')]//div/label")
	public List<WebElement> stocksunder_stage_cc_subscriptionplan_twoyear;
	
	
	//TRIFECTA
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'MONTHLY')]//div/label")
	public List<WebElement> trifecta_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> trifecta_stage_cc_subscriptionplan_Annual;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'TWO YEAR')]//div/label")
	public List<WebElement> trifecta_stage_cc_subscriptionplan_twoyear;
	
	
	//RETIREMET
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'MONTHLY')]//div/label")
	public List<WebElement> retirement_stage_cc_subscriptionplan_Monthly;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'ANNUAL')]//div/label")
	public List<WebElement> retirement_stage_cc_subscriptionplan_Annual;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pricing_fields']//div[@class='container'][contains(.,'TWO YEAR')]//div/label")
	public List<WebElement> retirement_stage_cc_subscriptionplan_twoyear;
	
	
	//UPSELL
	
	@FindBy(how = How.XPATH, using = "//button[@id='happy_cta1']")
	public List<WebElement> aap_upsell_yes;
	
	@FindBy(how = How.XPATH, using = "//button[@id='sad_cta1']")
	public List<WebElement> aap_upsell_no;
	
	@FindBy(how = How.XPATH, using = "//button[@id='happy_cta1']")
	public List<WebElement> aap_crossell_yes;
	
	@FindBy(how = How.XPATH, using = "//button[@id='sad_cta1']")
	public List<WebElement> aap_crossell_no;
	
	
	//EVENTS TICKET SUBSCRIPTION THANKYOU PAGE
	
	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Email Address:')]/following::dd[1]")
	public List<WebElement> events_stage_ty_email_data;
	
	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Number of Tickets:')]/following::dd[1]")
	public List<WebElement> events_stage_ty_tickets_data;
	
	@FindBy(how = How.XPATH, using = "//dt[contains(.,'Amount:')]/following::dd[1]")
	public List<WebElement> events_stage_ty_amount_data;

}
