package com.project.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.project.common.BaseClass;
import com.project.util.StoredValues;

public class SearchResultPage extends BaseClass
{
	private List<WebElement> result;
	
	public void doesSearchContainModel() throws Exception
	{
		result = getElementsByCssSelector(".listing-title.title-wrap");
		
		for(WebElement element : result )
		{
			String elementText = element.getText();
			
			Assert.assertTrue(elementText.contains("Q7"));
		}
		

	}
	
	public void doesSearchContainModel(String model) throws Exception
	{
		result = getElementsByCssSelector(".listing-title.title-wrap");
		
		for(WebElement element : result )
		{
			String elementText = element.getText();
			
			Assert.assertTrue(elementText.contains(model));
		}
		

	}
	
	public ResultDetailPage clickOnResultLink() throws Exception
	{
		result = getElementsByCssSelector(".listing-title.title-wrap");
		
		
		String linkText = result.get(0).getText();
		
		new StoredValues().store("StoredList", linkText);
		
		result.get(0).click();
		
		return new ResultDetailPage();
	}
	
	
	
}
