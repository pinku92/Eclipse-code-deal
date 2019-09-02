package PageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageMethods.Selfservice_flow_methods;
import PageObjects.Selfservice_flow_objects;
import TestBase.TestBase;

public class Selfservice_flow_library extends TestBase{

	public Selfservice_flow_library(WebDriver driver) {
		self_objects = PageFactory.initElements(driver, Selfservice_flow_objects.class);
	}
	
	public void START_SELFSERVICE(String email,String pwd,String product,String outputsheet) throws InterruptedException {
		Selfservice_flow_methods.check_self_service(email,pwd, product,outputsheet);
	}
	
}
