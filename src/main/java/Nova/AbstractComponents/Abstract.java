package Nova.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Nova.PageObjects.OrdersPage;

public class Abstract {

	WebDriver driver;
	public Abstract(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderspage;
	
	public OrdersPage ClickOnOrderspage()
	{
		orderspage.click();
		OrdersPage orderspage=new OrdersPage(driver);
		return orderspage;
	}
	
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	
	public void VisibilityOfWebElement(WebElement Wait1)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Wait1));
	}
	public void InVisibilityOfWebElement(WebElement Wait2) throws InterruptedException
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(Wait2));
		Thread.sleep(1000);
	}
	public void ClickOnCart()
	{
		cart.click();
	}

}
