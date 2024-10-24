package seleniumScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlePartialDynamicElement 
{
	@Test
	public void title()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		
		String title = driver.getTitle();
		
		//using contains we can handle Handle Partial Dynamic Element
		if(title.contains("Online Shopping site in India:"))
		{
			System.out.println("test case pass");
		}
		
	}

}
