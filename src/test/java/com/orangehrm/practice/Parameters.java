package com.orangehrm.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Parameters {

//	@Test
	public void queryParameters() {

		RestAssured.baseURI = "https://reqres.in/";

		//
		Response response = 
				given().
				     queryParam("page", "2").
				when().
				     get("api/users"); // ready to hit get request

		Assert.assertEquals(200, response.getStatusCode());
		int code = response.getStatusCode();
		System.out.println(code);

		Assert.assertTrue(response.asString().contains("Tracey"));

	}

	@Test
	public void pathParameter() {
		
		// passing base URL from postman
		RestAssured.baseURI = "https://reqres.in";
		
		        // i have path parameters
				given().pathParam("id", "3").
		        // when i hit get request, follow this URL and look for path parameter with a name "id"
				when().get("/api/users/{id}"). 
				//i should see code 200
				then().statusCode(200);

				
	}

}
