/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.factory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.report.Logger;
import org.testng.asserts.SoftAssert;

public class DriverFactory {
	public static WebDriver driver =null;
	public static String browserType = "CHROME";
	//public static String browserType = "MOZILLA";
	//public static String browserType = "EDGE";
	public static Map<String,String> applicationMap = new HashMap<String,String>();
	public static SoftAssert softAssert = null;
	public static void addRuntimeValues(String key, String value) {
		if(!applicationMap.containsKey(key)	) {
		applicationMap.put(key, value);
		Logger.log(key+  " -> "+ value);
		Logger.addTestStep("input "+ key+" value ", value, value, "PASS");
		}
	}
	public static void changeMobileView(int...i) {
		try {
			Thread.currentThread().sleep(2000);
		}catch(Exception e) {
			
		}
		
		try {
			if(i.length>0) {
				Robot rbt = new Robot();
				rbt.keyPress(KeyEvent.VK_CONTROL);
				rbt.keyPress(KeyEvent.VK_SHIFT);
				rbt.keyPress(KeyEvent.VK_I);
				
				rbt.keyRelease(KeyEvent.VK_I);
				rbt.keyRelease(KeyEvent.VK_CONTROL);
				rbt.keyRelease(KeyEvent.VK_SHIFT);
				return ;
			}
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_SHIFT);
		rbt.keyPress(KeyEvent.VK_I);
		
		rbt.keyRelease(KeyEvent.VK_I);
		rbt.keyRelease(KeyEvent.VK_SHIFT);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		try {
			Thread.currentThread().sleep(5000);
		}catch(Exception e) {
			
		}
		
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_SHIFT);
		rbt.keyPress(KeyEvent.VK_M);
		
		rbt.keyRelease(KeyEvent.VK_M);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_SHIFT);
		
		}catch(Exception e) {
			
		}
		try {
			Thread.currentThread().sleep(3000);
		}catch(Exception e) {
			
		}
	}
	
	public static void performJsClick() {
		
	}
	
	public static void updateRuntimeValues(String key, String value) {
		applicationMap.put(key, value);
		Logger.log(key+  " -> "+ value);
	}
	public static void readyForTestCase() {
		DriverFactory.applicationMap = null;
		DriverFactory.applicationMap = new HashMap<String, String>();
		
		DriverFactory.softAssert = new SoftAssert();
	}
	public static void initiateDriver() {
		switch(browserType) {
		case "CHROME":
		case "GOOGLECHROME":
		case "GOOGLE CHROME":
			
			System.setProperty("webdriver.chrome.driver", "C:/selenium jars/chromedriver/chromedriver.exe");
			try {
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Logger.log("Chrome Driver Opened d");
			}catch(Exception e) {
				e.printStackTrace();
				Logger.error(e.toString());
			}
			
			break;
case "EDGE":
			
			System.setProperty("webdriver.edge.driver", "C:\\ProgramData\\jars\\drivers\\edge\\MicrosoftWebDriver.exe");
			try {
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Logger.log("Chrome Driver Opened d");
			}catch(Exception e) {
				e.printStackTrace();
				Logger.error(e.toString());
			}
			
			break;
		case "MOZILLA":
			System.setProperty("webdriver.gecko.driver", "C:\\ProgramData\\jars\\drivers\\mozilla\\geckodriver-v0.19.1-win32\\geckodriver.exe");
			try {
			driver = new FirefoxDriver(); 
					driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Logger.log("Chrome Driver Opened d");
			}catch(Exception e) {
				e.printStackTrace();
				Logger.error(e.toString());
			}
	
		}
	}
	
	public static void quitDriver() {
		if(driver != null) {
			Logger.log("Driver Closing..");
		//driver.close();
		//driver.quit();
		Logger.log("Driver Closed");
		}
	}
}
