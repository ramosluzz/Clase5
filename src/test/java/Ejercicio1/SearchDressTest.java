package Ejercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Configuracion.Config;
import WaitSleep.StaticSleep;
import pages.Index;
import pages.Item;

public class SearchDressTest {

	WebDriver driver;
	StaticSleep stop = new StaticSleep();
	Index index;
	Item item;
	
	@BeforeClass
	public void pre()
	{
		System.out.println("INICIO");
	}
	
	@AfterClass
	public void post()
	{
		System.out.println("FIN");
	}
	
	@BeforeMethod
	public void inicio()
	{
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Config.url);
		stop.wait(3000);
		index = new Index(driver);
		item = new Item(driver);
	}

	@AfterMethod
	public void fin()
	{
		driver.close();
		driver.quit();
	}
	
	@Test (description = "Ejercicio1", enabled = false)
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
			e.printStackTrace();
		}
	}
	
	@Test(description="Ejercicio 1 - con PO", enabled = false)
	public void searchByTennis1()
	{
		index.SearchAndClickById("Tennis");
		Assert.assertEquals(index.TextResult(), "0 results have been found.");
		stop.wait(5000);
	}
	
	@Test (description = "Ejercicio 2 (PO) -  verificar el color del ARTICULO", enabled = true)
	public void searchByDressClickColor()
	{
		index.SearchAndClickById("Dress");
		index.ClickSelect("Price: Lowest first");
		item.ClickById();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		stop.wait(3000);
		String result = driver.findElement(By.id("color_14")).getAttribute("name");
		Assert.assertEquals(result, "Blue", "ARTICULO MAL SELECCIONADO");
		stop.wait(5000);
	}
}
