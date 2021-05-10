package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day3 {
	public WebDriver driver=null;
	
	@BeforeClass
	public void bc()
	{
		System.out.println("first in class");
	}
	
	@Test(groups= {"Smoke"})
	public void WebLoginCarLoan()
	{
		System.out.println("web");
		
	}
	@AfterClass
	public void ac()
	{
		System.out.println("last in class");
	}
	
	@Test
	public void Login() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\kishore\\eclipse-workspace\\testngtutorial\\src\\test\\datadriven.properties");
	
		prop.load(fis);
		//System.out.println(pro.getProperty("username"));
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\simon\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		
		driver.get(prop.getProperty("url"));
	}
	@BeforeMethod
	public void bm()
	{
		System.out.println("before every method");
	}
	@AfterMethod
	public void am()
	{
		System.out.println("after every method");
	}

	@Test(dataProvider="getData")
	public void MobileLoginCarLoan(String username,String password)
	{
		System.out.println("mobile");
		System.out.println(username);
		System.out.println(password);
		
	}
	
	@Test
	public void LoginApiCarLoan()
	{
		System.out.println("api");
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		//1st set
		data[0][0]="firstusername";
		data[0][1]="firstpassword";
		
		//2nd set
		data[1][0]="secondusername";
		data[1][1]="secondpassword";
		
		//3rd set
		data[2][0]="thirdusername";
		data[2][1]="thirdpassword";
		return data;
		
	}
	
}
