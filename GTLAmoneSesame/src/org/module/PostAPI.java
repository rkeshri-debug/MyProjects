/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.module;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.factory.CustomWait;
import org.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.report.Logger;
import org.testcases.APIPost;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PostAPI {

	public static String postData = null;
	public static String responseData = null;
	
	public static void executeApi(String randomMail) {
		System.out.println("<-----------------------Post API ("+randomMail+")------------------------------>");
        try {
        	
        	
        	postData="{\"LoanPurpose\":\"Debt Consolidation\",\"CashOut\":\"49999\",\"Income\":\"1000000\",\"CreditRating\":\"Good\",\"EmploymentStatus\":\"7\",\"Dob\":\"01/01/1970\",\"Email\":\""+randomMail+"\",\"Fname\":\"JUDITH\",\"Lname\":\"ADAMS\",\"HomePhone\":\"6505786496\",\"PostalCode\":\"27606\",\"Street\":\"5205 DANA\",\"City\":\"RALEIGH\",\"State\":\"NC\",\"OwnHome\":\"Renter\",\"TimeAtResidence\":\"Less than 1 year.\",\"PhoneConsentLang\":\"TCPA Text\",\"SSN\":\"3269\",\"AFN\":\"prospeost_AM1_PL\",\"AF\":\"20306610\",\"getTYLink\":\"Yes\",\"SkipVerify\":\"Yes\",\"doTUping\":\"true\",\"dping\":\"yes\",\"social\":\"partial\"}\r\n" + 
        			"";
        	System.out.println("POST DATA :");
        	System.out.println(postData);
        	PostAPI hce = new PostAPI();
            responseData = hce.post("http://guidetolenders.test.quinstreet.net/plpost.jsp", postData);
            System.out.println("RESPONSE");
            System.out.println(responseData);
            
            Object obj = new JsonParser().parse(responseData);
            String status =   ((JsonObject)obj).get("Status").getAsString();
            
            Assert.assertEquals(status, "Success");
            System.out.println("Assertion Passed.");
            
           String dckValue =  responseData.substring(responseData.indexOf("dck")+6,responseData.indexOf("dck")+16);
            System.out.println("DCK-VALUE - " + dckValue);
            DriverFactory.addRuntimeValues("NIDCK", dckValue);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String post(String postUrl, String data) throws IOException {
        URL url = new URL(postUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Basic ZHJlZGR5:QnJzbm5yczY4Iw== Token MjAzMDY2MTA=");
        con.setRequestMethod("POST");
        
        con.setDoOutput(true);

        this.sendData(con, data);

        return this.read(con.getInputStream());
    }

    protected void sendData(HttpURLConnection con, String data) throws IOException {
        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(data);
            wr.flush();
            wr.close();
        } catch(IOException exception) {
            throw exception;
        } finally {
            this.closeQuietly(wr);
        }
    }

    private String read(InputStream is) throws IOException {
        BufferedReader in = null;
        String inputLine;
        StringBuilder body;
        try {
            in = new BufferedReader(new InputStreamReader(is));

            body = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                body.append(inputLine);
            }
            in.close();

            return body.toString();
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            this.closeQuietly(in);
        }
    }

    protected void closeQuietly(Closeable closeable) {
        try {
            if( closeable != null ) {
                closeable.close();
            }
        } catch(IOException ex) {

        }
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
		DriverFactory.driver.findElement(By.name("datacaptureKey")).sendKeys(DriverFactory.applicationMap.get("NIDCK"));

		DriverFactory.driver.findElement(By.id("keySearchButton")).click();
		CustomWait.appWait(5);

		DriverFactory.driver.findElement(By.xpath("//a[text()='"+DriverFactory.applicationMap.get("NIDCK")+"']")).click();
		CustomWait.appWait(5);
	}
	
	
	static SoftAssert verify = new SoftAssert();

	public static void validateAnalyser(String...validationNotInfos) {
		validateNidckPage("LoanPurpose");
		validateNidckPage("CashOut");
		validateNidckPage("Income");
		validateNidckPage("CreditRating");
		validateNidckPage("EmploymentStatus");
		validateNidckPage("Dob","BirthDate");
		validateNidckPage("Email");
		validateNidckPage("Fname","FirstName");
		validateNidckPage("Lname","LastName");
		validateNidckPage("HomePhone");
		validateNidckPage("PostalCode");
		validateNidckPage("Street","Address1");
		validateNidckPage("City");
		validateNidckPage("State");
		validateNidckPage("OwnHome");
		validateNidckPage("TimeAtResidence","TimeAtCurrentResidence");
		validateNidckPage("PhoneConsentLang","HomePhoneConsentLanguage");
		validateNidckPage("AFN","Source");

	//	DriverFactory.addRuntimeValues("TestVariation", "<CreditScoreAPI>TU</CreditScoreAPI> | <CreditScoreAPI>Set value in cache</CreditScoreAPI>");
		verify.assertEquals(getElementText("//td[text()='TestVariation']//following-sibling::td[2]"),
				"<CreditScoreAPI>TU</CreditScoreAPI> | <CreditScoreAPI>Set value in cache</CreditScoreAPI>");
		String value = getElementText("//td[text()='DebugInfo']//following-sibling::td[2]");
		verify.assertTrue(value.contains("| SSN present || MatchedVendorKeys-["));
		verify.assertTrue(value.contains("MatchedVendorKeysAfterDedupe-["));
		verify.assertTrue(value.contains("|| HostPostStatus:Success||"));
		
		String keyvalues = value.split("\\[")[1].split("\\]")[0];
		verify.assertTrue(keyvalues.trim().length() > 0 , "Key is null");
		
		String tuvalue = getElementText("//td[text()='TUResponse']//following-sibling::td[2]");
		verify.assertTrue(tuvalue.contains("<SSNEntered>Partial</SSNEntered>"));
		verify.assertTrue(tuvalue.contains("<FileHitIndicator>regularHit</FileHitIndicator>"));
		
		
		String psid = getElementText("//td[text()='PublisherSubID']//following-sibling::td[2]");
		verify.assertTrue(psid.trim().length() > 0 , "PublisherSubID - Attribute 186 is empty");
		verify.assertAll();
			
	}
	
	public static String getElementText(String xpath) {
		WebElement elem = null;
		elem =  DriverFactory.driver.findElement(By.xpath(xpath));
		String txt = elem.getText();
		return txt;
		
	}
	public static void validateNidckPage(String tag, String...extra) {
		try {
			Object obj = new JsonParser().parse(postData);
			DriverFactory.addRuntimeValues(tag, ((JsonObject)obj).get(tag).getAsString());
			String txt = null;
			if(extra.length>0) {
				txt = getElementText("//td[text()='"+extra[0]+"']//following-sibling::td[2]");
			}else {
				txt =  getElementText("//td[text()='"+tag+"']//following-sibling::td[2]");
			}
		 
	
	String expected = DriverFactory.applicationMap.get(tag);
	
	
	verify.assertEquals(txt, expected);
	if(txt.equals(expected)) {
		System.out.println("PASS - " + tag + " value matched as " + txt);
	}else {
		System.out.println("FAIL - " +tag + " value not matched as actual - " + txt + " expeceted"+expected);
	}
		}catch(Exception e) {
			System.out.println( tag + " not found in analyser");
		}
	}
	

}
