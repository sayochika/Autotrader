package com.project.hook;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.project.common.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseClass
{	
	
	public Scenario scenario;
	
	@Before
	public void setUp(Scenario scenario) throws Exception
	{
		this.scenario = scenario;
		launchBrowser("Chrome");
	}
	
	
	@After
	public void tearDown() throws Exception
	{
		String dateOfFailure = new SimpleDateFormat("ddMMyy").format(new GregorianCalendar().getTime());
		String timeOfFailure = new SimpleDateFormat("HHmmss").format(new GregorianCalendar().getTime());
		
		String scenarioName = scenario.getName();
		
		String fileName = String.format(".\\Screenshot\\%s\\%s_%s.png", dateOfFailure, scenarioName, timeOfFailure);
		
		if(scenario.isFailed())
		{
			try 
			{
				byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, fileName);
				
				FileUtils.copyFile(takeScreenshot(), new File(fileName));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		closeBrowser();
	}
	
	
	
}
