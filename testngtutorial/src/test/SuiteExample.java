package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SuiteExample {
	WebDriver driver;
	long starttime;
	long endtime;
	
	@BeforeSuite   //suite is collection of testcases
	public void launchBrowser()
	{
		 starttime=System.currentTimeMillis();
		   System.setProperty("webdriver.chrome.driver", "C:\\simon\\chromedriver.exe");
			
			 driver=new ChromeDriver();
		
	}
	@Test(priority=0)
	public void openGoogle()
	{
		
		driver.get("https://www.google.com");
		
	
	}
	
	@Test(priority=1)
	public void openBing()
	{
		driver.get("https://www.bing.com");
		
	}
	
	@Test(priority=2)
	public void openYahoo()
	{
      
		driver.get("https://in.yahoo.com");
	}
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
		endtime=System.currentTimeMillis();
		long totaltime=endtime-starttime;
		System.out.println("total time taken"+totaltime);
	}

}
