package Nova.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nova.AbstractComponents.Abstract;

public class OrdersPage extends Abstract{

	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> product;
	
	public String OrderDetails()
	{
		ClickOnOrderspage();
		String ProductName=product.get(0).getText();
		return ProductName;
		
	}
	
	
}
