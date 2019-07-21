package com.orangehrm.practice;

import org.junit.Assert;
import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiGetDemo {

//	@Test
	public void getWeather() {
		
		//get method will give you back response:
		//when we send request, we get back one response  
		Response response=RestAssured.when().get("http://restapi.demoqa.com/utilities/weather/city/Fairfax");
		
		//method that prints response in pretty form
		response.prettyPrint();
		//inside response we have status, and a lot of other things
		int code=response.getStatusCode();
		System.out.println(code);
	}
	
	//get status and print response from country API
	@Test
	public void getCountry() {
		
		Response response=RestAssured.when().get("http://restcountries.eu/rest/v1/name/Serbia");
//		response.prettyPrint();
		
		//getStatusCode();
		int code=response.getStatusCode();
		System.out.println(code);
		
		Assert.assertEquals(200, code);
		
		//retrieve response body as a String
		String body=response.asString();
		System.out.println(body);
		
		Assert.assertTrue(body.contains("Belgrade"));
		
		//retrieve body header date as a String
		String header=response.getHeader("Date");
		System.out.println(header);
		
		String header2=response.getHeader("Connection");
		System.out.println(header2);
		
		
		
		
		
	}
	
}
