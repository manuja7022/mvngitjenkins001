package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchFromOneFrameToOtherFrame 
{
	@Test
	public void frames() throws Exception
	{

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();

		driver.get("");
		Thread.sleep(3000);

		// Open the webpage
		driver.get("your_web_page_url");

		// Switch from Main Page to Parent Frame using frame ID, Name, or WebElement
		driver.switchTo().frame("parentFrame");

		// Now we are in the Parent Frame; switch to the Child Frame
		driver.switchTo().frame("childFrame");

		// Perform actions on elements inside the Child Frame
		WebElement targetElement = driver.findElement(By.tagName("p"));
		System.out.println("Element Text: " + targetElement.getText());

		// Return back to Parent Frame from Child Frame
		driver.switchTo().parentFrame();

		// Return back to Main Page from Parent Frame
		driver.switchTo().defaultContent();

		// Close the browser
		driver.quit();

	}

}
