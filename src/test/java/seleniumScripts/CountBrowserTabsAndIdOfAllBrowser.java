package seleniumScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountBrowserTabsAndIdOfAllBrowser 
{
	//body.sendKeys(Keys.PAGE_DOWN);  // Scroll down the page

	@Test
	public void countOfAllBrowser()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.in");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");

		Set<String> set = driver.getWindowHandles();

		System.out.println(set.size()+"<========== count of broswer");
		for (String string : set) 
		{
			System.out.println(string);

		}


	}

}
