package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Selfservice_flow_objects {

	private WebDriver driver;

	public Selfservice_flow_objects(WebDriver driver) {
		this.driver = driver;
	}

	// login page with login drop down elements

	@FindBy(how = How.XPATH, using = ".//*[@id='login']/div")
	public List<WebElement> tstng_login_link;

	@FindBy(how = How.XPATH, using = ".//*[@id='login']")
	public List<WebElement> tstng_login_username;

	@FindBy(how = How.XPATH, using = ".//*[@id='loginpw']")
	public List<WebElement> tstng_login_password;

	@FindBy(how = How.XPATH, using = ".//*[@id='loginSubmit']")
	public List<WebElement> tstng_login_submit;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/div")
	public WebElement account;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='accountDropdown']/div/a[2]")
	public WebElement account_dropdown;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='main_nav_account_2_sub_1']")
	public WebElement account_pref;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='csMainMenu']/p[8]/a")
	public WebElement account_premium;
	
	

	// Self service Page premium product wise details

	// REAL MONEY

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement rmy_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney']/../../li[contains(.,'Category:')]/span")
	public WebElement rmy_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney']/../../li[contains(.,'Status:')]/span")
	public WebElement rmy_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney']/../../li[contains(.,'Price:')]/span")
	public WebElement rmy_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney']/../../li[contains(.,'Start Date:')]/span")
	public WebElement rmy_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney']/../../li[contains(.,'End Date:')]/span")
	public WebElement rmy_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement rmy_selfservice_product_renewal;

	// TOP STOCKS

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Top Stocks']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement top_stocks_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Top Stocks']/../../li[contains(.,'Category:')]/span")
	public WebElement top_stocks_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Top Stocks']/../../li[contains(.,'Status:')]/span")
	public WebElement top_stocks_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Top Stocks']/../../li[contains(.,'Price:')]/span")
	public WebElement top_stocks_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Top Stocks']/../../li[contains(.,'Start Date:')]/span")
	public WebElement top_stocks_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Top Stocks']/../../li[contains(.,'End Date:')]/span")
	public WebElement top_stocks_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Top Stocks']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement top_stocks_selfservice_product_renewal;

	// ACTION ALERTS PLUS

	@FindBy(how = How.XPATH, using = ".//li//span[.='Action Alerts PLUS']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement aap_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Action Alerts PLUS']/../../li[contains(.,'Category:')]/span")
	public WebElement aap_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Action Alerts PLUS']/../../li[contains(.,'Status:')]/span")
	public WebElement aap_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Action Alerts PLUS']/../../li[contains(.,'Price:')]/span")
	public WebElement aap_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Action Alerts PLUS']/../../li[contains(.,'Start Date:')]/span")
	public WebElement aap_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Action Alerts PLUS']/../../li[contains(.,'End Date:')]/span")
	public WebElement aap_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Action Alerts PLUS']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement aap_selfservice_product_renewal;

	// STOCKS UNDER $10

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Stocks Under $10']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement stocksunder_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Stocks Under $10']/../../li[contains(.,'Category:')]/span")
	public WebElement stocksunder_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Stocks Under $10']/../../li[contains(.,'Status:')]/span")
	public WebElement stocksunder_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Stocks Under $10']/../../li[contains(.,'Price:')]/span")
	public WebElement stocksunder_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Stocks Under $10']/../../li[contains(.,'Start Date:')]/span")
	public WebElement stocksunder_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Stocks Under $10']/../../li[contains(.,'End Date:')]/span")
	public WebElement stocksunder_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet.com Stocks Under $10']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement stocksunder_selfservice_product_renewal;

	// REAL MONEY PRO

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement rmypro_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro']/../../li[contains(.,'Category:')]/span")
	public WebElement rmypro_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro']/../../li[contains(.,'Status:')]/span")
	public WebElement rmypro_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro']/../../li[contains(.,'Price:')]/span")
	public WebElement rmypro_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro']/../../li[contains(.,'Start Date:')]/span")
	public WebElement rmypro_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro']/../../li[contains(.,'End Date:')]/span")
	public WebElement rmypro_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement rmypro_selfservice_product_renewal;

	// REAL MONEY PRO PORTFOLIO

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro Portfolio']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement rmypro_portfolio_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro Portfolio']/../../li[contains(.,'Category:')]/span")
	public WebElement rmypro_portfolio_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro Portfolio']/../../li[contains(.,'Status:')]/span")
	public WebElement rmypro_portfolio_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro Portfolio']/../../li[contains(.,'Price:')]/span")
	public WebElement rmypro_portfolio_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro Portfolio']/../../li[contains(.,'Start Date:')]/span")
	public WebElement rmypro_portfolio_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro Portfolio']/../../li[contains(.,'End Date:')]/span")
	public WebElement rmypro_portfolio_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='RealMoney Pro Portfolio']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement rmypro_portfolio_selfservice_product_renewal;

	// INCOME SEEKER

	@FindBy(how = How.XPATH, using = ".//li//span[.='Income Seeker']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement income_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Income Seeker']/../../li[contains(.,'Category:')]/span")
	public WebElement income_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Income Seeker']/../../li[contains(.,'Status:')]/span")
	public WebElement income_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Income Seeker']/../../li[contains(.,'Price:')]/span")
	public WebElement income_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Income Seeker']/../../li[contains(.,'Start Date:')]/span")
	public WebElement income_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Income Seeker']/../../li[contains(.,'End Date:')]/span")
	public WebElement income_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Income Seeker']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement income_selfservice_product_renewal;

	// THE STREET QUANT RATINGS

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Quant Ratings']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement quant_ratings_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Quant Ratings']/../../li[contains(.,'Category:')]/span")
	public WebElement quant_ratings_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Quant Ratings']/../../li[contains(.,'Status:')]/span")
	public WebElement quant_ratings_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Quant Ratings']/../../li[contains(.,'Price:')]/span")
	public WebElement quant_ratings_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Quant Ratings']/../../li[contains(.,'Start Date:')]/span")
	public WebElement quant_ratings_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Quant Ratings']/../../li[contains(.,'End Date:')]/span")
	public WebElement quant_ratings_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Quant Ratings']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement quant_ratings_selfservice_product_renewal;

	// THE STREET TRIFECTA STOCKS

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Trifecta Stocks']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement trifecta_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Trifecta Stocks']/../../li[contains(.,'Category:')]/span")
	public WebElement trifecta_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Trifecta Stocks']/../../li[contains(.,'Status:')]/span")
	public WebElement trifecta_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Trifecta Stocks']/../../li[contains(.,'Price:')]/span")
	public WebElement trifecta_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Trifecta Stocks']/../../li[contains(.,'Start Date:')]/span")
	public WebElement trifecta_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Trifecta Stocks']/../../li[contains(.,'End Date:')]/span")
	public WebElement trifecta_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='TheStreet Trifecta Stocks']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement trifecta_selfservice_product_renewal;

	// CHATTER ON THE STREET

	@FindBy(how = How.XPATH, using = ".//li//span[.='Chatter on the Street']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement chatter_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Chatter on the Street']/../../li[contains(.,'Category:')]/span")
	public WebElement chatter_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Chatter on the Street']/../../li[contains(.,'Status:')]/span")
	public WebElement chatter_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Chatter on the Street']/../../li[contains(.,'Price:')]/span")
	public WebElement chatter_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Chatter on the Street']/../../li[contains(.,'Start Date:')]/span")
	public WebElement chatter_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Chatter on the Street']/../../li[contains(.,'End Date:')]/span")
	public WebElement chatter_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Chatter on the Street']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement chatter_selfservice_product_renewal;

	// RETIREMENT DAILY

	@FindBy(how = How.XPATH, using = ".//li//span[.='Retirement Daily']/../../li[contains(.,'Premium Service:')]/span")
	public WebElement retirement_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Retirement Daily']/../../li[contains(.,'Category:')]/span")
	public WebElement retirement_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Retirement Daily']/../../li[contains(.,'Status:')]/span")
	public WebElement retirement_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Retirement Daily']/../../li[contains(.,'Price:')]/span")
	public WebElement retirement_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Retirement Daily']/../../li[contains(.,'Start Date:')]/span")
	public WebElement retirement_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Retirement Daily']/../../li[contains(.,'End Date:')]/span")
	public WebElement retirement_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[.='Retirement Daily']/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement retirement_selfservice_product_renewal;
	
	
	//CHAIRMAN'S CLUB
	
	@FindBy(how = How.XPATH, using = ".//li//span[contains(text(),'Chairman')]/../../li[contains(.,'Premium Service:')]/span")
	public WebElement chairman_selfservice_product_premiumservice;

	@FindBy(how = How.XPATH, using = ".//li//span[contains(text(),'Chairman')]/../../li[contains(.,'Category:')]/span")
	public WebElement chairman_selfservice_product_category;

	@FindBy(how = How.XPATH, using = ".//li//span[contains(text(),'Chairman')]/../../li[contains(.,'Status:')]/span")
	public WebElement chairman_selfservice_product_status;

	@FindBy(how = How.XPATH, using = ".//li//span[contains(text(),'Chairman')]/../../li[contains(.,'Price:')]/span")
	public WebElement chairman_selfservice_product_price;

	@FindBy(how = How.XPATH, using = ".//li//span[contains(text(),'Chairman')]/../../li[contains(.,'Start Date:')]/span")
	public WebElement chairman_selfservice_product_startdate;

	@FindBy(how = How.XPATH, using = ".//li//span[contains(text(),'Chairman')]/../../li[contains(.,'End Date:')]/span")
	public WebElement chairman_selfservice_product_enddate;

	@FindBy(how = How.XPATH, using = ".//li//span[contains(text(),'Chairman')]/../../li[contains(.,'Renewal Information:')]/span")
	public WebElement chairman_selfservice_product_renewal;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}




