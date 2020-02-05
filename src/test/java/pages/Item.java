package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Item {

	private WebDriver driver;
	private By color;
	
	public Item(WebDriver driver)
	{
		this.driver = driver;
		color = By.id("color_2");
	}
	public void ClickById()
	{
		driver.findElement(color).click();
	}
	
	
}
