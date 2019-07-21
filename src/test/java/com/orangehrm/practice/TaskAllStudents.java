package com.orangehrm.practice;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TaskAllStudents {
	/* Retrieve all students and verify that GET response code is 200 
	 * and retrieve first name of a second student
	 * Retrieve all students lastName;
	 */
	
	@Test
	public void allStudents() {
			
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		
		Response resp=	
				given().
				when().
                get("/api/getAllStudentProfiles");
		
	    //validating status code
		resp.then().assertThat().statusCode(200);
		
//		resp.prettyPrint();
		
		//if you specify right path for element, it will return you that element
		JsonPath jPath=resp.jsonPath();
	    String fName=jPath.get("firstName[1]");
	    System.out.println("First name of the second student: "+fName);
	    
	//    Object lastNames= jPath.get("lastName");
	//    System.out.println(lastNames);
	    
	    //request returns us multiple elements(because we didn't specify index), all the last names
	    List<String> lastName=jPath.get("lastName");
	    for (String names:lastName) {
	    	System.out.println(names);
	    	
	    }
	    
	}
}
