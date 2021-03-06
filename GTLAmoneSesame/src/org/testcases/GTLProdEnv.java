/**
 * 
 */
/**
 * @author pnomula
 *
 */

package org.testcases;


import org.factory.DriverFactory;
import org.module.PersonalLoans;
import org.module.Environment;
import org.module.Mobile;
import org.report.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GTLProdEnv {
	
	
	@Test
	public void Desktop() {
			Logger.addTestCase("GTL","Verify all valid Parameters : Redirects to 9 Digit SSN and Thankyou page");
			DriverFactory.readyForTestCase();
			DriverFactory.initiateDriver();
		//	DriverFactory.driver.get("http://guidetolenders.test.quinstreet.net/personalloans/service.jsp?dping=yes&qacs=720&doTUPing=true&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122&skipTE=true&cs=d");
			DriverFactory.driver.get("http://guidetolenders.com/personalloans/service.jsp?dping=yes&qacs=720&doTUPing=true&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122&skipTE=true&cs=d&vc=15452310"); 
			PersonalLoans.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "91791", "1945, GARVEY, WEST COVINA, CA", "Test", 
					"Test", "4-4-1989", "954", "315", "5950", "111", "111", "1111");
		//ADR
		}
	
	
	
	@Test
	public void Mobile() {
		Logger.addTestCase("GTL","Verify all valid Parameters : Redirects to 9 Digit SSN and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.changeMobileView();
		DriverFactory.driver.get("http://guidetolenders.com/personalloans/service.jsp?dping=yes&qacs=720&doTUPing=true&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122&skipTE=true&cs=d&vc=15452310"); 
		Mobile.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "94559", "143, CAPSTONE, NAPA, CA", "Test", 
				"Test", "4-4-1989", "954", "315", "5950", "111", "11", "1111");	
		
		//ADR
	}

	
	@AfterMethod
	public void teardown() {
	Logger.finshtestCase();
	}
}
