package test;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Streamsort {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\simon\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on coloumn
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all webelements into list
		List<WebElement> veg= driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new(original) list
		List<String> originallist=veg.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list
		List<String> sortedlist=originallist.stream().sorted().collect(Collectors.toList());
		
		//compare original and sorted list
		Assert.assertTrue(originallist.equals(sortedlist));
		List<String> price;
		do
		{
			List<WebElement> vegs= driver.findElements(By.xpath("//tr/td[1]"));
		 price= vegs.stream().filter(s->s.getText().contains("Rice")).
		 map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);

	}

	private static String getPriceVeggie(WebElement s) {
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
