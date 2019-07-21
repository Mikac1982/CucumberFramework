package com.orangehrm.practice;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class PutRequest {

	
	@Test
	public void pathPar() {
		
	RestAssured.baseURI="pure-ravine-92491.herokuapp.com/syntax";	
		
	given().pathParam("id", "138").
	when().put("api/updateStudentProfile/{id}").
	then().statusCode(200);
		
		
		
	}
	
	
	
	
	
}
