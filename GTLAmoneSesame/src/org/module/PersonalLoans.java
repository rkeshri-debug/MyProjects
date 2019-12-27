/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.module;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.beans.Customizer;
import java.sql.Driver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.factory.CustomWait;
import org.factory.DriverFactory;
import org.factory.ESignPage;
import org.factory.PrivacyPage;
import org.factory.TermAndUsePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.report.Logger;
import org.testng.Assert;



public class PersonalLoans {

	private static String guidetolendor_disclosure ="*GuideToLenders is not a loan provider but only matches you with lending partners that may extend a loan to you. All loan approval decisions and terms are determined by the loan providers at the time of your application with them. There is no guarantee that you will be approved for a loan or that you will qualify for the rates displayed. The offers and rates presented on this website are estimates based on information you submit to us. Your actual rates depend on your credit history, income, loan terms and other factors. Reasonable efforts are made to compile and maintain accurate information. However all loan rates and terms, including APRs, are presented without warranty and are subject to change by the loan providers without notice.";
	private static String guitolendor_disclosure_info = "By clicking See your offers now, you are providing your consent to the following:\r\n" + 
			"To be matched with up to five lenders or debt relief service providers and for them and/or GuidetoLenders to contact you (including by automated dialing systems and text) by telephone, mobile device (including SMS and MMS), and/or email, even if you are on a corporate, state or national Do Not Call list. Consent is not required in order to purchase goods and services from the Lenders or service providers that reach out to you.\r\n" + 
			"You authorize GuideToLenders to obtain your credit report and Social Security Number from a credit bureau to verify your identity and match you with up to five lenders. You further authorize GuideToLenders to provide to these lenders your full Social Security Number and any information you submitted to GuideToLenders. You further authorize these lenders separately to obtain your consumer credit report, credit score, and other information from one or more consumer reporting agencies to verify your identity and provide you with quotes.\r\n" + 
			"You agree to QS' Privacy Policy, Terms of Use and Consent to Receive Electronic Communications";


	private static String creditsesame_disclosre_info = "By clicking See your offers now, you are providing your consent to the following:\r\n" + 
			"To be matched with up to five lenders or debt relief service providers and for them and/or GuidetoLenders/CreditSesame to contact you (including by automated dialing systems and text) by telephone, mobile device (including SMS and MMS), and/or email, even if you are on a corporate, state or national Do Not Call list. Consent is not required in order to purchase goods and services from the Lenders or service providers that reach out to you.\r\n" + 
			"You authorize CreditSesame to obtain your credit report and Social Security Number from a credit bureau to verify your identity and match you with up to five lenders. You further authorize CreditSesame to provide to these lenders your full Social Security Number and any information you submitted to CreditSesame. You further authorize these lenders separately to obtain your consumer credit report, credit score, and other information from one or more consumer reporting agencies to verify your identity and provide you with quotes.\r\n" + 
			"You agree to QS' Privacy Policy, Terms of Use and Consent to Receive Electronic Communications";
	private static String amone_disclosure = "*Amone is not a loan provider but only matches you with lending partners that may extend a loan to you. All loan approval decisions and terms are determined by the loan providers at the time of your application with them. There is no guarantee that you will be approved for a loan or that you will qualify for the rates displayed. The offers and rates presented on this website are estimates based on information you submit to us. Your actual rates depend on your credit history, income, loan terms and other factors. Reasonable efforts are made to compile and maintain accurate information. However all loan rates and terms, including APRs, are presented without warranty and are subject to change by the loan providers without notice.";

	private static String amone_disclosure_infi = "By clicking See your offers now, you are providing your consent to the following:\r\n" + 
			"To be matched with up to five lenders or debt relief service providers and for them and/or GuidetoLenders/AmOne to contact you (including by automated dialing systems and text) by telephone, mobile device (including SMS and MMS), and/or email, even if you are on a corporate, state or national Do Not Call list. Consent is not required in order to purchase goods and services from the Lenders or service providers that reach out to you.\r\n" + 
			"You authorize AmOne to obtain your credit report and Social Security Number from a credit bureau to verify your identity and match you with up to five lenders. You further authorize AmOne to provide to these lenders your full Social Security Number and any information you submitted to AmOne. You further authorize these lenders separately to obtain your consumer credit report, credit score, and other information from one or more consumer reporting agencies to verify your identity and provide you with quotes.\r\n" + 
			"You agree to QS' Privacy Policy, Terms of Use and Consent to Receive Electronic Communications";

	public static void main(String[] args) {
		System.out.println(amone_disclosure_infi.replace("\r\n", ""));
	}

	public static void validateFooter() {
		// Terms of Use page
		DriverFactory.driver.findElement(By.xpath("//a[text()='Terms of Use']")).click();
		Set<String> handles = DriverFactory.driver.getWindowHandles();
		for(String s : handles) {
			DriverFactory.driver.switchTo().window(s);
		}
		String actualTitle = DriverFactory.driver.getTitle();
		if(actualTitle.equals("Terms Of Use")) {
			System.out.println("PASS   : Title match for Terms of Use");
			//	Logger.addTestStep(from+" disclamer  matched", amone_disclosure, "", "PASS");
		}else {
			System.out.println("FAIL   : Title not match for Terms of Use");
			Assert.assertEquals(actualTitle, "Terms Of Use");
		}

		String currentUrl = DriverFactory.driver.getCurrentUrl();
		if(currentUrl.contains( "/info/termsofuse.jsp")) {
			System.out.println("PASS   : Current URL match for Terms of Use");
		}else {
			System.out.println("FAIL   : Current URL not match for Terms of Use");
			Assert.assertTrue(currentUrl.contains("/info/termsofuse.jsp"));
		}


		checkFromSite();

		String txt = DriverFactory.driver.findElement(By.tagName("body")).getText();
		if(txt.replaceAll("\n", "").contains( TermAndUsePage.termAndUseTxt.replace("\r\n", ""))) {
			System.out.println("PASS   : Content match for Term of Use");
		}else {
			System.out.println("FAIL   : Content not match for Term of Use");
			Assert.assertTrue(txt.contains( TermAndUsePage.termAndUseTxt));
		}

		DriverFactory.driver.close();
		handles = DriverFactory.driver.getWindowHandles();
		for(String s : handles) {
			DriverFactory.driver.switchTo().window(s);
		}
		// E-Sign Consent
		// Privacy Policy 
		DriverFactory.driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
		handles = DriverFactory.driver.getWindowHandles();
		for(String s : handles) {
			DriverFactory.driver.switchTo().window(s);
		}



		actualTitle = DriverFactory.driver.getTitle();
		if(actualTitle.equals("Privacy Policy")) {
			System.out.println("PASS   : Title match for Privacy Policy");
		}else {
			System.out.println("FAIL   : Title not match for Privacy Policy");
			Assert.assertEquals(actualTitle, "Privacy Policy");
		}

		currentUrl = DriverFactory.driver.getCurrentUrl();
		if(currentUrl.contains( "/info/privacy.jsp")) {
			System.out.println("PASS   : Current URL match for Privacy Policy");
		}else {
			System.out.println("FAIL   : Current URL not match for Privacy Policy");
			Assert.assertTrue(currentUrl.contains("/info/privacy.jsp"));

		}

		checkFromSite();

		txt = DriverFactory.driver.findElement(By.tagName("body")).getText();
		txt = txt.replace("GuideToLenders", "");
		txt = txt.replace("Amone", "");

		PrivacyPage.txt = PrivacyPage.txt.replace("\r\n", "").replace("GuideToLenders", "");
		PrivacyPage.txt = PrivacyPage.txt.replace("\r\n", "").replace("Amone", "");


		if(txt.replaceAll("\n", "").contains( PrivacyPage.txt.replace("\r\n", ""))) {
			System.out.println("PASS   : Content match for Privacy Policy");
		}else {
			System.out.println("FAIL   : Content not match for Privacy Policy");
			Assert.assertTrue(txt.contains( PrivacyPage.txt));
		}

		DriverFactory.driver.close();
		handles = DriverFactory.driver.getWindowHandles();

		for(String s : handles) {
			DriverFactory.driver.switchTo().window(s);
		}


		// Privacy Policy 
		DriverFactory.driver.findElement(By.xpath("//a[text()='E-Sign Consent']")).click();
		handles = DriverFactory.driver.getWindowHandles();
		for(String s : handles) {
			DriverFactory.driver.switchTo().window(s);
		}



		actualTitle = DriverFactory.driver.getTitle();
		if(actualTitle.equals("Consent to Receive Electronic Communications")) {
			System.out.println("PASS   : Title match for E-Sign Consent");
		}else {
			System.out.println("FAIL   : Title not match for E-Sign Consent");
			Assert.assertEquals(actualTitle, "Consent to Receive Electronic Communications");
		}

		currentUrl = DriverFactory.driver.getCurrentUrl();
		if(currentUrl.contains( "/info/electroniccommunicationsconsent.jsp")) {
			System.out.println("PASS   : Current URL match for E-Sign Consent");
		}else {
			System.out.println("FAIL   : Current URL not match for E-Sign Consent");
			Assert.assertTrue(currentUrl.contains("/info/electroniccommunicationsconsent.jsp"));
		}

		checkFromSite();

		txt = DriverFactory.driver.findElement(By.tagName("body")).getText();
		System.out.println(txt);
		if(txt.replaceAll("\n", "").contains( ESignPage.txt.replace("\r\n", ""))) {
			System.out.println("PASS   : Content match for E-Sign Consent");
		}else {
			System.out.println("FAIL   : Content not match for E-Sign Consent");
			Assert.assertTrue(txt.contains( ESignPage.txt));
		}

		DriverFactory.driver.close();
		handles = DriverFactory.driver.getWindowHandles();

		for(String s : handles) {
			DriverFactory.driver.switchTo().window(s);
		}


	}
	private static boolean isFooterDone = false;


	public static void checkFromSite() {
		String currentUrl = DriverFactory.driver.getCurrentUrl();
		if(currentUrl.contains("amone")) {
			if(currentUrl.contains( "fromSite=amone")) {
				System.out.println("PASS   : Current URL match for from site amone");
				String src = DriverFactory.driver.findElement(By.xpath("//div[@id='header']/img")).getAttribute("src");
				if(src.contains("/amone/images/logo.png")) {
					System.out.println("PASS   : Amone image is present");

				}else {
					System.out.println("FAIL   : Amone image not presnent");
					Assert.assertEquals(src, "/amone/images/logo.png");
					

				}
			}else {
				System.out.println("FAIL   : Current URL not match for from site amosne");
				Assert.assertTrue(currentUrl.contains("fromSite=amone"));
			}
		}

	}
	public static void validateDisclosure(String from) {
		validateSiteAddress(from);
		if(!isFooterDone) {
			validateFooter();
			isFooterDone = true;
		}
		String actualDisclosure = DriverFactory.driver.findElement(By.id("disclosure")).getText();
		actualDisclosure = actualDisclosure.replace("\n", "");

		if(DriverFactory.driver.getCurrentUrl().contains("amone")) {
			amone_disclosure = amone_disclosure.replace("\r\n", "");
			if(actualDisclosure.equals(amone_disclosure)) {
				System.out.println("PASS   : "+from+" disclamer  matched");
				Logger.addTestStep(from+" disclamer  matched", amone_disclosure, "", "PASS");
			}else {
				System.out.println("FAIL   :  "+from+" disclaimier  not matched.");
				Assert.assertEquals(actualDisclosure.replace("\r\n", ""), amone_disclosure.replace("\r\n", ""));	
			}
		}

		if(DriverFactory.driver.getCurrentUrl().contains("guidetolenders") ||
				DriverFactory.driver.getCurrentUrl().contains("creditsesame")) {
			guidetolendor_disclosure = guidetolendor_disclosure.replace("\r\n", "");
			if(actualDisclosure.equals(guidetolendor_disclosure)) {
				System.out.println("PASS   : "+from+" disclamer  matched");
				Logger.addTestStep(from+" disclamer  matched", amone_disclosure, "", "PASS");
			}else {
				System.out.println("FAIL   :  "+from+" disclaimier  not matched.");
				Assert.assertEquals(actualDisclosure.replace("\r\n", ""), guidetolendor_disclosure.replace("\r\n", ""));	
			}
		}
	}

	private static String amone_siteaddress = "AmOne - 950 Tower Lane, 6th Floor - Foster City, CA 94404";
	private static String guidetolendor_siteaddress = "Guide to Lenders - 950 Tower Lane, 6th Floor - Foster City, CA 94404 - personalloans@guidetolenders.com";
	public static void validateSiteAddress(String from) {
		CustomWait.appWait(3);
		String siteAddress = DriverFactory.driver.findElement(By.id("siteaddress")).getText();
		if(DriverFactory.driver.getCurrentUrl().contains("amone")) {
			String amone_disclosure_infi = amone_siteaddress.replace("\r\n", "");
			if(siteAddress.equals(amone_disclosure_infi)) {
				System.out.println("PASS   : "+from+" siteaddress info matched");
				Logger.addTestStep(from+" siteaddress info matched", amone_disclosure_infi, "", "PASS");
			}else {
				System.out.println("FAIL   : "+from+" siteaddress info not matched.");
				Assert.assertEquals(siteAddress.replace("\r\n", ""), amone_disclosure_infi.replace("\r\n", ""));	
			}
		}
		if(DriverFactory.driver.getCurrentUrl().contains("guidetolenders") ||
				DriverFactory.driver.getCurrentUrl().contains("creditsesame")) {
			String amone_disclosure_infi = guidetolendor_siteaddress.replace("\r\n", "");
			if(siteAddress.equals(amone_disclosure_infi)) {
				System.out.println("PASS   : "+from+" siteaddress info matched");
				Logger.addTestStep(from+" siteaddress info matched", amone_disclosure_infi, "", "PASS");
			}else {
				System.out.println("FAIL   : "+from+" siteaddress info not matched.");
				Assert.assertEquals(siteAddress.replace("\r\n", ""), amone_disclosure_infi.replace("\r\n", ""));	
			}
		}

	}
	public static void validateDisclosureInfo(String from) {
		String actualDisclosure = DriverFactory.driver.findElement(By.id("disclaimer-info")).getText();
		actualDisclosure = actualDisclosure.replace("\n", "");
		if(DriverFactory.driver.getCurrentUrl().contains("amone")) {
			amone_disclosure_infi = amone_disclosure_infi.replace("\r\n", "");
			if(actualDisclosure.equals(amone_disclosure_infi)) {
				System.out.println("PASS   : "+from+" disclamer info matched");
				Logger.addTestStep(from+" disclamer info matched", amone_disclosure_infi, "", "PASS");
			}else {
				System.out.println("FAIL   : "+from+" disclaimier info not matched.");
				Logger.addTestStep(from+" disclamer not info matched", amone_disclosure_infi, actualDisclosure, "FAIL");

				Assert.assertEquals(actualDisclosure.replace("\n", ""), amone_disclosure_infi.replace("\r\n", ""));	
			}
		}
		if(DriverFactory.driver.getCurrentUrl().contains("guidetolenders")) {
			amone_disclosure_infi = guitolendor_disclosure_info.replace("\r\n", "");
			if(actualDisclosure.equals(amone_disclosure_infi)) {
				System.out.println("PASS   : "+from+" disclamer info matched");
				Logger.addTestStep(from+" disclamer info matched", amone_disclosure_infi, "", "PASS");
			}else {
				System.out.println("FAIL   : "+from+" disclaimier info not matched.");
				Logger.addTestStep(from+" disclamer not info matched", amone_disclosure_infi, actualDisclosure, "FAIL");

				Assert.assertEquals(actualDisclosure.replace("\r\n", ""), amone_disclosure_infi.replace("\r\n", ""));	
			}
		}
		if(DriverFactory.driver.getCurrentUrl().contains("creditsesame")) {
			amone_disclosure_infi = creditsesame_disclosre_info.replace("\r\n", "");
			if(actualDisclosure.equals(amone_disclosure_infi)) {
				System.out.println("PASS   : "+from+" disclamer info matched");
				Logger.addTestStep(from+" disclamer info matched", amone_disclosure_infi, "", "PASS");
			}else {
				System.out.println("FAIL   : "+from+" disclaimier info not matched.");
				Logger.addTestStep(from+" disclamer not info matched", amone_disclosure_infi, actualDisclosure, "FAIL");

				Assert.assertEquals(actualDisclosure.replace("\r\n", ""), amone_disclosure_infi.replace("\r\n", ""));	
			}
		}
	}




	public static void PersonalLoanForm(String LoanType, String valueToINput, String CreditRating, String EmploymentStatus, String Annualpretaxincome,
			String Home, String HowLong, String Zip, String Address, String FirstName, String LastName, String dateOfBith, String Area, String Phone, String Number,
			String SSNArea, String Group, String Numbers)
	{

		DriverFactory.driver.findElement(By.xpath("//div[@id='select_text']")).click();
		DriverFactory.driver.findElement(By.xpath("//a[text()='"+LoanType+"']")).click();	
		DriverFactory.addRuntimeValues("Loan Type:", LoanType);

	//	CustomWait.appWait(3);

		DriverFactory.driver.findElement(By.id("CashOut")).clear();
		DriverFactory.driver.findElement(By.id("CashOut")).sendKeys(valueToINput);

	//	CustomWait.appWait(2);

		DriverFactory.addRuntimeValues("How much cash would you like?:", valueToINput);
		DriverFactory.driver.findElement(By.id("submitButton")).click();
		validateDisclosure("Cash page ");
		//	"input[@value='Excellent']"
		DriverFactory.driver.findElement(By.xpath("//input[@value='"+CreditRating+"']")).click();
	//	CustomWait.appWait(2);
		DriverFactory.addRuntimeValues("What is your estimated credit rating?:", CreditRating);
		validateDisclosure("credit rating");
		DriverFactory.driver.findElement(By.xpath("//td[text()='"+EmploymentStatus+"']/input")).click();
	//	CustomWait.appWait(2);
		DriverFactory.addRuntimeValues("What is your current employment status?:", EmploymentStatus);
		validateDisclosure("employment status");

		DriverFactory.driver.findElement(By.id("Income")).sendKeys(Annualpretaxincome);
	//	CustomWait.appWait(2);
		DriverFactory.addRuntimeValues("What's your annual pre-tax income?:", Annualpretaxincome);
		DriverFactory.driver.findElement(By.id("submitButton")).click();
		validateDisclosure("pre-tax income");

		DriverFactory.driver.findElement(By.xpath("//td[text()='"+Home+"']/input")).click();
		CustomWait.appWait(2);
		DriverFactory.addRuntimeValues("Do you rent or own?:", Home);
		validateDisclosure("rent or own Home");

		DriverFactory.driver.findElement(By.xpath("//td[text()='"+HowLong+"']/input")).click();
		CustomWait.appWait(2);
		DriverFactory.addRuntimeValues("How long have you lived a this address?:", HowLong);
		validateDisclosure("lived in this address");

		DriverFactory.driver.findElement(By.id("TempPC")).sendKeys(Zip);
	//	CustomWait.appWait(2);
		DriverFactory.addRuntimeValues("what is your ZIP code?:", Zip);
		DriverFactory.driver.findElement(By.id("submitButton")).click();
		validateDisclosure("ZIP");
	//	CustomWait.appWait(2);
		DriverFactory.driver.findElement(By.id("S1")).sendKeys(Address);
		CustomWait.appWait(2);
		DriverFactory.driver.findElement(By.id("submitButton")).click();
		DriverFactory.addRuntimeValues("what is your street address?:", Address);
	//	CustomWait.appWait(2);
		validateDisclosure("street address");



		DriverFactory.driver.findElement(By.id("EM")).sendKeys(getRandomEmail(10));
		CustomWait.appWait(2);
		DriverFactory.driver.findElement(By.id("submitButton")).click();
		DriverFactory.addRuntimeValues("what is your email address?:", getRandomEmail(10));
		CustomWait.appWait(2);
		validateDisclosure("email address");
		DriverFactory.driver.findElement(By.id("FN")).sendKeys(FirstName);

		DriverFactory.driver.findElement(By.id("LN")).sendKeys(LastName);

		DriverFactory.driver.findElement(By.id("submitButton")).click();
		DriverFactory.addRuntimeValues("what is your First Name?:", FirstName);
		DriverFactory.addRuntimeValues("what is your Last Name?:", LastName);
		validateDisclosure("Name page");

		String dateOfBirthAr[] = dateOfBith.split("-");
		new Select(DriverFactory.driver.findElement(By.id("BirthMonth_Numeric"))).selectByVisibleText(dateOfBirthAr[0]);
		new Select(DriverFactory.driver.findElement(By.id("BirthDay_Numeric"))).selectByVisibleText(dateOfBirthAr[1]);
		new Select(DriverFactory.driver.findElement(By.id("BirthYear_Numeric"))).selectByVisibleText(dateOfBirthAr[2]);
		CustomWait.appWait(3);
		DriverFactory.driver.findElement(By.id("submitButton")).click();
		DriverFactory.addRuntimeValues("what is your Month of birth?:", dateOfBirthAr[0]);
		DriverFactory.addRuntimeValues("what is your Day of birth?:", dateOfBirthAr[1]);
		DriverFactory.addRuntimeValues("what is your Year of birth?:", dateOfBirthAr[2]);
		CustomWait.appWait(3);
		validateDisclosure("Data of Birth page");
		DriverFactory.driver.findElement(By.name("HP_AREA")).sendKeys(Area);
		DriverFactory.driver.findElement(By.name("HP_PREFIX")).sendKeys(Phone);
		DriverFactory.driver.findElement(By.name("HP_NUMBER")).sendKeys(Number);
		CustomWait.appWait(2);
		DriverFactory.driver.findElement(By.id("submitButton")).click();
		DriverFactory.addRuntimeValues("what is your Area number?:", Area);
		DriverFactory.addRuntimeValues("what is your Phone number?:", Phone);
		DriverFactory.addRuntimeValues("what is your number?:", Number);
		validateDisclosure("Phone number page");
		try {
			if(SSNArea.length() >0) {
				DriverFactory.driver.findElement(By.name("SSN_AREA")).sendKeys(SSNArea);
			}
			if(Group.length() >0) {
				DriverFactory.driver.findElement(By.name("SSN_GROUP")).sendKeys(Group);
			}
			if(Numbers.length() >0) {
				DriverFactory.driver.findElement(By.name("SSN_NUMBER")).sendKeys(Numbers);
			}

			validateDisclosureInfo("SSN Page");

			DriverFactory.driver.findElement(By.id("compareButton")).click();
		}catch(Exception e) {
			System.out.println("SSN Page not found so going forward");
		}
		CustomWait.appWait(7);
		String url = DriverFactory.driver.getCurrentUrl();

		// Here we need to check whether we have confirmation page and provide correct data
		if(url.contains("confirmation")) {
			DriverFactory.driver.findElement(By.id("FN")).clear();
			DriverFactory.driver.findElement(By.id("FN")).sendKeys("Test");

			DriverFactory.driver.findElement(By.id("LN")).clear();
			DriverFactory.driver.findElement(By.id("LN")).sendKeys("Test");
			//		
			//		Select day_sel = new Select(DriverFactory.driver.findElement(By.id("BirthMonth_Numeric")));
			//		day_sel.selectByValue("");
			//		
			//		Select day_mon = new Select(DriverFactory.driver.findElement(By.id("BirthDay_Numeric")));
			//		day_mon.selectByValue("");
			//		
			//		Select day_yr = new Select(DriverFactory.driver.findElement(By.id("BirthYear_Numeric")));
			//		day_yr.selectByValue("");

			DriverFactory.driver.findElement(By.id("S1")).clear();
			DriverFactory.driver.findElement(By.id("S1")).sendKeys("143,CAPSTON NAPA,CA");

			DriverFactory.driver.findElement(By.name("SSN_AREA")).clear();
			DriverFactory.driver.findElement(By.name("SSN_AREA")).sendKeys("111");

			DriverFactory.driver.findElement(By.name("SSN_GROUP")).clear();
			DriverFactory.driver.findElement(By.name("SSN_GROUP")).sendKeys("11");
			DriverFactory.driver.findElement(By.name("SSN_NUMBER")).clear();
			DriverFactory.driver.findElement(By.name("SSN_NUMBER")).sendKeys("1111");
			DriverFactory.driver.findElement(By.name("submitButton")).click();

			CustomWait.appWait(15	);
		}

		url = DriverFactory.driver.getCurrentUrl();
		String id = url.split("=")[1].split("#")[0];
		System.out.println(id);
		DriverFactory.addRuntimeValues("DCK Value =", id);

		DriverFactory.driver.findElement(By.id("applynowbtn")).click();

		for(String handle : DriverFactory.driver.getWindowHandles()) {
			DriverFactory.driver.switchTo().window(handle);
		}

		String sourceCode = DriverFactory.driver.getPageSource();
		String curl = DriverFactory.driver.getCurrentUrl();
		
		if(curl.equals("https://www.accrediteddebtrelief.com/landing-pages-personal-loan/quin-street/")) {
			Logger.addTestStep("Url Validation", "https://www.accrediteddebtrelief.com/landing-pages-personal-loan/quin-street/",curl, "PASS");
		}else {
			Logger.addTestStep("Url Validation", "https://www.accrediteddebtrelief.com/landing-pages-personal-loan/quin-street/",curl, "FAIL");

		}
		
		if(sourceCode.contains(">Accredited Debt Relief<")) {
			Logger.addTestStep("Text Validation", "Accredited Debt Relief","Accredited Debt Relief", "PASS");
		}else {
			Logger.addTestStep("Text Validation", "Accredited Debt Relief",sourceCode, "FAIL");
		}



	}	

	public static String getRandomEmail(int length) {
		String str= "Personalloan";

		String mail = "Personalloan";
		for(int i = 0 ;i < length ;i++) {
			int index = new Random().nextInt(str.length());
			mail = mail + String.valueOf(str.charAt(index));
		}
		return mail+"@amone.com";
	}



	public  static void searchIn()
	{
		DriverFactory.initiateDriver();
		//		DriverFactory.driver.get("http://leadanalyzer-stage.quinstreet.net/");
		//		DriverFactory.driver.get("http://leadanalyzer.quinstreet.net/");
		DriverFactory.driver.get("http://leadanalyzer.jbosstest.dms.quinstreet.net/");

		DriverFactory.driver.findElement(By.name("userName")).sendKeys("pnomula");
		DriverFactory.driver.findElement(By.name("password")).sendKeys("Laptop@123");
		DriverFactory.driver.findElement(By.id("logonButton")).click();
		CustomWait.appWait(5);
		DriverFactory.driver.findElement(By.xpath("//a[text()='Key']")).click();
		CustomWait.appWait(5);

		Select sel = new Select(DriverFactory.driver.findElements(By.name("database")).get(1));

		sel.selectByVisibleText("LCD");
		CustomWait.appWait(5);
		DriverFactory.driver.findElement(By.name("DCK Value")).sendKeys(DriverFactory.applicationMap.get("DCK Value"));

		DriverFactory.driver.findElement(By.id("keySearchButton")).click();
		CustomWait.appWait(5);

		DriverFactory.driver.findElement(By.xpath("//a[text()='"+DriverFactory.applicationMap.get("DCK Value")+"']")).click();
		CustomWait.appWait(5);
	}






}
