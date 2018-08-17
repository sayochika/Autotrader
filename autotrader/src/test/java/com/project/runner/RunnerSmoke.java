package com.project.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/project/features",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		glue = {"com/project/hook", "com/project/stepDefinitions"},
		tags = {"@SmokeTest"}		
		)
public class RunnerSmoke {

}
