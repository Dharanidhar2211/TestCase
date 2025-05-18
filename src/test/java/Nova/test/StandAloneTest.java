package Nova.test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Nova.PageObjects.CartPage;
import Nova.PageObjects.LandingPage;
import Nova.PageObjects.OrdersPage;
import Nova.PageObjects.PaymentPage;
import Nova.PageObjects.ProductCatlog;
import Nova.TestComponents.BaseTest;

public class StandAloneTest extends BaseTest
{
	public String item="ADIDAS ORIGINAL";

	@Test(groups = "Purchase",dataProvider = "GetData")
	public void SubmitOrder(HashMap<String, String> input) throws InterruptedException
	{
		
		
		ProductCatlog productcatlog=landingpage.LoginDetails(input.get("email"), input.get("Password"));
		List<WebElement> product=productcatlog.GetProducts();
		productcatlog.AddProductToCart(input.get("item"));
		CartPage cartpage=	productcatlog.GotoCartPage();
		boolean match=cartpage.ValidateCartDetails(input.get("item"));
		Assert.assertTrue(match);
		PaymentPage paymentpage=cartpage.ClickOnCheckOut();
		paymentpage.TypeTheCountry();
		paymentpage.SelectCountry();
		String confirmMsg=paymentpage.ConfirmScreen();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));

	}
	@Test(dependsOnMethods = "SubmitOrder")
	public void OrderDetails()
	{
		ProductCatlog productcatlog=landingpage.LoginDetails("dharanidhar220@gmail.com", "Ilovecricket@123");
		OrdersPage orderspage=landingpage.ClickOnOrderspage();
		String ProductName=orderspage.OrderDetails();
		Assert.assertEquals(item,ProductName);
	}
	@DataProvider
	public Object[][] GetData() throws IOException
	{
		List<HashMap<String, String>> map=GetJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\Nova\\data\\Data.json");
		
		return new Object[][] {{map.get(0)},{map.get(1)}};
	}

}
