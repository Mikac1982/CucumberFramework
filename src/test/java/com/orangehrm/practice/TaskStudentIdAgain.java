package com.orangehrm.practice;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class TaskStudentIdAgain {

	//retrieve student with id 143 & verify that response status code is 200 
	//and first name of a student is Jesica
	
	@Test
	public void verifystudent() {
		
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		
		Response resp=
		    given().
				pathParam("studentId", "143").
		    when().
				get("/api/getStudentProfile/{studentId}");
		
		resp.prettyPrint();
		
		resp.then().
		     assertThat().statusCode(200).
		and().
		     body("firstName", equalTo("Jesica"));
		
		
		
	}
	
	
	
	
}
