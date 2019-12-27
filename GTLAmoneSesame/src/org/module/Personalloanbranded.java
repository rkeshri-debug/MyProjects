/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.module;


import java.util.Random;



import org.factory.DriverFactory;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;


public class Personalloanbranded {
	
	public static void Brandedflow(String LoanPurpose, String LoanAmount, String Creditrating, String Employmentstatus, String AnnualPreTax, String OwnHome,
			String TimeAtResidence, String Zip, String Address, String FirstN, String LastN, String BirthMonth, String BirthDay, String BirthYear, String Area, String Phone,
			String Number, String SSNAREA, String SSNGROUP, String SSNNUMBER)
	{

	Select LoanSelect = new Select(DriverFactory.driver.findElement(By.xpath("//select[@name='LoanPurpose']")));
	LoanSelect.selectByVisibleText(LoanPurpose);
	DriverFactory.addRuntimeValues("How would you like to spend the money", LoanPurpose);
	
	
	DriverFactory.driver.findElement(By.id("CashOut")).clear();
	DriverFactory.driver.findElement(By.id("CashOut")).sendKeys(LoanAmount);
	DriverFactory.addRuntimeValues("How much cash would you like?", LoanAmount);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	DriverFactory.driver.findElement(By.id("CreditRating")).click();
	
	DriverFactory.addRuntimeValues("What is your estimated credit rating?", Creditrating);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	DriverFactory.driver.findElement(By.id("EmploymentStatus")).click();	
	DriverFactory.addRuntimeValues("What is your current employment status?", Employmentstatus);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	DriverFactory.driver.findElement(By.id("Income")).sendKeys(AnnualPreTax);
	DriverFactory.addRuntimeValues("What's your annual pre-tax income?", AnnualPreTax);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	DriverFactory.driver.findElement(By.id("OwnHome")).click();
//	Select OwnHouse= new Select(DriverFactory.driver.findElement(By.xpath("//select[@name='OwnHome']")));
//	OwnHouse.selectByVisibleText(OwnHome);
	DriverFactory.addRuntimeValues("Do you rent or own?", OwnHome);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	
	DriverFactory.driver.findElement(By.id("TimeAtCurrentResidence")).click();
//	Select ResidenceTime= new Select(DriverFactory.driver.findElement(By.xpath("//select[@name='TimeAtCurrentResidence']")));
//	ResidenceTime.selectByVisibleText(TimeAtResidence);
	DriverFactory.addRuntimeValues("How long have you lived at this address?", TimeAtResidence);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	DriverFactory.driver.findElement(By.id("TempPC")).sendKeys(Zip);
	DriverFactory.addRuntimeValues("What is your ZIP code?", Zip);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	DriverFactory.driver.findElement(By.id("S1")).sendKeys(Address);
	DriverFactory.addRuntimeValues("What is your street address?", Address);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	DriverFactory.driver.findElement(By.id("EM")).sendKeys(getRandomEmail(10));
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	DriverFactory.driver.findElement(By.id("FN")).sendKeys(FirstN);
	DriverFactory.addRuntimeValues("What is your First Name?", FirstN);
	DriverFactory.driver.findElement(By.id("LN")).sendKeys(LastN);
	DriverFactory.addRuntimeValues("What is your Last Name?", LastN);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	
	Select Month = new Select(DriverFactory.driver.findElement(By.xpath("//select[@name='BirthMonth_Numeric']")));
	Month.selectByVisibleText(BirthMonth);
	DriverFactory.addRuntimeValues("How would you like to spend the money", BirthMonth);
	
	Select Day = new Select(DriverFactory.driver.findElement(By.xpath("//select[@name='BirthDay_Numeric']")));
	Day.selectByVisibleText(BirthDay);
	DriverFactory.addRuntimeValues("How would you like to spend the money", BirthDay);
	
	Select Year = new Select(DriverFactory.driver.findElement(By.xpath("//select[@name='BirthYear_Numeric']")));
	Year.selectByVisibleText(BirthYear);
	DriverFactory.addRuntimeValues("How would you like to spend the money", BirthYear);
	DriverFactory.driver.findElement(By.id("submitButton")).click();

	DriverFactory.driver.findElement(By.xpath("//input[@name='HP_AREA']")).sendKeys(Area);
	DriverFactory.addRuntimeValues("HomePhone", Area);
	
	DriverFactory.driver.findElement(By.xpath("//input[@name='HP_PREFIX']")).sendKeys(Phone);
	DriverFactory.addRuntimeValues("HomePhone", Phone);
	
	DriverFactory.driver.findElement(By.xpath("//input[@name='HP_NUMBER']")).sendKeys(Number);
	DriverFactory.addRuntimeValues("HomePhone", Number);
	DriverFactory.driver.findElement(By.id("submitButton")).click();
	
	
	DriverFactory.driver.findElement(By.xpath("//input[@name='SSN_AREA']")).sendKeys(SSNAREA);
	DriverFactory.addRuntimeValues("HomePhone", SSNAREA);
	
	DriverFactory.driver.findElement(By.xpath("//input[@name='SSN_GROUP']")).sendKeys(SSNGROUP);
	DriverFactory.addRuntimeValues("HomePhone", SSNGROUP);
	
	DriverFactory.driver.findElement(By.xpath("//input[@name='SSN_NUMBER']")).sendKeys(SSNNUMBER);
	DriverFactory.addRuntimeValues("HomePhone", SSNNUMBER);
	DriverFactory.driver.findElement(By.id("compareButton")).click();
	
	
	}


	public static String getRandomEmail(int length) {
		String str= "Branded";
		
		String mail = "";
		for(int i = 0 ;i < length ;i++) {
			int index = new Random().nextInt(str.length());
			mail = mail + String.valueOf(str.charAt(index));
		}
		return mail+"@ohayo.com";
	}
	}

