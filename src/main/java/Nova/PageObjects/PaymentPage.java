package Nova.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Nova.AbstractComponents.Abstract;

public class PaymentPage extends Abstract {

	WebDriver driver;
	public PaymentPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css = ".ta-results")
	WebElement w5;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement Con;
	
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')]) [2]")
	WebElement ind;
	
	
	
	@FindBy(css = ".hero-primary")
	WebElement w7;
	
	
	@FindBy(css = ".action__submit")
	WebElement Placeorder;
	
	@FindBy(css = ".hero-primary")
	WebElement sccessmsg;
	
	public void TypeTheCountry()
	{
		Actions a=new Actions(driver);
		a.sendKeys(Con, "India").build().perform();
		VisibilityOfWebElement(w5);
	}
	public void SelectCountry()
	{
		ind.click();
		Placeorder.click();
		VisibilityOfWebElement(w7);
	}
	public String ConfirmScreen()
	{
		String confirmMsg=sccessmsg.getText();
		return confirmMsg;
	}
	
	
	
}
