package seleniumScripts;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MaximizeBrowser 
{
	@Test
	public void title() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().minimize();
		
		Dimension d=new Dimension(200,300);
		Thread.sleep(5000);
		driver.manage().window().setSize(d);
		
		driver.manage().window().maximize();
		WebElement ele =driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']"));

	}

}
