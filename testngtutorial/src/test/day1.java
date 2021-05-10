package test;

import java.sql.Driver;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1
{
	
	@AfterTest
	public void ExecuteLast()
	{
		System.out.println("nota");
	}
	
    @Test
	public void Demo()
	{
		System.out.println("chanti");
		Assert.assertTrue(false);
	}
    @AfterSuite
    public void as()
    {
    	System.out.println("no one from last");
    }
    @BeforeTest
    public void ExecuteFirst()
    {
    	System.out.println("local");
    }
    @Test
    public void SecondTest()
    {
    	System.out.println("bye");
    
    }
	
	

	}


