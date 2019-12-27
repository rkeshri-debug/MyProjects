/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.module;

import org.factory.CustomWait;
import org.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.report.Logger;

public class Validation {
	
	public static void validateSrc(String respnse) {
		CustomWait.appWait(5);
		System.out.println("Response : " + respnse);
		System.out.println("searching : " + "\"ni_ad_client\":\""+DriverFactory.applicationMap.get("SRC")+"\"");
	if(respnse.contains("\"ni_ad_client\":\""+DriverFactory.applicationMap.get("SRC")+"\"")) {
		Logger.pass("SRC Validated "+ DriverFactory.applicationMap.get("SRC"));
	}else {
		Logger.fail("SRC Validated "+ DriverFactory.applicationMap.get("SRC"));
	}
}
	
	
	public static void getni_dck(String respnse) {
		String ni_dck = "";
		String[] allsplits = respnse.split(",");
		for(String split :allsplits) {
			if(split.contains("ni_dck")) {
				ni_dck = split.split(":")[1];
			}
		}
		ni_dck = ni_dck.replaceAll("\"", "");
		ni_dck = ni_dck.replaceAll("}", "");
		DriverFactory.addRuntimeValues("NIDCK", ni_dck);
	}	
	
	
	
	public static void validateAnalyser(String...validationNotInfos) {
		validateNidckPage("LoanPurpose");
		validateNidckPage("CashOut");
		validateNidckPage("Income");
		validateNidckPage("CreditRating");
		validateNidckPage("EmploymentStatus");
		validateNidckPage("BirthDate");
		validateNidckPage("Email");
		validateNidckPage("FirstName");
		validateNidckPage("LastName");
		validateNidckPage("HomePhone");
		validateNidckPage("PostalCode");
		validateNidckPage("Address1");
		validateNidckPage("City");
		validateNidckPage("State");
		validateNidckPage("OwnHome");
		validateNidckPage("TimeAtCurrentResidence");
		validateNidckPage("HomePhoneConsentLanguage");
		validateNidckPage("Source");
		validateNidckPage("AnyRecentIncidents"); 

			String v = String.valueOf(DriverFactory.applicationMap.get("VEHICLECOUNT").toString().length());
			DriverFactory.addRuntimeValues("VehicleCount", v);
			v = String.valueOf(DriverFactory.applicationMap.get("DRIVERCOUNT").toString().length());
			DriverFactory.addRuntimeValues("DriverCount", v);
			//validateNidckPage("IncidentCount");			
			validateNidckPage("DriverCount");			
			
			//validateNidckPageInXml("DriverInfo1XML",DriverFactory.applicationMap.get("LicenseStatus"),"LicenseStatus");
			//validateNidckPageInXml("DriverInfo1XML","id=\"1\"");
			
	//		validateNidckPageInXml("PriorPolicyInfoXML",DriverFactory.applicationMap.get("InsuranceCarrier"),"InsuranceCarrier");
		
			validateNidckPageInXml("CoveragesInfoXML",DriverFactory.applicationMap.get("OwnHome"),"OwnHome");
			boolean testrequired = true;
			for(String str : validationNotInfos) {
				if(str.equals("AccidentsInfoXML")) {
					testrequired =false;
				}
			}
			if(testrequired) {
			validateNidckPageInXml("AccidentsInfoXML",DriverFactory.applicationMap.get("IncidentAccidentDesc"),"IncidentAccidentDesc");
			}
	}
	public static void validateNidckPage(String tag, String...extra) {
		try {
		WebElement elem = DriverFactory.driver.findElement(By.xpath("//td[text()='"+tag+"']//following-sibling::td[2]"));
	String txt = elem.getText();
	String expected = "";
	
	if(extra.length >0) {
		expected = DriverFactory.applicationMap.get(tag+"1");
	}else {
		expected = DriverFactory.applicationMap.get(tag);
	}
	
	if(txt.equals(expected)) {
		Logger.pass(tag + " value matched as " + txt);
	}else {
		Logger.fail(tag + " value not matched as actual - " + txt + " expeceted"+expected);
	}
		}catch(Exception e) {
			Logger.fail( tag + " not found in analyser");
		}
	}
	
	public static void validateNidckPageInXml(String tag,String valueTSearch, String tagval) {
		try {
		WebElement elem = DriverFactory.driver.findElement(By.xpath("//td[text()='"+tag+"']//following-sibling::td[2]"));
	String txt = elem.getText();
	if(txt.contains(valueTSearch)) {
		Logger.pass(tagval + " value matched in xml as"+valueTSearch);
	}else {
		Logger.fail(tagval + " value not matched as actual - " + txt + " expeceted"+DriverFactory.applicationMap.get(valueTSearch));
	}
		}catch(Exception e) {
			Logger.fail( valueTSearch + " not found in analyser");
		}
	}
	

	
}
	
	
	
	
	

