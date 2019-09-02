package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Ashots_Comparison_flow_objects {
	
	private WebDriver driver;

	public Ashots_Comparison_flow_objects(WebDriver driver) {

		this.driver = driver;
	}

	// ACTION ALERTS PLUS QA and LIVE/////////////////////////////

	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Become a Member')]")
	public List<WebElement> aap_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='areaOne']/div[2]/a")
	public List<WebElement> aap_mlp_btn1;
	
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='emailAddress']")
	public List<WebElement> aap_email_field;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> aap_email_continuebtn;
	
	//INCOME SEEKER QA and LIVE///////////////////////////////////
	
	@FindBy(how = How.XPATH, using = ".//*[@id='areaOne']/p[2]/a/img")
	public List<WebElement> income_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='emailAddress']")
	public List<WebElement> income_email_field;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> income_email_continuebtn;
	
	//TRIFECTA STOCKS QA and LIVE/////////////////////////////////
	
	@FindBy(how = How.XPATH, using = "//img[contains(@alt,'Start My Risk-free Trial Now')]")
	public List<WebElement> trifecta_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='emailAddress1']")
	public List<WebElement> trifecta_email_field;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> trifecta_email_continuebtn;
	
	//QUANT RATINGS QA And LIVE/////////////////////////////////
	
	@FindBy(how = How.XPATH, using = "//img[@alt='Get Started']")
	public List<WebElement> quantratings_mlp_btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='emailAddress']")
	public List<WebElement> quantrtaings_email_field;
	
	@FindBy(how = How.XPATH, using = "//button[@id='submitButton']")
	public List<WebElement> quantratings_email_continuebtn;
	
	//REAL MONEY QA And LIVE///////////////////////////////////
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'SUBSCRIBE')]")
	public List<WebElement> rmy_mlp_btn_first;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='areaOne']/div/a/img")
	public List<WebElement> rmy_mlp_btn_second;
	
	@FindBy(how = How.XPATH, using = "//input[@id='emailAddress']")
	public List<WebElement> rmy_email_field;
	
	@FindBy(how = How.XPATH, using = "//button[@id='submitButton']")
	public List<WebElement> rmy_email_continuebtn;
	
	//STOCKS UNDER QA And LIVE//////////////////////////////////
	
	@FindBy(how = How.XPATH, using = ".//*[@id='areaOne']/div/a/img")
	public List<WebElement> stocksunder_mlp_btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='emailAddress']")
	public List<WebElement> stocksunder_email_field;
	
	@FindBy(how = How.XPATH, using = "//button[@id='submitButton']")
	public List<WebElement> stocksunder_email_continuebtn;
	
	//TOP STOCKS UNDER QA And LIVE//////////////////////////////////
	
	@FindBy(how = How.XPATH, using = ".//*[@id='leftList']/a/img")
	public List<WebElement> topstocks_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='emailAddress']")
	public List<WebElement> topstocks_email_field;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> topstocks_email_continuebtn;

	//CHAIRMAN QA And LIVE///////////////////////////////////
	
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> chairman_mlp_btn_first;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='sectionOne']/div/a/img")
	public List<WebElement> chairman_mlp_btn_second;
	
	@FindBy(how = How.XPATH, using = "//*[@id='emailAddress']")
	public List<WebElement> chairman_email_field;
	
	@FindBy(how = How.XPATH, using = "//*[@id='submitButton']")
	public List<WebElement> chairman_email_continuebtn;
	
	//RMYPPORTFOLIO QA And LIVE//////////////////////////////////
	
	@FindBy(how = How.XPATH, using = ".//*[@id='sectionOne']/div/a/img")
	public List<WebElement> rmpp_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='emailAddress']")
	public List<WebElement> rmpp_email_field;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> rmpp_email_continuebtn;
	
	
	//CHATTER QA And LIVE//////////////////////////////////
	
	@FindBy(how = How.XPATH, using = ".//a[contains(.,'Sign Up Now')]")
	public List<WebElement> chatter_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='emailAddress']")
	public List<WebElement> chatter_email_field;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> chatter_email_continuebtn;
	
	
	//RETIREMENT DAILY
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='areaOne']/div/a/img")
	public List<WebElement> retirement_mlp_btn;

	@FindBy(how = How.XPATH, using = ".//*[@id='emailAddress']")
	public List<WebElement> retirement_email_field;

	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	public List<WebElement> retirement_email_continuebtn;
	
	//NEW POPUP
	
	@FindBy(how = How.XPATH, using = "//div[@style='background-color: rgb(247, 247, 247) ! important;']")
	public List<WebElement> popup_banner;
	
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Close']")
	public List<WebElement> popup_close;
	
	
	
	
}
