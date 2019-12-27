package testngdemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTestNGScript
{
    
	@BeforeClass
	private void beforeclass() {
	
           System.out.println("BeforeClass");
	}
	
	
	@Test(priority=1,description="This test case will verify login functionality")
	public void LoginApp()
	{
		System.out.println("Login to application");
	}
    
    
    @Test(priority=2,description="This test case will add items in bucket")
	public void SelectItems()
	{
		System.out.println("Items Selected");
	}
	
    @Test(priority=3,description="This will perform Checkout operation")
	public void CheckOut()
	{
		System.out.println("Checkout completed");
	}
    
    @AfterClass
	private void afterclass() {
    	
        System.out.println("afterclass");
	}
}
