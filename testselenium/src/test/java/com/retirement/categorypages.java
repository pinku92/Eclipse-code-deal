package com.retirement;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.utility.read;

public class categorypages extends retElements {
	
	

	public void category() throws InterruptedException, EncryptedDocumentException, InvalidFormatException{
		Thread.sleep(1000);
		read exc = new read();
		if (exc.InputData(3, 1, "retirement").equalsIgnoreCase("Yes")) {
			savcategory.click();
			this.text(categoryheadline, "The First category name is ");
			Thread.sleep(3000);
			this.count(articlelist1, "The " + categoryheadline.getText() + " articles count is ");
			this.text(load1, "Clicked ");
			load1.click();
			Thread.sleep(3000);
			this.count(articlelist1, "The " + categoryheadline.getText() + " articles count after load more is ");
			Thread.sleep(3000);
		} else 
			System.out.println("Run mode is not set to Yes, hence skipping");
	
		if (exc.InputData(4, 1, "retirement").equalsIgnoreCase("Yes")){
    livcategory.click();
    this.text(categoryheadline, "The Second category name is ");
    Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count is ");
    this.text(load1, "Clicked ");
	load1.click();
	Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count after load more is ");
    Thread.sleep(4000);	
		}else 
			System.out.println("Run mode is not set to Yes, hence skipping");
		
		if (exc.InputData(5, 1, "retirement").equalsIgnoreCase("Yes")){
    socseccategory.click(); 
    this.text(categoryheadline, "The Third category name is ");
    Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count is ");
    this.text(load1, "Clicked ");
	load1.click();
	Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count after load more is ");
    Thread.sleep(3000);	
		}
		if (exc.InputData(6, 1, "retirement").equalsIgnoreCase("Yes")){
		
    yourmcategory.click();
    this.text(categoryheadline, "The Fourth category name is ");
    Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count is ");
    this.text(load1, "Clicked ");
	load1.click();
	Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count after load more is ");
    Thread.sleep(3000);	
		}
		if (exc.InputData(7, 1, "retirement").equalsIgnoreCase("Yes")){
    moneycategory.click();
    this.text(categoryheadline, "The Fifth category name is ");
    Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count is ");
    this.text(load1, "Clicked ");
	load1.click();
	Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count after load more is ");
    Thread.sleep(3000);	
		}
		if (exc.InputData(8, 1, "retirement").equalsIgnoreCase("Yes")){
    learnctr.click();
    this.text(categoryheadline, "The Sixth category name is ");
    Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count is ");
    this.text(load1, "Clicked ");
	load1.click();
	Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count after load more is ");
    Thread.sleep(3000);
		}
		if (exc.InputData(9, 1, "retirement").equalsIgnoreCase("Yes")){
    weeklyrnd.click();
    this.text(categoryheadline, "The Seventh category name is ");
    Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count is ");
    this.text(load1, "Clicked ");
	load1.click();
	Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count after load more is ");
    Thread.sleep(3000);
		}
		if (exc.InputData(10, 1, "retirement").equalsIgnoreCase("Yes")){
    resources.click();
    this.text(categoryheadline, "The Eigth category name is ");
    Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count is ");
    this.text(load1, "Clicked ");
	load1.click();
	Thread.sleep(3000);
    this.count(articlelist1, "The " +categoryheadline.getText()+" articles count after load more is ");
    Thread.sleep(3000);
		}
         
    	}
	
}
