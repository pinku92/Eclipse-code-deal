package TestBase;

import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class instant_test extends TestBase {

	public static void main(String args[]) throws InterruptedException {
		selectBrowser("chrome");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		Load_Url("https://subscription.thestreet.com/retirement-daily-desktop/p/1");
		WebElement element = driver.findElement(By.xpath("//div[@id='5aac6d30bec78']"));
		executor.executeScript("arguments[0].click();", element);

	}

}
