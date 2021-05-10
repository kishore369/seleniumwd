package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 
{
	@Parameters({ "URL" })     
	@Test(groups= {"Smoke"})
	public void Ploan(String url)
	{
		System.out.println("given");
		System.out.println(url);
	}

}
