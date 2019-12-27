package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSite {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver1 = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver1.manage().window().maximize();
		System.out.println(driver.getWindowHandle());
		
		
		
		//driver.get("http://autoinsurance-insure-com.quinstage.com/autoquotes.html");
		driver.navigate().to("http://autoinsurance-insure-com.quinstage.com/autoquotes.html");
		driver.close();
		
		driver.findElement(By.id("demographic_submit")).sendKeys(Keys.ENTER);
		/*driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys(Keys.NUMPAD1);
		driver.findElement(By.name("q")).sendKeys(Keys.NUMPAD2);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);*/
		//driver.manage().getCookies();
		//System.out.println("Cokiees");
		//driver.getPageSource();
		//driver.close();
	}

}
