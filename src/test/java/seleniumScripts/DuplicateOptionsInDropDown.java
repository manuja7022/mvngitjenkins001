package seleniumScripts;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DuplicateOptionsInDropDown 
{
	@Test

	public void duplicateOptionsInDropDown() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		//try {
		// Navigate to Wikipedia
		driver.get("https://www.wikipedia.org");

		// Find the dropdown element
		WebElement ele = driver.findElement(By.id("searchLanguage"));
		Select sc = new Select(ele);
		List<WebElement> options = sc.getOptions();

		String[] srr=new String[options.size()];


		for (WebElement string : options)
		{
			String value1=string.getText();

			for (int i = 0; i < options.size()-1; i++) 
			{
				value1=options.get(i).getText();
				srr[i]=value1;


			}

		}
		for (int i = 0; i < options.size()-1; i++)
		{
			System.out.println(srr[i]);
		}

		for (int k = 0; k < srr.length; k++) 
		{
			int count=0;
			for (int j = k+1; j < srr.length; j++)
			{
				if(srr[k].equals(srr[j]))
				{
					count++;
				}

			}

			if(count>1)
			{
				System.out.println("duplicates present");
			}else
			{
				System.out.println("no duplicate ");
			}
		}
	}




	@Test
	public void duplicateOptionsInDropDownWithCollections()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions  notification=new ChromeOptions();
		notification.addArguments("--disable notifications");
		WebDriver driver = new ChromeDriver(notification);
		//try {
		// Navigate to Wikipedia
		driver.get("https://www.wikipedia.org");

		// Find the dropdown element
		WebElement ele = driver.findElement(By.id("searchLanguage"));
		Select sc = new Select(ele);
		List<WebElement> options = sc.getOptions();

		ArrayList<String> list=new ArrayList<String>();
		
		for (WebElement webElement : options) 
		{
			list.add(webElement.getText());
		}
		
		HashSet<String> set=new HashSet<String>(list);
		System.out.println(list.size()+"=========="+set.size());
		
		if(list.size()==set.size())
		{
			System.out.println("duplicate not present");
		}else
		{
			System.out.println("not present");
		}
		
		if(list.size()>set.size())
		{
			for (int i = 0; i < list.size(); i++)
			{
				System.out.println(list.get(i));
			}
			System.out.println("duplicate not present");
		}else
		{
			System.out.println("not present");
		}
		
	}

}





