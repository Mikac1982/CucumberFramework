package com.orangehrm.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathTest {

	//Retrieve value of specific key from JSON object
	
//	@Test
	public void test1() {
		
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
	
	//after validation i want to retrieve value of specific key
	//using JSON path
	
	JsonPath jPath=resp.jsonPath();
		
	//getting value of the key firstName
	String firstName=jPath.get("firstName");
	System.out.println(firstName);
	
	String lastName=jPath.get("lastName");
	System.out.println(lastName);

	}
	
	@Test
	public void getAllStudents() {
		
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax/";		
		
		Response resp=	
				given().
				when().
                get("/api/getAllStudentProfiles");
		
		resp.prettyPrint();
		//we have multiple Objects
		JsonPath jPath=resp.jsonPath();
				
		//get me the value of lastName in your third(3) Object (index=2)
		String lastName=jPath.get("lastName[2]");
		System.out.println(lastName); //Doe
		
		//returns all first names 
		Object fName = jPath.get("firstName");
		System.out.println(fName);
		
		//we can store in in List of Strings
		List<String> firstName=jPath.get("firstName");
		
		for(String name1:firstName) {
			System.out.println(name1);
		}
		
	}
	
	
}
