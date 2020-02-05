package Ejercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void inicio()
	{
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void fin()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void searchByTennis()
	{
		driver.findElement(By.id("search_query_top")).sendKeys("Tennis");
		driver.findElement(By.name("submit_search")).click();
		String textResult = driver.findElement(By.className("heading-counter")).getText();
		System.out.println(textResult);
		Assert.assertEquals(textResult, "0 results have been found.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
