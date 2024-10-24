package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HieghtAndWidth
{
	@Test
	public void title() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		WebElement ele =driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']"));
		
		 int size = ele.getSize().getHeight();
		int size1 = ele.getSize().getWidth();
		

	}

}
