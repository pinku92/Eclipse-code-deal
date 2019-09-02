package com.test;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.retirement.artilcePage;
import com.retirement.askBob;
import com.retirement.categorypages;
import com.retirement.retirementhomeMethod;


public class retirementTC extends base {
  @Test
  public void retsite() throws InterruptedException, EncryptedDocumentException, InvalidFormatException {
 retirementhomeMethod obj= PageFactory.initElements(driver, retirementhomeMethod.class);
 obj.action(driver);
 obj.home();
 categorypages obj1= PageFactory.initElements(driver, categorypages.class);
 obj1.category();
 askBob obj2= PageFactory.initElements(driver, askBob.class);
 //obj2.bob();
 artilcePage obj3= PageFactory.initElements(driver, artilcePage.class);
 obj3.article();
  
  }
}
