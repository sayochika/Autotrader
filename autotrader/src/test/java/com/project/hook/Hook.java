package com.project.hook;

import com.project.common.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseClass
{	
	@After
	public void tearDown() throws Exception
	{
		closeBrowser();
	}
	
	
	@Before
	public void setUp() throws Exception
	{
		launchBrowser("Chrome");
	}
}
