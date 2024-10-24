package seleniumScripts;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAndHardAssertion 
{
	@Test
	public void assertion() throws Exception

	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.in");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");

		Set<String> set = driver.getWindowHandles();
		String parenttitle = "ghchgfjgkuhiugyftdrfhg";// even we are passing wrong title soft assert is passed not stop the execution
		//driver.getWindowHandle();


		System.out.println(set.size()+"<========== count of broswer");

		for (String string : set) 
		{

			driver.switchTo().window(string);
			String title = driver.getTitle();
			Thread.sleep(5000);
			System.out.println(title);
			Thread.sleep(5000);

			System.out.println("soft assett starts");
			SoftAssert soft =new SoftAssert();
			soft.assertEquals(title, parenttitle);

			System.out.println("soft assett Ends");

			if(parenttitle.contains(title))
			{
				System.out.println("title is passed");
			}
			driver.close();
			Thread.sleep(5000);
			soft .assertAll(); //to report failure scripts or lines it is mandatory to mentions this method at last 
		}
	}
	@Test
	public void hardAssertion() throws Exception

	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.in");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com', '_blank');");

		Set<String> set = driver.getWindowHandles();
		String parenttitle = driver.getWindowHandle();// even we are passing wrong title soft assert is passed not stop the execution
		String parenttitles = driver.switchTo().window(parenttitle).getTitle();


		System.out.println(set.size()+"<========== count of broswer");

		for (String string : set) 
		{

			driver.switchTo().window(string);
			String title = driver.getTitle();
			Thread.sleep(5000);
			System.out.println(title);
			Thread.sleep(5000);

			Assert.assertEquals(title, parenttitles);


			System.out.println("title is passed");

			driver.close();
			Thread.sleep(5000);

		}
	}
}
