package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CICDesktop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
      System.setProperty("webdriver.chrome.driver", "C:/chrome driver/chromedriver.exe");
      WebDriver driver;
      driver =new ChromeDriver();
      driver.get("http://quotes.carinsurance.com.quinlampstage.com");
      driver.manage().window().maximize();
      Thread.sleep(2000);
    
      //driver.close();
	}

}
