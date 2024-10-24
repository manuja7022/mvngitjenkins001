package seleniumScripts;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropBrowser
{
	@Test
	public void browser() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		
		Point p=new Point(200,300);
		Thread.sleep(5000);
		driver.manage().window().setPosition(p);
		
		
		
	}

}
