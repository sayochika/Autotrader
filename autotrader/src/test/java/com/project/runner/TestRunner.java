package com.project.runner;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/project/features",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter"},
		glue = {"com/project/hook", "com/project/stepDefinitions"}		
		)

public class TestRunner 
{
	@BeforeClass
	public static void globalSetUp() 
	{
		String dateOfReport = new SimpleDateFormat("ddMMyy").format(new GregorianCalendar().getTime());
		String timeOfReport = new SimpleDateFormat("HHmmss").format(new GregorianCalendar().getTime());
		
		String reportDir = String.format("./report/%s/report_%s.html", dateOfReport, timeOfReport);
		
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File(reportDir));
		ExtentCucumberFormatter.loadConfig(new File("src/test/java/com/project/util/extent-config.xml"));
		
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
		
	}
}
