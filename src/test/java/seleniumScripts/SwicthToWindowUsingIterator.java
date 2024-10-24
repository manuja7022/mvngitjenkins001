package seleniumScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwicthToWindowUsingIterator 
{
	@Test
	public void title(String partialWindowTitle) throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");

		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> iterator = allwindow.iterator();

		while(iterator.hasNext())
		{
			String win = iterator.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();

			if(title.contains(partialWindowTitle))
			{
				break;
			}
		}


	}

}
