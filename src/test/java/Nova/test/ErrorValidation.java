package Nova.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Nova.PageObjects.CartPage;
import Nova.PageObjects.LandingPage;
import Nova.PageObjects.OrdersPage;
import Nova.PageObjects.PaymentPage;
import Nova.PageObjects.ProductCatlog;
import Nova.TestComponents.BaseTest;
import Nova.TestComponents.reTry;

public class ErrorValidation extends BaseTest
{
	public String item="ADIDAS ORIGINAL";

	@Test(retryAnalyzer = reTry.class)
	public void LoginErrorDetails() throws InterruptedException
	{
		ProductCatlog productcatlog=landingpage.LoginDetails("dharanidhar220@gmail.com1", "Ilovecricket@123");
		String errorpopup=landingpage.ErrorDetails();
		Assert.assertEquals(errorpopup, "Incorrect email or password.");
	}
	@Test
	public void ProductErrorDetails() throws InterruptedException
	{
		ProductCatlog productcatlog=landingpage.LoginDetails("dharanidhar220@gmail.com", "Ilovecricket@123");
		List<WebElement> product=productcatlog.GetProducts();
		productcatlog.AddProductToCart(item);
		CartPage cartpage=productcatlog.GotoCartPage();
		boolean match=cartpage.ValidateCartDetails("ZARA COAT ##");
		Assert.assertFalse(match);
	}
}
