package seleniumScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseAndQuiteWithoutMethods 
{
	@Test
	 public void browser() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		Thread.sleep(3000);
		
		String processName = "firefox.exe";  // For Windows
        // String processName = "firefox";    // For Mac/Linux

        // Terminate the process using Runtime.getRuntime().exec()
        Runtime.getRuntime().exec("taskkill /F /IM " + "firefox.exe");

	}
}