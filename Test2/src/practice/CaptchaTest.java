package practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaptchaTest {

	private static final TimeUnit SECONDS = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/selenium jars/chromedriver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("loginText")).click();
		File src=driver.findElement(By.id("captchaImg")).getScreenshotAs(OutputType.FILE);
		
		
		//Thread.sleep(6000);
		Wait wait1=new FluentWait(driver).withTimeout(30, SECONDS).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);
		
			
	
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("captchaImg")));
		
		File src=driver.findElement(By.id("captchaImg")).getScreenshotAs(OutputType.FILE);
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/captcha.png";
		FileHandler.copy(src, new File(path));
		
		
		/*WebElement element = driver.findElement(By.id("captchaImg"));

		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = element.getLocation();

		// Get width and height of the element
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		//File screenshotLocation = new File("C:\\images\\GoogleLogo_screenshot.png");
		//FileUtils.copyFile(screenshot, screenshotLocation);
		File screenshotLocation = new File("C:\\Rahul\\Test2\\screenshots\\captcha.png");
		FileHandler.copy(screenshot, screenshotLocation);
		*/
		
	}

}
