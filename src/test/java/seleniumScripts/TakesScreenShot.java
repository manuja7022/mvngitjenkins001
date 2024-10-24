package seleniumScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;

public class TakesScreenShot 
{
	
	@Test
	public void shot()
	{
		
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();

	driver.get("https://www.amazon.in");
	
	TakesScreenshot takes = (TakesScreenshot) driver;
    File src = takes.getScreenshotAs(OutputType.FILE);
    
    // Make sure the directory exists
    File dst = new File("C:\\Users\\User\\eclipseworkplace\\SeleniumFrameWork\\screenshot.png");
    
    try {
        FileUtils.copyFile(src, dst);
    } catch (IOException e) {
        e.printStackTrace();
    }
    driver.get("https://www.amazon.in");
	
	}
}
