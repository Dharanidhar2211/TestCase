package Nova.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Nova.AbstractComponents.Abstract;

public class CartPage extends Abstract {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	
	@FindBy(css = "div h1")
	WebElement w4;
	
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;
	
	
	@FindBy(css = ".cartSection h3")
	List<WebDriver> cproducts;
	
	
	public boolean ValidateCartDetails(String item)
	{
		VisibilityOfWebElement(w4);
		List<WebElement> cproducts=driver.findElements(By.cssSelector(".cartSection h3"));
		boolean b=cproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		return b;
	}
	public PaymentPage ClickOnCheckOut()
	{
		checkout.click();
		PaymentPage paymentpage=new PaymentPage(driver);
		return paymentpage;
	}
	
	
}
