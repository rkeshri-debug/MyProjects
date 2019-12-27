/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.report;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.factory.DriverFactory;

public class Logger {
	private static String reportString = "";
	private static int totalTestCase = 0;
	private static int totalTestStep = 0;
	private static int totalPass = 0;
	private static int totalFail = 0;
	private static long testcaseStartTime = 0;
	private static long testcaseEndTime = 0;
	private static long testSuiteTotalTime = 0;
	private static String startDate = null;
	public static void log(String content){
		System.out.println("INFO  : " + content);
	}
	public static void pass(String content){
		System.out.println("PASS  : "+content);
		addTestStep(content,"-","-","PASS");
	}
	public static void fail(String content){
		System.out.println("FAIL  : "+content);
		DriverFactory.softAssert.assertTrue(false,content);
		addTestStep(content,"-","-","FAIL");
	}
	
	public static void error(String content){
		System.out.println("ERROR : " + content);
	}
	
	private static boolean testStatus = true;
	public static void addTestStep(String stepName, String expected, String actual , String status ) {
		totalTestStep++;
		//System.out.println(stepName + " " + expected + " " +status) ;
		stepName = stepName.replace("\"", "\\\"");
		expected = expected.replace("\"", "\\\"");
		actual = actual.replace("\"", "\\\"");
		String stepContent ="<tr style=\"background-color:#c7dec7;\"><td style=\"line-height:40px;\">"+totalTestStep+"</td><td>"
				+ "<b>"+stepName+"</b>"
				+ "</td><td>"+expected+"</td>"
				+ "<td>"+actual+"</td><td>"+status+"</td></tr><!--TESTSTEP-->";

		if(status.toUpperCase().trim().equals("FAIL")) {
			testStatus = false;
		}
		reportString = reportString.replace("<!--TESTSTEP-->", stepContent);
		//reportString = reportString + stepContent;
	}
	
	public static void addTestCase(String testcasename, String testdesc) {
		try {
			if(startDate == null) {
				startDate = new Date().toString();
			}
			System.out.println("adding TestCase");
			testStatus =true;
			testcaseStartTime = new Date().getTime();
			totalTestCase = totalTestCase +1;
		
		FileReader fr = new FileReader(new File("C:\\Automation\\FSQAAutomation\\GTLAmoneSesame\\Template\\template.txt"));
		BufferedReader br = new BufferedReader(fr);
		String temp = "";
		String ftext = "";
		while( (temp = br.readLine()) != null) {
			ftext  = ftext + temp;
		}
		br.close();fr.close();
		ftext = ftext.replace("<--TESTCASENAME-->", testcasename);
		ftext = ftext.replace("<--TESTCASEDESC-->", testdesc);
		ftext = ftext.replace("<--TESTSEQ-->", String.valueOf(totalTestCase));
		
		
		reportString = reportString + ftext;
	//	System.out.println("testcase" + reportString);
	}catch(Exception e) {
		e.printStackTrace();
	}
		}
	
	
	public static void finshtestCase() {
		System.out.println("Finishing TestCase");
		testcaseEndTime = new Date().getTime();
	//	System.out.println("Timem atken  " + (testcaseEndTime-testcaseStartTime));
		long timetken = ((testcaseEndTime-testcaseStartTime)/1000);
		testSuiteTotalTime += timetken;
		reportString = reportString.replace("<!--TESTSTEP-->", "");
		if(testStatus == false) {
			
			reportString = reportString.replace("<--FAILPASS-->", "#e0b08f");
			reportString = reportString.replace("<--TESTSTATUS-->", "FAIL");
			totalFail =  totalFail +1;
		}else {
			
			reportString = reportString.replace("<--FAILPASS-->", "#8fe08f;");
			reportString = reportString.replace("<--TESTSTATUS-->", "PASS");
			totalPass =  totalPass +1;
		}
		reportString = reportString.replace("<--TIMETAKEN-->", String.valueOf(timetken)+" Secs");
		totalTestStep= 0;
	}

	
	public static void  finishSuite() {
System.out.println("Finish Suite");
		try {
		FileReader fr = new FileReader(new File("C:\\Automation\\FSQAAutomation\\GTLAmoneSesame\\Template\\report.html"));
		BufferedReader br = new BufferedReader(fr);
		String temp = "";
		String ftext = "";
		while( (temp = br.readLine()) != null) {
			ftext  = ftext + temp;
		}
		br.close();fr.close();
		//reportString = reportString + ftext;
		
	//	System.out.println(ftext);
	//	System.out.println(reportString);
		ftext = ftext.replace("<!--TESTCASES-->", reportString);
		ftext = ftext.replace("<--TOTAL-->", String.valueOf((totalFail+totalPass)));
		ftext = ftext.replace("<--PASS-->", String.valueOf(totalPass));
		ftext = ftext.replace("<--FAIL-->", String.valueOf(totalFail));
		ftext = ftext.replace("<--STARTTIME-->", String.valueOf(startDate));		
		ftext = ftext.replace("<--ENDTIME-->", String.valueOf(new Date().toString()));
		ftext = ftext.replace("<--TOTALTIME-->", String.valueOf(testSuiteTotalTime) + " Secs");
		ftext = ftext.replace("<--MACHINE-->", getmachienName());
		ftext = ftext.replace("<--USERNAME-->", System.getProperty("user.name"));
		
		FileWriter fw = new FileWriter(new File("C:\\Automation\\FSQAAutomation\\GTLAmoneSesame\\Result\\emailable-Report.html"));
		fw.write(ftext);
		fw.close();
		System.out.println("Report Create  : " + "C:\\Automation\\FSQAAutomation\\GTLAmoneSesame\\Result\\emailable-Report.html");
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	public static String getmachienName() {
		String hostname = "Unknown";

		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    return hostname;
		}
		catch (UnknownHostException ex)
		{
		    System.out.println("Hostname can not be resolved");
		    return "Unknown";
		}
	}
}
