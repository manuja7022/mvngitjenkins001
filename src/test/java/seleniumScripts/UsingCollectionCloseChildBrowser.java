package seleniumScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingCollectionCloseChildBrowser 
{
	@Test
	public void CloaseOnlyChildBrowser() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.in");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");

		String parentBrowserId = driver.getWindowHandle();

		System.out.println(parentBrowserId);

		Set<String> set = driver.getWindowHandles();

		set.remove(parentBrowserId);

		for (String string : set) 
		{
          driver.switchTo().window(string);
          Thread.sleep(2000);
          driver.close();
		}


	}}
