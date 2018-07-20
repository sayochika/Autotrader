package com.project.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass 
{
	public static WebDriver driver;
	private static String OS;
	private static Select select;
	private static Actions action;
	
	
	static
	{
		driver = null;
		OS = System.getProperty("os.name").toLowerCase();
		select = null;
		action = null;
		
	}
	
	
	public static void hoverOverAnElement(WebElement element) throws Exception
	{
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void launchBrowser(String browserName) throws Exception
	{
		browserName = browserName.toLowerCase();
		
		switch(browserName)
		{
		case "chrome" :
			driver = initialiseChrome();
			break;
		case "firefox" :
			driver = initialiseFirefox();
			break;
		case "ie":
		case "internetExplorer":
		case "internet explorer":
			driver = initialiseInternetExplorer();
			break;
			
			default:
				driver = initialiseChrome();
		}
		
		driver.manage().window().maximize();
		
	}
	
	public static void selectByText(WebElement element, String text) throws Exception
	{
		select = new Select(element);
		Thread.sleep(3000);
		select.selectByVisibleText(text);
	}
	
	public static void selectByValue(WebElement element, String value) throws Exception
	{
		select = new Select(element);
		Thread.sleep(3000);
		select.selectByValue(value);
	}
	
	public static void selectByIndex(WebElement element, int index) throws Exception
	{
		select = new Select(element);
		Thread.sleep(3000);
		select.selectByIndex(index);;
	}
	
	
	
	
	public static void launchUrl(String url) throws Exception
	{
		driver.navigate().to(url);
	}
	
	public static void closeBrowser() throws Exception
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	public static void clickNoOnPopUp() throws Exception
	{
		 driver.switchTo().alert().dismiss();
	}
	
	public static void clickYesOnPopUp() throws Exception
	{
		 driver.switchTo().alert().accept();
	}
	
	private static WebDriver initialiseChrome() throws Exception
	{
		if(OS.contains("win"))
		{
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		}
		else if(OS.contains("mac"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		}
		else if(OS.contains("linux"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		}
		
		return new ChromeDriver();
	}
	
	private static WebDriver initialiseFirefox() throws Exception
	{
		if(OS.contains("win"))
		{
			System.setProperty("webdriver.chrome.driver", "./lib/geckodriver.exe");
		}
		else if(OS.contains("mac"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/geckodriver");
		}
		else if(OS.contains("linux"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/geckodriver");
		}
		
		return new FirefoxDriver();
	}
	
	private static WebDriver initialiseInternetExplorer() throws Exception
	{
		if(OS.contains("win"))
		{
			System.setProperty("webdriver.chrome.driver", "./lib/IEDriverServer.exe");
		}
		else if(OS.contains("mac"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/IEDriverServer");
		}
		else if(OS.contains("linux"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/IEDriverServer");
		}
		
		return new FirefoxDriver();
	}
	
	
	public static File takeScreenshot() throws Exception 
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	}
	
	
	public static void saveScreenshot() throws Exception
	{
		String dateOfFailure = new SimpleDateFormat("ddMMyy").format(new GregorianCalendar().getTime());
		String timeOfFailure = new SimpleDateFormat("HHmmss").format(new GregorianCalendar().getTime());
		
		String fileName = String.format(".\\Screenshot\\%s\\screenshot_%s", dateOfFailure, timeOfFailure);
		
		//The line below is within FileUtils.copyFile
		//File screenshot = takeScreenshot();
		
		FileUtils.copyFile(takeScreenshot(), new File(fileName));
	}
	
	public static WebElement getElementById(String id) throws Exception
	{
		//By locator = By.id(id);
		return getElement(By.id(id));
	}
	
	
	public static List<WebElement> getElementsById(String id) throws Exception
	{
		//By locator = By.id(id);
		return getElements(By.id(id));
	}
	
	public static WebElement getElementByName(String name) throws Exception
	{
		//By locator = By.id(id);
		return getElement(By.name(name));
	}
	
	public static List<WebElement> getElementsByName(String name) throws Exception
	{
		//By locator = By.id(id);
		return getElements(By.name(name));
	}
	
	public static WebElement getElementByClassName(String classname) throws Exception
	{
		//By locator = By.id(id);
		return getElement(By.className(classname));
	}
	
	public static List<WebElement> getElementsByClassName(String classname) throws Exception
	{
		//By locator = By.id(id);
		return getElements(By.className(classname));
	}
	
	public static WebElement getElementByCssSelector(String cssSelector) throws Exception
	{
		//By locator = By.id(id);
		return getElement(By.cssSelector(cssSelector));
	}
	
	
	public static List<WebElement> getElementsByCssSelector(String cssSelector) throws Exception
	{
		//By locator = By.id(id);
		return getElements(By.cssSelector(cssSelector));
	}
	
	
	private static WebElement getElement(By locator) throws Exception
	{
		//Declaring webelement and initialising to empty
		WebElement element = null;
		
		//declaring a count variable and initialising to zero
		int tryCount = 0;
		
		
		//loop through find element so that selenium tries more than once
		while(element == null)
		{
			try
			{
				element = driver.findElement(locator);
			}
			catch(Exception e)
			{
				if(tryCount == 3)
				{
					saveScreenshot();
					throw e;
				}
			}
			Thread.sleep(2000);
			tryCount++;
		}
		
		return element;
	}
	
	
	private static List<WebElement> getElements(By locator) throws Exception
	{
		//Declaring webelement and initialising to empty
		List<WebElement> element = null;
		
		//declaring a count variable and initialising to zero
		int tryCount = 0;
		
		
		//loop through find element so that selenium tries more than once
		while(element == null)
		{
			try
			{
				element = driver.findElements(locator);
			}
			catch(Exception e)
			{
				if(tryCount == 3)
				{
					saveScreenshot();
					throw e;
				}
			}
			Thread.sleep(2000);
			tryCount++;
		}
		
		return element;
	}
	
}
