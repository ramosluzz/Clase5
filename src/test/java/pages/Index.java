package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Index {
	private WebDriver driver;
	private By search;
	private By submit;
	private By heading;
	private By iconList;
	private By selectProduc;
	public Index (WebDriver driver)
	{
		this.driver = driver;
		search  =By.id ("search_query_top");
		submit = By.name("submit_search");
		heading = By.className("heading-counter");
		iconList =By.className("icon-th-list");
		selectProduc = By.id("selectProductSort");
	}
	public void SearchAndClickById(String value)
	{
		driver.findElement(search).sendKeys(value);
		driver.findElement(submit).click();
	}
	public void ClickSelect(String value)
	{
		driver.findElement(iconList).click();
		Select order = new Select(driver.findElement(selectProduc));
		order.selectByVisibleText(value);
	}
	public String TextResult()
	{
		return driver.findElement(heading).getText();
	}
}
