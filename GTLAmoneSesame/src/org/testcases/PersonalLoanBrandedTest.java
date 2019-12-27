/**
 * 
 */
/**
 * @author pnomula
 *
 */

package org.testcases;

import org.factory.DriverFactory;
import org.module.Personalloanbranded;
import org.report.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PersonalLoanBrandedTest {

	
	@Test
	public void Desktop1a()
	{
		Logger.addTestCase("Default","Verify Valid case: Redirects to 9 Digit SSN and Thankyou page");
		DriverFactory.readyForTestCase();
		DriverFactory.initiateDriver();
		DriverFactory.driver.get("http://guidetolenders.test.quinstreet.net/personalloans/branded/prequals.jsp?VKey=14656310&skipverify=yes&qacs=720&cps=true"); 
		Personalloanbranded.Brandedflow("Debt Consolidation", "21000", "Good", "Self Employed", "34,535", "Rent", "<1 year", "90001", "950 tower lane", 
				"Test", "Test", "4", "12", "1987", "408", "839", "7368", "111", "11", "1111");
	}
}
