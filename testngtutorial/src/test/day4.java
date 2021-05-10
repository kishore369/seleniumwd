package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 
{
	@Parameters({ "URL","password" })
	@Test
	public void WebLoginHomeLoan(String url,String password)
	{
		System.out.println("Hweb");
		System.out.println(url);
		System.out.println(password);
	}
	
	@Test(groups= {"Smoke"})
	public void MobileLoginHomeLoan()
	{
		System.out.println("Hmobile");
	}
	@Test(timeOut=4000)
	public void MobileSigninHomeLoan()
	{
		System.out.println("Hmobilesignin");
	}
	@Test(enabled=false)
	public void MobileSignupHomeLoan()
	{
		System.out.println("Hmobilesignup");
	}
	@Test(dependsOnMethods= {"MobileSigninHomeLoan","MobileSignupHomeLoan"})
	public void LoginApiHomeLoan()
	{
		System.out.println("Hapi");
	}

}
