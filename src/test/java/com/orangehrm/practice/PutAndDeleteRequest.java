package com.orangehrm.practice;
import static io.restassured.RestAssured.given;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class PutAndDeleteRequest {

	//automate PUT and Delete request
	
	
	@Test
	public void putAndDelete() {
		
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		
		Response resp=
				given().when().delete("/api/deleteStudentProfile/{studentId}");
		
		
		
		
		
	}

	
	
	
	
	
	
	
}
