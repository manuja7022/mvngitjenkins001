package seleniumScripts;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseSpecificBrowserUsingId
{

	@Test
	public void specific()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.in");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");

		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com'),'_blank');");

		Set<String> set = driver.getWindowHandles();

		ArrayList<String> list =new ArrayList(set); //This is called type casetint set to list
		
		
			driver.switchTo().window(list.get(2));
			String title = driver.getTitle();
			System.out.println(title);
			driver.close();
			
		
	}

}
