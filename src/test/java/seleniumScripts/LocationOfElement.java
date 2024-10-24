package seleniumScripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocationOfElement
{
	@Test
	public void title() throws Exception
	{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.amazon.in");
	
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     Date d=new Date();
	    System.out.println( d.toString());
	    
	   String forma = dateFormat.format(d).replace("-", ":");
	    
	    System.out.println(dateFormat.format(d).replace("-", ":"));
	WebElement ele =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

	Point loc = ele.getLocation();
	int x = loc.getX();
	int y = loc.getY();
	System.out.println(x+"======>");
	System.out.println(y+"======>");

	}
}
