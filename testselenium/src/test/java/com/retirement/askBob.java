package com.retirement;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.utility.read;

public class askBob extends retElements {

	public void bob() throws InterruptedException, EncryptedDocumentException, InvalidFormatException{
		Thread.sleep(3000);
		read exc = new read();
		if (exc.InputData(12, 1, "retirement").equalsIgnoreCase("Yes")) {
		askbob.click();
		System.out.println("Ask bob is clicked");
		this.check(askbobfilter, "Filter in Ask Bob is displayed", "Filter in Ask Bob is NOT displayed");
		this.check(askbobquestion, "Ask BOB a Qustion is displyed", "Ask BOB a Qustion is displyed");
		this.check(askbobsearch, "'Search Forum' field in Ask bob page is displayed", "Search field is not displyed");
		Thread.sleep(3000);
		this.count(askbobquestionlist, "The list of Questions in Ask Bob forum are");
		//askquestion.click();
		//System.out.println("Ask Bob A Question is clicked");
		//this.check(firstname, "First Name field is displayed", "First Name section not displayed");
		//this.check(lastname, "Last Name field is displayed", "Last Name section not displayed");
	    	
		} else 
			System.out.println("Run mode is not set to Yes, hence skipping");
	}
	
}
