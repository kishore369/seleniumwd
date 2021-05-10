package test;

import org.testng.annotations.Test;

public class MultipleRun {
	
	
	@Test(invocationCount=3)  //to run method multiple times
	public void data()
	{
		System.out.println("kishore");
	}
	
	//@Test(timeOut=3000,expectedExceptions=ArrayIndexOutOfBoundsException.class)  //to run test when exception raised
	public void test() throws InterruptedException
	{
		Thread.sleep(4000);
		System.out.println("duckling");
	}
	
	
	//depends on methods
	//@Test(timeOut=2000)
	public void parentspermission() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("permissiongiven");
	}
	
	//@Test(dependsOnMethods= {"parentspermission"},alwaysRun=true)
	public void lovemarriage()
	{
		System.out.println("marriagehappened");
	}

}
