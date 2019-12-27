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

public class CreditSesameStageEnv {

	//@Test
	public void Desktop1a() {
		Logger.addTestCase("Default","Verify Valid case: Redirects to 9 Digit SSN and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes");
		PersonalLoans.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "94559", "143, CAPSTONE, NAPA, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
	}
	
//	@Test--
	public void Desktop1b() {
		Logger.addTestCase("Default","Verify Invalid case: Redirects to 9 Digit SSN, Conformation page and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122&skipTE=true"); 
		PersonalLoans.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "90001", "901 Nevin Avenue, Richmond, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
		}
	
	
	//@Test
	public void Desktop2a() {
		Logger.addTestCase("doTUping =true&social=partial Or social=partial","Verify Valid case: Redirects to 9 Digit SSN and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&doTUping=true&social=partial"); 
		PersonalLoans.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "91791", "1945, GARVEY, WEST COVINA, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
	}

//	@Test--
	public void Desktop2b() {
		Logger.addTestCase("doTUping =true&social=partial Or social=partial","Verify Invalid case: Redirects to 9 Digit SSN, Confirmation page and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&doTUping=true&social=partial&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122"); 
		PersonalLoans.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "91791", "1945, GARVEY, WEST COVINA, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "", "", "1111");	
	}
	
	//@Test
	public void Desktop3a() {
		Logger.addTestCase("doTUping =true","Verify Valid case: Redirects Redirects to 9 Digit SSN and Thankyou page ");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&doTUping=true"); 
		PersonalLoans.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "92692", "28083, GEORGETOWN, MISSION VIEJO, CA", "Test", 
			"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
	}
	
	
	//@Test--
	public void Desktop3b() {
		Logger.addTestCase("doTUping =true","Verify Invalid case: Redirects to 9 Digit SSN, conformation page then Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&doTUping=true&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122"); 
		PersonalLoans.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "92692", "28083, GEORGETOWN, MISSION VIEJO, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
	}
	
	
	//----------------------------Mobile Control Flow------------------------------
	
	
	
//	@Test
	public void Mobile1a() {
		Logger.addTestCase("Default","Verify Valid case: Redirects to 9 Digit SSN and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.changeMobileView();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes");
		Mobile.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "94559", "143, CAPSTONE, NAPA, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
	}
	
//	@Test--
	public void Mobile1b() {
		Logger.addTestCase("Default","Verify Invalid case: Redirects to 9 Digit SSN, Conformation page and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.changeMobileView();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122&skipTE=true"); 
		Mobile.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "90001", "901 Nevin Avenue, Richmond, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
		}
	
	
//		@Test
	public void Mobile2a() {
		Logger.addTestCase("doTUping =true&social=partial Or social=partial","Verify Valid case: Redirects to 4 Digit SSN and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.changeMobileView();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&doTUping=true&social=partial"); 
		Mobile.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "91791", "1945, GARVEY, WEST COVINA, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
	}

	//@Test--
	public void Mobile2b() {
		Logger.addTestCase("doTUping =true&social=partial Or social=partial","Verify Invalid case: Redirects to 4 Digit SSN, Confirmation page and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.changeMobileView();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&doTUping=true&social=partial&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122"); 
		Mobile.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "91791", "1945, GARVEY, WEST COVINA, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "", "", "1111");	
	}
	
//	@Test
	public void Mobile3a() {
		Logger.addTestCase("doTUping =true","Verify Valid case: Redirects to Thankyou page (No SSN page)");
		DriverFactory.readyForTestCase()	;
		DriverFactory.initiateDriver();
		DriverFactory.changeMobileView();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&doTUping=true"); 
		Mobile.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "92692", "28083, GEORGETOWN, MISSION VIEJO, CA", "Test", 
			"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
	}
	
	
	//@Test--
	public void Mobile3b() {
		Logger.addTestCase("doTUping =true","Verify Invalid case: Redirects to conformation page then Thankyou page (No SSN page)");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.changeMobileView();
		DriverFactory.driver.get("http://personal-loans-creditsesame.quinstage.com/creditsesame/service.jsp?dping=yes&doTUping=true&CCID=20115243203619638&QTR=ZZf201006101154240Za20115243Zg255Zw0Zm0Zc203619638Zs10267ZZ&CLK=506190523133554122"); 
		Mobile.PersonalLoanForm("Debt Consolidation", "20000","Excellent", "Employed", "20000", "Own", "1 to 2 years", "92692", "28083, GEORGETOWN, MISSION VIEJO, CA", "Test", 
				"Test", "4-4-1989", "650", "578", "7700", "111", "11", "1111");	
	}
	@AfterMethod
	public void teardown() {
		DriverFactory.driver.close();
		try {
			DriverFactory.driver.quit();
		}catch(Exception e) {
			
		}
	
	}
	
}
