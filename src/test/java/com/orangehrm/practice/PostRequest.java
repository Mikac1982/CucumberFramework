package com.orangehrm.practice;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {

	@Test
	public void createStudent() {
		
		Map<String, Object> map=new HashMap<>();
		
		map.put("id", 0);
		map.put("firstName", "Jelena");
		map.put("lastName", "Djokovic");
		map.put("age", "31");
		map.put("batch", "1");
		map.put("batchStartDate", "2010-09-14");
		map.put("batchEndDate", "2029-03-01");
		map.put("course", "Tennis");
		map.put("attendanceNature", "nj");
		map.put("streetAddress", "123 test");
		map.put("city", "Clifton");
		map.put("state", "NJ");
		map.put("zipCode", "12345");
		
		RestAssured.baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		
		Response resp=
		given().accept(ContentType.JSON).
		     header("Content-Type","application/json").
		     body(map).
		when().
		     post("/api/createStudentProfile");
		
		resp.then().assertThat().statusCode(201);
		
		resp.prettyPrint();

        //for map we need json 
		int studentId=resp.jsonPath().get("id");
		System.out.println(studentId);
		
		Map<String, Object> reponseMap=resp.as(Map.class);
		System.out.println(reponseMap);
		
		
		
		
	}
	
	/*{
  "id": 205,
    "firstName": "Nick>",
    "lastName": "Jackson",
    "age": 45,
    "batch": 5,
    "batchStartDate": "2019-09-14",
    "batchEndDate": "2020-03-01",
    "course": "Selenium",
    "attendanceNature": "nj",
    "streetAddress": "123 test",
    "city": "Clifton",
    "state": "NJ",
    "zipCode": "12345"
}
	 * 
	 */
	
	
}
