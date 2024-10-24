package seleniumScripts;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeTheBrowser
{
	@Test
	public void browse() throws Exception
	{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.amazon.in");
	
	Dimension d=new Dimension(200,300);
	Thread.sleep(5000);
	driver.manage().window().setSize(d);
	
	}
}
