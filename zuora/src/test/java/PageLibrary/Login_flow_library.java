package PageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageMethods.Login_flow_methods;
import PageObjects.Login_flow_objects;
import TestBase.TestBase;

public class Login_flow_library extends TestBase{
	public Login_flow_library(WebDriver driver) {
		login_objects = PageFactory.initElements(driver, Login_flow_objects.class);
	}
	
	public void START_LOGIN(String product, String user, String pwd) throws InterruptedException {
		Login_flow_methods.login_premium_products(product, user, pwd);
	}
}
