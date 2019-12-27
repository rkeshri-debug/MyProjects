package practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
		
		driver.findElement(By.name("username")).sendKeys("abc123");
		driver.findElement(By.name("password")).sendKeys("123xyz");	
		driver.findElement(By.name("submit")).click();
		
		//create file named Cookies to store login info
		
		File file=new File("Cookies.data");
		
		try{
		file.delete();
		
		file.createNewFile();
		FileWriter filewriter=new FileWriter(file);
		BufferedWriter Bwrite=new BufferedWriter(filewriter);
		
		//loop for getting cookie info
		
		for(Cookie ck: driver.manage().getCookies())
		{
			Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
			Bwrite.newLine();
		
		}
		
		Bwrite.close();
		filewriter.close();
	}

		catch(Exception ex)
		{
			ex.printStackTrace();
		}
}}
	
