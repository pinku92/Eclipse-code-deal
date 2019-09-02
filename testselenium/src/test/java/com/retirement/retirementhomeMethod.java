package com.retirement;



import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.read;

public class retirementhomeMethod extends retElements{

	
		/*
	executor.executeScript("arguments[0].click();", element);*/
	
	
	public void action(WebDriver driver) throws InterruptedException, EncryptedDocumentException, InvalidFormatException{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	 	WebElement element = driver.findElement(By.xpath("//div[@id='5aac6d30bec78']"));
		executor.executeScript("arguments[0].click();", element);
		read exc = new read();
		

		username.sendKeys(exc.InputData(0, 1, "retirement"));
	 	password.sendKeys(exc.InputData(1, 1, "retirement"));
		submit.click();
		}
	
	
	
//	JavascriptExecutor js =(JavascriptExecutor)driver;
//  js.executeScript("window.scrollTo(0,login.getLocation().x+");
  //login.click();
//	login.click();
//	Actions act = new Actions(driver);
// act.moveToElement(login).click().build().perform();
//Thread.sleep(5000);
	//GetRET.click();
	//username.sendKeys(id);
	//password.sendKeys(pwd);
	//submit.click();
	public void home() throws InterruptedException, EncryptedDocumentException, InvalidFormatException{
		read exc = new read();
		if (exc.InputData(11, 1, "retirement").equalsIgnoreCase("Yes")){
		//header 
	this.check(rethd,"RET logo present","logo not present");
	this.check(keyword,"Keyword search is present", "Keyword search not present");
	this.check(switchto, "Switch to in the Header is displayed", "switch to is not displayed");
	this.check(help, "Help option is displayed", "No Help option is displayed");
	this.check(accnt, "Account option is displayed", "No Account option is displayed");
	//this.check(weekrd, "Weekly roundup module' is displayed on right rail", "Weekly roundup module' is NOT displayed on right rail");
	//this.check(readmore, "Readmore for weekly roundup is displayed ", "Readmore for weekly roundup is NOT displayed");
	this.check(qabox, "'QA module' is displayed on right rail", "'QA module' is NOT displayed on right rail");
	Thread.sleep(3000);
	this.check(readmore1, "Readmore for Q&A is displayed", "Readmore for Q&A is NOT displayed");
	this.check(aboutauthor, "'About the author module' is displayed on right rail", "'About the author module' is NOT displayed on right rail");
	this.count(articlelist1, "The Home page article count is ");
	Thread.sleep(2000);
	this.text(load1, "Clicked ");
	load1.click();
	Thread.sleep(3000);
    this.count(articlelist1, "The Home page article count after load more is ");
    
    //footer section
    this.check(ftlogo, "'TheStreet' logo in footer is displayed", "'TheStreet' logo in footer is not displayed");
    this.check(about, "About link is displayed in the footer section", "About link NOT displayed in the footer section");
    this.check(about, "Privacy link is displayed in the footer section", "Privacy link NOT displayed in the footer section");
    this.check(about, "Terms of use link is displayed in the footer section", "Terms of use link NOT displayed in the footer section");
    this.text(copywrights, "Copywrights line is displayed as ");
    this.check(social, "'All Social media links' in footer is displayed ", "'No Social media links' in footer is displayed");
    
    
	}
	}

}
