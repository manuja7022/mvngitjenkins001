package seleniumScripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUps 
{

	//if we try to give alert and dismiss method to single poppup will get No Alert Pressent Exception

	@Test
	public void alertPopup() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		WebElement ele =driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		//ele.click();

		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ele);
		//CODE TO HANDLE CONFIRM POPUP
		driver.switchTo().alert().dismiss();

	}
	@Test
	public void confirmationPopup() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		WebElement ele =driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		//ele.click();

		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ele);
		//CODE TO HANDLE CONFIRM POPUP
		driver.switchTo().alert().accept();

	}
	@Test
	public void fetchTextFromAlertPopup() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		WebElement ele =driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		//ele.click();

		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ele);
		//CODE TO HANDLE CONFIRM POPUP
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();

		System.out.println(text);

	}

	@Test
	public void hiddenDivisionPopup() throws Exception
	{
		//hidden division popup we can handle using findElement()
		//developer will use div tag for hidden disvision popup


	}

	@Test
	public void fileUploadPopup() throws Exception
	{
		//file upload popup we can handle using sendkeys()
		//Inside sendkeys we need to pass path of file


	}

	@Test
	public void fileDownloadPopup() throws Exception
	{
		//file Download popup we can handle using Robot class

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		WebElement ele =driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));

		Robot rob=new Robot();

		rob.keyPress(KeyEvent.VK_LEFT);
		rob.keyPress(KeyEvent.VK_LEFT);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyPress(KeyEvent.VK_ENTER);
	}

	@Test
	public void childBrowserPopup() throws Exception
	{
		//child browser  popup we can handle using getWindDowHandle() and getWindDowHandles() method

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		String idOfBrowser = driver.getWindowHandle();	
		System.out.println(idOfBrowser);
		
		
		//TO SWICTH THE CONTROL FROM ONE TAB TO ANOTHER TAB WE USE
		driver.switchTo().window(idOfBrowser);
		                           
		                           
	}
}
