package testngdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testngdemo.ListenersDemo.class)
public class MyfirstTestCase {
	
	@Test
	public void GoogleTitleVerify()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}
	
	@Test
	public void TitleMatch()
	{
		System.out.println("Test 2 dummy failed");
		Assert.assertTrue(false);
		
	}

}
