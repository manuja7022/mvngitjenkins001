package seleniumScripts;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseOnlyParentBrowser
{
	
	@Test
	public void countOfAllBrowser() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.in");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");

		String parentBrowserId = driver.getWindowHandle();
		System.out.println(parentBrowserId);

		Set<String> set = driver.getWindowHandles();
		
		for (String string : set)
		{
			driver.switchTo().window(string);
			//String all_id = driver.getTitle();
			System.out.println(string);
			//Assert.assertEquals(parentBrowserId, all_id,"parent id not matched");
			if(string.equals(parentBrowserId))
			{
				Thread.sleep(5000);
				System.out.println("parent");
				driver.switchTo().window(parentBrowserId);

				driver.close();

			}
		}

	
}

}
