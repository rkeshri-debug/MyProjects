package practice;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Insure {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "C:/chrome driver/chromedriver.exe");
        WebDriver driver;
        driver=new ChromeDriver();
        //WebDriverWait wait=new WebDriverWait(driver,70);
        
        driver.get("http://autoinsurance.insure.com/autoquotes.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("PostalCode")).sendKeys("60001");
        //drop-down
        Select AgeRange= new Select(driver.findElement(By.id("user_age")));
        AgeRange.selectByValue("40");
        Thread.sleep(2000);
        Select Carriername=new Select(driver.findElement(By.xpath(".//*[@id='InsuranceCarrier']")));
        Carriername.selectByVisibleText("Progressive");
        driver.findElement(By.xpath(".//*[@id='homeowner-no']")).click();
        
        driver.findElement(By.id("demographic_submit")).click();
        Thread.sleep(2000);
        
        /* To close child tab */
        
        ArrayList<String> tabs2= new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        System.out.println(driver.getWindowHandle().length());
        Thread.sleep(2000);
        
        /* Vehicle Panel */
        driver.findElement(By.xpath(".//*[@id='panel-cols']/table/tbody/tr/td[1]/a[3]/div[text()='2016']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath(".//*[@id='panel-cols']/table/tbody/tr/td[2]/a[6]/div[text()='FORD']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='panel-cols']/table/tbody/tr/td[1]/a[3]/div[text()='EDGE']")).click();
        Thread.sleep(2000);
        
        
        
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("window.scrollBy(0,350)", "");
        
        /*Add 2nd vehicle */
        driver.findElement(By.xpath(".//*[@id='addAnotherCarLink']/div/a[text()='Add another vehicle']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='panel-cols']/table/tbody/tr/td[2]/a[1]/div[text()='2010']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='panel-cols']/table/tbody/tr/td[1]/a[2]/div[text()='AUDI']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='panel-cols']/table/tbody/tr/td[1]/a[4]/div[text()='A6']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("nextBtn")).click();
        driver.findElement(By.xpath(".//*[@id='nextBtnCarList']")).click();
        
        Thread.sleep(3000);
       /* Driver Panel */
       //driver 1
       driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][Name][FirstName]']")).sendKeys("test");
       driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][Name][LastName]']")).sendKeys("rahul");
       String date1="10031993";
       driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][BirthDate]']")).click();
       driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][BirthDate]']")).sendKeys(date1);
       
       //driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][BirthDate]']")).sendKeys(driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][BirthDate]']")).getAttribute("value").replace("MM","12").replace("DD", "30").replace("YYYY", "1992"));
       Select creditdrating=new Select(driver.findElement(By.id("CreditRating")));
       creditdrating.selectByVisibleText("Good");
       //System.out.println("Success");
     
       
       
       JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("window.scrollBy(0,350)", "");
       
       //System.out.println("Success");
       //WebDriverWait wait = new WebDriverWait(driver, 90);
   	   //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blocker")));
       //driver.findElement(By.xpath("//a[@onclick='addAnotherDriver();']")).getAttribute("onclick");
       
       //driver2
       
       driver.findElement(By.xpath("//*[@id='addAnotherDriverLink']/div/a[text()='Add another driver']")).click();
       //driver.findElement(By.linkText("Add another driver")).click();
       //driver.findElement(By.cssSelector("#addAnotherDriverLink > div.row > a.add-vehicle")).click();
       //System.out.println("Success");
       //Thread.sleep(7000);
       //driver.findElement(By.xpath(".//a[contains(text(),'Add another driver')]")).click();
       
       Thread.sleep(2000);
       driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][Name][FirstName]']")).sendKeys("test");
       driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][Name][LastName]']")).sendKeys("andrew");
       String date2="12071995";
       driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][BirthDate]']")).click();
       driver.findElement(By.xpath(".//*[@id='Driver[PersonalInfo][BirthDate]']")).sendKeys(date2);
       
      /* Incident */
       driver.findElement(By.xpath(".//*[@id='AnyRecentIncidents_slider']/input[2]")).click();
       Thread.sleep(2000);
       JavascriptExecutor jse = (JavascriptExecutor)driver;
       jse.executeScript("window.scrollBy(0,350)", "");
       
       /*Select incidenttype=new Select(driver.findElement(By.id("Driver[Incidents][0][IncidentType]")));
       incidenttype.selectByVisibleText("Violation: Speeding");
       
       Select incidentdate=new Select(driver.findElement(By.id("Driver[Incidents][0][IncidentDate]")));
       incidentdate.selectByVisibleText("In last 12 months");*/
       
       
       driver.findElement(By.id("nextBtnDriver")).click();
       Thread.sleep(5000);
       driver.findElement(By.id("nextBtnDriver")).click();
       
       /*Contact Details */
       
       driver.findElement(By.xpath(".//*[@id='EmailAddress']")).sendKeys("test123@gmail.com");
       Thread.sleep(3000);
       driver.findElement(By.xpath(".//*[@id='HP_AREA']")).sendKeys("812");
       driver.findElement(By.xpath(".//*[@id='HP_PREFIX']")).sendKeys("302");
       driver.findElement(By.xpath(".//*[@id='HP_NUMBER']")).sendKeys("5007");
       Thread.sleep(2000);
       driver.findElement(By.id("Address1")).sendKeys("5 high street");
       driver.findElement(By.xpath(".//*[@id='CrossSellHome_slider']/input[2]")).click();
       
       driver.findElement(By.id("nextBtnContact")).click();
       
   
       
      
	}

	

}
