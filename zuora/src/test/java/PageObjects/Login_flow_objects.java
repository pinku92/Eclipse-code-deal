package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_flow_objects {

	private WebDriver driver;
	 
	public Login_flow_objects(WebDriver driver) {
		this.driver = driver;
	}
	
	//AAP
	
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_aap_login_link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='username']")
	public List<WebElement> stage_aap_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	public List<WebElement> stage_aap_login_pwd;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public List<WebElement> stage_aap_submitbtn;
	
	
	//RMY
	
	@FindBy(how = How.XPATH, using = ".//*[@id='areaOne']/div/a/img")
	public List<WebElement> stage_rmy_mlp_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='login_status']/a[2]")
	public List<WebElement> stage_rmy_login_link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[1]/input")
	public List<WebElement> stage_rmy_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[2]/input")
	public List<WebElement> stage_rmy_login_pwd;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/input[3]")
	public List<WebElement> stage_rmy_submitbtn;
	
	//RMYPRO
	
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_rmypro_login_link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[1]/input")
	public List<WebElement> stage_rmypro_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[2]/input")
	public List<WebElement> stage_rmypro_login_pwd;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/input[3]")
	public List<WebElement> stage_rmypro_submitbtn;
	
	//RMYPRO PORTFOLIO
	
	@FindBy(how = How.XPATH, using = ".//*[@id='sectionOne']/div/a/img")
	public List<WebElement> stage_rmypro_portfolio_mlp_btn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Log In')]")
	public List<WebElement> stage_rmypro__portfolio_login_link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[1]/input")
	public List<WebElement> stage_rmypro_portfolio_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[2]/input")
	public List<WebElement> stage_rmypro_portfolio_login_pwd;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/input[3]")
	public List<WebElement> stage_rmypro_portfolio_submitbtn;

	
	//TOP STOCKS

	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_topstocks_login_link;
	
	@FindBy(how = How.XPATH, using = "//input[@name='login']")
	public List<WebElement> stage_topstocks_login_username;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	public List<WebElement> stage_topstocks_login_pwd;
	
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	public List<WebElement> stage_topstocks_submitbtn;

	//STOCKS UNDER $10
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_stocksunder_login_link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[1]/input")
	public List<WebElement> stage_stocksunder_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[2]/input")
	public List<WebElement> stage_stocksunder_login_pwd;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/input[3]")
	public List<WebElement> stage_stocksunder_submitbtn;

	//CHAIRMAN CLUB
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_chairman_login_link;
	
	@FindBy(how = How.XPATH, using = "//input[@name='login']")
	public List<WebElement> stage_chairman_login_username;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	public List<WebElement> stage_chairman_login_pwd;
	
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	public List<WebElement> stage_chairman_submitbtn;

	//INCOME SEEKER
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_income_login_link;
	
	@FindBy(how = How.XPATH, using = "//input[@name='login']")
	public List<WebElement> stage_income_login_username;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	public List<WebElement> stage_income_login_pwd;
	
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	public List<WebElement> stage_income_submitbtn;

	//STOCKS UNDER $10
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_quantratings_login_link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[1]/input")
	public List<WebElement> stage_quantratings_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[2]/input")
	public List<WebElement> stage_quantratings_login_pwd;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/input[3]")
	public List<WebElement> stage_quantratings_submitbtn;

	//TRIFECTA STOCKS
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_trifecta_login_link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[1]/input")
	public List<WebElement> stage_trifecta_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/fieldset[2]/input")
	public List<WebElement> stage_trifecta_login_pwd;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginBox']/form/input[3]")
	public List<WebElement> stage_trifecta_submitbtn;

	//CHATTER
	@FindBy(how = How.XPATH, using = "//a/img[@class='LogIn']")
	public List<WebElement> stage_chatter_login_link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='username']")
	public List<WebElement> stage_chatter_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	public List<WebElement> stage_chatter_login_pwd;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public List<WebElement> stage_chatter_submitbtn;

	//RETIREMENT DAILY
	@FindBy(how = How.XPATH, using = ".//*[@id='login']/a")
	public List<WebElement> stage_retirement_login_link1;
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Login')]")
	public List<WebElement> stage_retirement_login_link2;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='username']")
	public List<WebElement> stage_retirement_login_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	public List<WebElement> stage_retirement_login_pwd;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public List<WebElement> stage_retirement_submitbtn;








}
