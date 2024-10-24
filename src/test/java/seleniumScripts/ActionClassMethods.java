package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassMethods 
{
	@Test
	public void title() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		WebElement ele =driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']"));
		
		//move to element
		Actions a=new Actions(driver);
		a.moveToElement(ele).click().perform();
	
		//double click
		a.doubleClick().perform();
		
		//right click or context click
		a.contextClick().perform();
		
		//dragnad drop
		a.dragAndDrop(ele, ele).perform();
	}

}
