package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CSR_flow_objects {

	private WebDriver driver;

	public CSR_flow_objects(WebDriver driver) {
		this.driver = driver;
	}

	// login page

	@FindBy(how = How.XPATH, using = "//input[@name='login']")
	public List<WebElement> csr_login_username;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	public List<WebElement> csr_login_password;

	@FindBy(how = How.XPATH, using = "//input[@name='Submit']")
	public List<WebElement> csr_login_submit;

	// Search page
	
	@FindBy(how = How.XPATH, using = ".//*[@id='searchType'][2]")
	public List<WebElement> csr_search_specific_type;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='userId']")
	public List<WebElement> csr_search_specific_type_userid;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitSearchInfo']")
	public List<WebElement> csr_search_specific_type_submit;
	

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public List<WebElement> csr_search_mail;

	@FindBy(how = How.XPATH, using = "//input[@alt='Submit']")
	public List<WebElement> csr_search_submit;

	@FindBy(how = How.XPATH, using = "html/body/center/ul")
	public List<WebElement> csr_search_message;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Add Customer')]")
	public List<WebElement> csr_add_customer;

	// CSR Subscription details table

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Product:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_product_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Promotion:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_promotion_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Offer:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_offer_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Status:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_status_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Start:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_start_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'End:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_end_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Marketing Code:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_marketing_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Free Trial:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_freetrial_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Price:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_price_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Payment Method:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_paymentmethod_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Auto-Renew:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_autorenew_details;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Tax Amount[Remaining/Applied]:')]/parent::td/following-sibling::td[1]")
	public WebElement csr_tax_details;

	@FindBy(how = How.XPATH, using = "//input[@name='Activate Account']")
	public List<WebElement> csr_activateaccount_btn;

	// CSR Subscription product orderID details tester25042018@yopmail.com

	@FindBy(how = How.XPATH, using = "//a[(.='Action Alerts PLUS')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_aap;

	@FindBy(how = How.XPATH, using = "//a[(.='RealMoney')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_rmy;

	@FindBy(how = How.XPATH, using = "//a[(.='RealMoney Pro')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_rmypro;

	@FindBy(how = How.XPATH, using = "//a[(.='TheStreet.com Top Stocks')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_topstocks;

	@FindBy(how = How.XPATH, using = "//a[(.='TheStreet Trifecta Stocks')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_trifecta;

	@FindBy(how = How.XPATH, using = "//a[(.='TheStreet.com Stocks Under $10')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_stocksunder;

	@FindBy(how = How.XPATH, using = "//a[(.='TheStreet Quant Ratings')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_quantratings;

	@FindBy(how = How.XPATH, using = "//a[(.='Income Seeker')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_incomeseeker;

	@FindBy(how = How.XPATH, using = "//a[(.='RealMoney Pro Portfolio')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_rmypro_portfolio;

	@FindBy(how = How.XPATH, using = "//a[(.='Chatter on the Street')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_chatter;

	@FindBy(how = How.XPATH, using = "//a[(.='Retirement Daily')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_retirement;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Chairman')]/parent::td/following-sibling::td[1]/a")
	public List<WebElement> csr_product_table_chairman;

	// CSR Subscription product Activation status details

	@FindBy(how = How.XPATH, using = "//a[(.='Action Alerts PLUS')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_aap;

	@FindBy(how = How.XPATH, using = "//a[(.='RealMoney')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_rmy;

	@FindBy(how = How.XPATH, using = "//a[(.='RealMoney Pro')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_rmypro;

	@FindBy(how = How.XPATH, using = "//a[(.='TheStreet.com Top Stocks')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_topstocks;

	@FindBy(how = How.XPATH, using = "//a[(.='TheStreet Trifecta Stocks')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_trifecta;

	@FindBy(how = How.XPATH, using = "//a[(.='TheStreet.com Stocks Under $10')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_stocksunder;

	@FindBy(how = How.XPATH, using = "//a[(.='TheStreet Quant Ratings')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_quantratings;

	@FindBy(how = How.XPATH, using = "//a[(.='Income Seeker')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_incomeseeker;

	@FindBy(how = How.XPATH, using = "//a[(.='RealMoney Pro Portfolio')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_rmypro_portfolio;

	@FindBy(how = How.XPATH, using = "//a[(.='Chatter on the Street')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_chatter;

	@FindBy(how = How.XPATH, using = "//a[(.='Retirement Daily')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_retirement;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Chairman')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_chairman;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'TheStreet Event')]/parent::td/following-sibling::td[3]")
	public List<WebElement> csr_product_status_thestreet_event;
	

	// ADD CUSTOMER PAGE

	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	public List<WebElement> csr_customer_fname;

	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	public List<WebElement> csr_customer_Lname;

	@FindBy(how = How.XPATH, using = "//input[@name='companyName']")
	public List<WebElement> csr_customer_company_name;

	@FindBy(how = How.XPATH, using = "//input[@name='telephone1']")
	public List<WebElement> csr_customer_phone;

	@FindBy(how = How.XPATH, using = "//input[@name='emailAddress1']")
	public List<WebElement> csr_customer_email;

	@FindBy(how = How.XPATH, using = ".//*[@id='userRequestInfo']/table[1]/tbody/tr[7]/td[2]/input[4]")
	public List<WebElement> csr_customer_email_formt_html;

	@FindBy(how = How.XPATH, using = "//input[@name='login']")
	public List<WebElement> csr_customer_user_name;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	public List<WebElement> csr_customer_password;

	@FindBy(how = How.XPATH, using = ".//*[@id='userRequestInfo']/table[1]/tbody/tr[5]/td[4]/input[3]")
	public List<WebElement> csr_customer_confirm_password;

	@FindBy(how = How.XPATH, using = "//input[@name='address1']")
	public List<WebElement> csr_customer_address1;

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	public List<WebElement> csr_customer_city;

	@FindBy(how = How.XPATH, using = "//input[@name='postalCode']")
	public List<WebElement> csr_customer_zipcode;

	@FindBy(how = How.XPATH, using = ".//*[@id='paymentType'][1]")
	public List<WebElement> csr_customer_payment_type_none;

	@FindBy(how = How.XPATH, using = "//select[@name='state']//option")
	public List<WebElement> csr_customer_state;

	@FindBy(how = How.XPATH, using = ".//*[@id='userRequestInfo']/table[1]/tbody/tr[8]/td/table/tbody/tr/td[2]/select//option")
	public List<WebElement> csr_customer_investor_type;

	@FindBy(how = How.XPATH, using = "//select[@name='investingStyle']//option")
	public List<WebElement> csr_customer_investing_style;

	@FindBy(how = How.XPATH, using = "//select[@name='userType']//option")
	public List<WebElement> csr_customer_user_type;

	@FindBy(how = How.XPATH, using = "//select[@name='communityProfileTypeId']//option")
	public List<WebElement> csr_customer_company_profiletype;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitAddCustomer']")
	public List<WebElement> csr_customer_submit;
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'View Account History')]")
	public List<WebElement> csr_customer_account_history;
	
	@FindBy(how = How.XPATH, using = "//table[3]//tr//td[8][contains(.,'New user enrollment')]/../td[6]/a")
	public List<WebElement> csr_customer_account_id;
	
	
	
	
	
	
	
 }
