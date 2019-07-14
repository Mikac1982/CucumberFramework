package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ProccessResultSet {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";

	@Test
	public void printRowData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement stat = conn.createStatement();

		// ResultSet holds all results of this query
		ResultSet rs = stat.executeQuery("select first_name, last_name from employees where job_id='IT_PROG'");

		// storing results of the query as maps (keys/values as String) 
		//and put all maps into List(collection of Maps)
		// firts_name, last_name
		List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();

		//we go row by row and taking value of the column and putting inside the Map
		while (rs.next()) {
			Map<String, String> rsMap = new HashMap<String, String>();
			rsMap.put("FIRST_NAME", rs.getString("FIRST_NAME"));
			rsMap.put("Last_name", rs.getString("LAST_NAME"));
			// put maps in list
			rsList.add(rsMap);
		}

		System.out.println(rsList);

		rs.close();
		stat.close();
		conn.close();
	}

	@Test
	public void review() {
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("first_name", "Alexander");
		map.put("first_name", "Bruce");
		map.put("first_name", "David");
		
		System.out.println(map.size());  //1
		System.out.println(map);         //the last row value
	}
	
	//process query that will give result of street address, city and country name
	//and store results inside the list
	
	
	
	
	
	
}
