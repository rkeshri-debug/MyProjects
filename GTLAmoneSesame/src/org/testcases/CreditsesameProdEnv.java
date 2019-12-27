/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.testcases;

import org.factory.DriverFactory;
import org.module.Mobile;
import org.module.PersonalLoans;
import org.report.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreditsesameProdEnv {

	
	@Test
	public void Desktop() {
		Logger.addTestCase("CreditSesame","Verify all valid Parameters : Redirects to 9 Digit SSN and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.driver.get("http://personal-loans.creditsesame.com/creditsesame/service.jsp?dping=yes&qacs=720&doTUPing=true&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122&skipTE=true&cs=d&vc=15452310");
		PersonalLoans.PersonalLoanForm("Debt Consolidation", "20000", "Excellent", "Employed", "20000", "Own", "1 to 2 years", "94559", "143, CAPSTONE, NAPA, CA", "Test", 
				"Test", "4-4-1989", "954", "315", "5950", "111", "11", "1111");	
	//ADR
	}
	
	@Test
	public void Mobile() {
		Logger.addTestCase("CreditSesame","Verify all valid Parameters : Redirects to 9 Digit SSN and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.changeMobileView();
		DriverFactory.driver.get("http://personal-loans.creditsesame.com/creditsesame/service.jsp?dping=yes&qacs=720&doTUPing=true&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122&skipTE=true&cs=d&vc=15452310");
		Mobile.PersonalLoanForm("Debt Consolidation", "20000", "Excellent", "Employed", "20000", "Own", "1 to 2 years", "94559", "143, CAPSTONE, NAPA, CA", "Test", 
				"Test", "4-4-1989", "954", "315", "5950", "111", "11", "1111");	
		//ADR
	}
	
	
	@AfterMethod
	public void teardown() {
		DriverFactory.driver.close();
		try {
			DriverFactory.driver.quit();
		}catch(Exception e) {
			
		}
	Logger.finshtestCase();
	}
}
