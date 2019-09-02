package DriverScripts_Scenarios;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ExcelUtility.ConstantUtility;
import TestBase.TestBase;

public class Upsell_Crosssell_Comparison extends TestBase {

	@DataProvider
	public Object[][] Data() throws IOException {
		return getData(ConstantUtility.input_excel, "Compare_Upsell_Crosssell");
	}

	@BeforeSuite
	public void beforesuite() throws IOException, InterruptedException {
		RANDOM_USER_START_CONFIGURATIONS();
	}

	@Test(dataProvider = "Data")
	public void Do_Parameterization(String execution, String product, String oid,String plan) throws Exception {
		if (execution.equalsIgnoreCase("Yes")) {
			
			TEST_COMPARE(product, oid,plan);
			
//			EVENTS_TEST_COMPARE(product, oid, plan);
			
		} else {
			System.out.println("Unable start comparison process for___" + product + "___" + oid);
		}

	}

	@AfterSuite
	public void aftersuite() throws AddressException, MessagingException, IOException {
	}
}
