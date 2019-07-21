package com.orangehrm.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class HamcrestTest {

	/* Retrieve quote of specific character (varys) and verify that response code is 200
	 * and response contains "Power resides where man believe it resides"
	 */
	
	@Test
	public void verifyResponse() {
		
		RestAssured.baseURI="https://got-quotes.herokuapp.com";
		
		//first way using JUnit Assertion:
		Response resp=
		        given().queryParam("char", "varys").
		        when().get("/quotes");
		
		int code=resp.getStatusCode();
		Assert.assertEquals(200, code);
		
		//body
		String respBody=resp.asString();
		System.out.println(respBody);
		
		Assert.assertTrue(respBody.contains("Varys"));
		
	}
	@Test
	public void verifyResponse2() {
		
		RestAssured.baseURI="https://got-quotes.herokuapp.com";
		
		//second way to complete request * assertion
		
				//preparing request
				given().
				    queryParam("char", "varys").
			   //sending request
				when(). 
				    get("/quotes").
				//then() -validating request
				then().
				    assertThat().statusCode(200).
				and().
				    assertThat().body("character", equalTo("Varys"));		
	}
	
	@Test
	public void verifyRequest3() {
		RestAssured.baseURI="https://got-quotes.herokuapp.com";
		
		//3 way:
		Response resp1=
		given().
	        queryParam("char", "varys").
        when(). 
	        get("/quotes");

		resp1.then().
		     assertThat().statusCode(200).
		and().
		    body("character",equalTo("Varys"));
		
	}
	
}
