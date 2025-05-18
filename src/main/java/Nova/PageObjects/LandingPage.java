package Nova.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nova.AbstractComponents.Abstract;

public class LandingPage extends Abstract
{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(css = "#userEmail")
	WebElement mail;
	
	@FindBy(id = "userPassword")
	WebElement pass;
	
	@FindBy(xpath = "//input[contains(@type,'submit')]")
	WebElement submit;
	
	@FindBy(css = "[aria-label='Incorrect email or password.']")
	WebElement error;
	
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public ProductCatlog LoginDetails(String email,String password)
	{
		mail.sendKeys(email);
		pass.sendKeys(password);
		submit.click();
		ProductCatlog productcatlog=new ProductCatlog(driver);
		return productcatlog;
	}
	public String ErrorDetails()
	{
		String errorpopup=error.getText();
		return errorpopup;
	}

}
