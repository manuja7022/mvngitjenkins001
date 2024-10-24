package seleniumScripts;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchAllTitleBrowserAndCloseOneByOne 
{
	@Test
	public void countOfAllBrowser() throws Exception
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

			driver.switchTo().window(string);
			String title = driver.getTitle();
			Thread.sleep(5000);
			System.out.println(title);
			Thread.sleep(5000);

			driver.close();
			Thread.sleep(5000);

		}
	}
}
