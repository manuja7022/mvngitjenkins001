package seleniumScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintLinksInReversOrder 
{
	@Test
	public void browse() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		
		List<WebElement> links = driver.findElements(By.xpath("//link"));
		
		for (int i = links.size()-1; i >=0 ; i--) 
		{
			System.out.println(links.get(i));
			
		}

	}
}
