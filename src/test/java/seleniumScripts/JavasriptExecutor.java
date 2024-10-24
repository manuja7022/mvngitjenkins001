package seleniumScripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavasriptExecutor 
{
	
	
	
	@Test(invocationCount = 3)//executes 3 times
	public void java() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();

		driver.get("https://www.google.com/maps");
		Thread.sleep(3000);
	}
	@Test(priority = 0)
	public void javaScript() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();

		driver.get("https://www.google.com/maps");
		Thread.sleep(3000);

		WebElement ele = driver.findElement(By.xpath("//input[@id='searchboxinput']"));

		JavascriptExecutor jse=(JavascriptExecutor) driver;

		jse.executeScript("arguments[0].click();", ele);
		jse.executeScript("arguments[0].value='banglore'", ele);

	}

	@Test(enabled = false) //wantedly skip 
	public void scrollToEndOfPage() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");

		JavascriptExecutor jse=(JavascriptExecutor) driver;
		//jse.executeScript("window.scrollBy(0,500)");

		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");


	}
	@Test(dependsOnMethods = " scrollToEndOfPage")
	public void scrollUptoElement() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");

		WebElement ele = driver.findElement(By.xpath("//a[text()='Careers']"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;

		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		jse.executeScript("arguments[0].scrollIntoView();", ele);

	}	
	@Test
	public void scrollUptoTopOfPaget() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in");

		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Careers']"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(3000);
		//jse.executeScript("window.scrollBy(0, 0);");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, -document.body.scrollHeight);");


	}
}









