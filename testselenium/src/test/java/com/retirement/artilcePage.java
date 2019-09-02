package com.retirement;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.utility.read;

public class artilcePage extends retElements {
	public void article() throws InterruptedException, EncryptedDocumentException, InvalidFormatException{
		Thread.sleep(1000);
		read exc = new read();
		if (exc.InputData(13, 1, "retirement").equalsIgnoreCase("Yes")){
	home.click();
	Thread.sleep(2000);
	this.text(article, "Clicked on first artilce --> ");
	article.click();
	Thread.sleep(1000);
	this.text(categoryname, "The article belongs the category name");
	this.check(articlebody, "Body of the article is displayed", "Body of the article is not displayed");
	Thread.sleep(2000);
	//read exc = new read();
	keyword.sendKeys(exc.InputData(2, 1, "retirement"));
	Thread.sleep(2000);
	keyword.submit();
		}
	
	}

	
	
	
}
