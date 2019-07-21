package com.orangehrm.practice;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class TaskStudentId {
	//retrieve student with id 123 & verify that response status code is 200 
	//and first name of a student is Vladimir
	
	@Test
	public void verifyStudent() {
		
	RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax/";	
	
	Response resp=
	given().
	     pathParam("studentId", "123").
	when().
	     get("/api/getStudentProfile/{studentId}");
	
	resp.prettyPrint();
	
	resp.then().
	    assertThat().statusCode(200).
	and().
	    body("firstName", equalTo("Vladimir"));
		
		
	}
	
	
	
}
