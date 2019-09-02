package com.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class base {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:/Users/PinkuJacob.C/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://stageretirement.thestreet.com/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	//	WebElement logg = driver.findElement(By.cssSelector("#\35 aac6d30bec78"));
		//logg.click();
  }
  
  public void check(WebElement aa,String str,String str1){
		if (aa.isDisplayed()){
			System.out.println(str);
		}else{
			System.out.println(str1);
		}
	}
  
  public void count(List<WebElement> bb,String str2){
	  System.out.println(str2 +bb.size());
  }
  
  public void text(WebElement cc, String str3){
	  System.out.println(str3 +cc.getText());
	  
  }
  
@AfterMethod
public void after(){
	driver.close();
}

  
  
}
