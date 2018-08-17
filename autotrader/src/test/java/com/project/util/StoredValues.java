package com.project.util;

import java.util.HashMap;
import java.util.Map;

public class StoredValues 
{
	private static Map<String, Object> values;
	
	static
	{
		values = new HashMap<String, Object>();
	}
	
	public void store(String key, String value)
	{
		values.put(key.toLowerCase().trim(), value);
	}
	
	public String retrieve(String key)
	{
		return values.get(key.toLowerCase().trim()).toString();
	}

}
