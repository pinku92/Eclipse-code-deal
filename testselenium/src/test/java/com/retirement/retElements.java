package com.retirement;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.test.base;

public class retElements extends base {

	
	@FindBy(how =How.XPATH,using="[@id='5aa942cc71ca5']") 
	WebElement login;
	@FindBy(how =How.LINK_TEXT,using="Login") 
	WebElement log;
	@FindBy(how =How.ID,using="username") 
	WebElement username;
	@FindBy(how =How.ID,using="password") 
	WebElement password;
	@FindBy(how =How.ID,using="authAjax") 
	WebElement submit;
	@FindBy(how =How.XPATH,using="//*[@class='logo logo--header']/a/img") 
	WebElement rethd;
	@FindBy(how =How.XPATH,using="//*[@id='select-term']") 
	WebElement keyword;
	@FindBy(how =How.XPATH,using="/html/body/div/div[3]/div/div[2]/div[1]/header/div[2]/div[1]/button") 
	WebElement switchto;
	@FindBy(how =How.XPATH,using="/html/body/div/div[3]/div/div[2]/div[1]/header/div[2]/div[2]/button") 
	WebElement help;
	@FindBy(how =How.XPATH,using="/html/body/div/div[3]/div/div[2]/div[1]/header/div[2]/div[3]/button") 
	WebElement accnt;
	@FindBy(how =How.XPATH,using="//*[@class='box first']") 
	WebElement weekrd;
	@FindBy(how =How.XPATH,using="//*[@id='retirement']/div/div[2]/div[1]/a") 
	WebElement readmore;
	@FindBy(how =How.XPATH,using="//*[@id='retirement']/div/div[2]/div[3]") 
	WebElement qabox;
	@FindBy(how =How.XPATH,using="//*[@id='retirement']/div/div[2]/div[3]/a") 
	WebElement readmore1;
	@FindBy(how =How.XPATH,using="//*[@id='retirement']/div/div[2]/div[4]") 
	WebElement aboutauthor;
	@FindBy(how =How.XPATH,using="//*[@class='row item']") 
	List<WebElement> articlelist1;
	@FindBy(how =How.XPATH,using="//*[@class='loadmore']") 
	WebElement load1;
	@FindBy(how =How.XPATH,using="//*[@id='saving-and-investing']/div") 
	WebElement savcategory;
	@FindBy(how =How.XPATH,using="//*[@id='retirement']/div/div[1]/header/span") 
	WebElement categoryheadline;
	@FindBy(how =How.XPATH,using="//*[@id='living-in-retirement']/div") 
	WebElement livcategory;
	@FindBy(how =How.XPATH,using="//*[@id='social-security-medicare']") 
	WebElement socseccategory;
	@FindBy(how =How.XPATH,using="//*[@id='your-money']/div") 
	WebElement yourmcategory;
	@FindBy(how =How.XPATH,using="//*[@id='money-makeovers']/div") 
	WebElement moneycategory;
	@FindBy(how =How.XPATH,using="//*[@id='learning-center']/div") 
	WebElement learnctr;
	@FindBy(how =How.XPATH,using="//*[@id='weekly-roundup']/div") 
	WebElement weeklyrnd;
	@FindBy(how =How.XPATH,using="//*[@id='resources']/div") 
	WebElement resources;
	@FindBy(how =How.XPATH,using="//*[@id='ask-bob']/div") 
	WebElement askbob;
	@FindBy(how =How.XPATH,using=" //*[@id='retirement']/section/div[2]/div[2]/div/button ") 
	WebElement askbobfilter;
	@FindBy(how =How.XPATH,using=" //*[@id='retirement']/section/div[2]/div[2]/button") 
	WebElement askbobquestion;
	@FindBy(how =How.XPATH,using=" //*[@id='retirement']/section/div[2]/div[3]/div/div/input") 
	WebElement askbobsearch;
	@FindBy(how =How.XPATH,using="//*[@class='forum__question']") 
	List<WebElement> askbobquestionlist;
	@FindBy(how =How.XPATH,using=" //*[@id='retirement']/section/div[2]/div[2]/button") 
	WebElement askquestion;
	@FindBy(how =How.XPATH,using="//*[@id='askForm__firstName']") 
	WebElement firstname;
	@FindBy(how =How.XPATH,using="//*[@id='askForm__lastName']") 
	WebElement lastname;
	@FindBy(how =How.XPATH,using="//*[@class='logo logo--footer']/img") 
	WebElement ftlogo;
	@FindBy(how =How.XPATH,using="//*[@class='footer__legal-links']/span[1]/a") 
	WebElement about;
	@FindBy(how =How.XPATH,using="//*[@class='footer__legal-links']/span[2]/a") 
	WebElement privacy;
	@FindBy(how =How.XPATH,using="//*[@class='footer__legal-links']/span[3]/a") 
	WebElement tmu;
	@FindBy(how =How.XPATH,using="//*[@class='footer__trademark']") 
	WebElement copywrights;
	@FindBy(how =How.XPATH,using="//*[@class='social-links social-links--footer']") 
	WebElement social;
	@FindBy(how =How.XPATH,using="//*[@id='retirement']/div/div[1]/div/div[1]/div[2]/div/h3/a") 
	WebElement article;
	@FindBy(how =How.XPATH,using="//*[@id='home']/div") 
	WebElement home;
	@FindBy(how =How.XPATH,using="//*[@id='retirement']/div[1]/div/div/div/div/header/span") 
	WebElement categoryname;
	@FindBy(how =How.XPATH,using="//*[@class='article__body article-back-header__body']") 
	WebElement articlebody;
	@FindBy(how =How.XPATH,using="//*[@id='5aa942cc71ca5']") 
	WebElement GetRET;
	
	
	
	
	
	
	
	
	


	
}
