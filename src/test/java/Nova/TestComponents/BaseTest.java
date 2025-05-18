package Nova.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Nova.PageObjects.LandingPage;

public class BaseTest 
{
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver InitinilizeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Nova\\resources\\Global.properties");
		prop.load(fis);
		String BrowserName=prop.getProperty("ChromeBrowser");
		if(BrowserName.contains("chrome"))
		{
			 driver =new ChromeDriver();
		}
		else if (BrowserName.contains("edge"))
		{
			 driver =new EdgeDriver();
		}
		else if (BrowserName.contains("firefox"))
		{
			 driver =new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> GetJsonData(String path) throws IOException
	{
		//Json to strinh
		String jsondata=FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsondata, new TypeReference<List<HashMap<String,String>>>() {});
		return data;
	}
	public String GetScreenShot(String TestCaseName,WebDriver driver) throws IOException
	{
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"//reports//"+TestCaseName+".png"));
		return System.getProperty("user.dir")+"//reports//"+TestCaseName+".png";
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void LaunchDriver() throws IOException
	{
		driver=InitinilizeDriver();
		landingpage=new LandingPage(driver);
		landingpage.GoTo();	
	}
	@AfterMethod(alwaysRun = true)
	public void EndTest()
	{
		driver.close();
	}

}
