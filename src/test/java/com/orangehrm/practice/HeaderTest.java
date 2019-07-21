package com.orangehrm.practice;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class HeaderTest {

	//When I send GET request to the "/api/getAllStudentProfiles"
	//Then response status quo is 200
	//And response header "Content-Type" contains "application/json"
	
	@Test
	public void header() {
		
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax/";		
		
		Response resp=	
				given().
				when().
                get("/api/getAllStudentProfiles");
	   
        resp.then().assertThat().statusCode(200).
        //we are verifying header from the response, that data we send is in JSON format
        and().header("Content-Type", equalTo("application/json;charset=UTF-8"));	
		
	}
}
