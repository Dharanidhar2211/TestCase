package Nova.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Nova.AbstractComponents.Abstract;

public class ProductCatlog extends Abstract{

	WebDriver driver;
	public ProductCatlog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(css = ".mb-3")
	WebElement w1;
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	
	@FindBy(xpath = "//div[text()=' Product Added To Cart ']")
	WebElement w2;
	
	
	@FindBy(css = ".ng-animating")
	WebElement w3;
	
	
	public List<WebElement> GetProducts()
	{
		VisibilityOfWebElement(w1);
		return products;	
	}
	public WebElement GetProduct(String item)
	{
		WebElement prod=GetProducts().stream().filter(s->s.findElement(By.tagName("b")).getText().equals(item)).findFirst().orElse(null);
		return prod;
	}
	public WebElement AddProductToCart(String item)
	{
		WebElement prod=GetProduct(item).findElement(By.cssSelector(".card-body button:last-of-type"));
		prod.click();
		return prod;	
	}
	public CartPage GotoCartPage() throws InterruptedException
	{
		VisibilityOfWebElement(w2);
		InVisibilityOfWebElement(w3);
		ClickOnCart();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	
}
