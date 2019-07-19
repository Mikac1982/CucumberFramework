package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Task2 {

	//process query that will give result of street address, city and country name
	//and store results inside the list
	
	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";

//	@Test
	public void printRowData() throws SQLException {
		
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement stat = conn.createStatement();
	    
	//	ResultSet rs=stat.executeQuery("select street_address, city, country_name from locations l join countries c on l.country_id=c.country_id");
		String query="select street_address, city, country_name from locations l join countries c on l.country_id=c.country_id";
		ResultSet rs=stat.executeQuery(query);
		
		List<Map<String, String>> rsList =new ArrayList<Map<String, String>>();
		
		while (rs.next()) {
			//creating map for each row
			Map<String, String> rsMap = new HashMap<String, String>();
			rsMap.put("street_address", rs.getString("street_address"));
			rsMap.put("city", rs.getString("city"));
			rsMap.put("country_name", rs.getString("country_name"));
			//map we just created we store inside list
			rsList.add(rsMap);
		}
		System.out.println(rsList);

		rs.close();
		stat.close();
		conn.close();
	}
	
	@Test
	public void s() throws SQLException {
		
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement stat = conn.createStatement();
	    
		String query="select * from jobs";
		ResultSet rs=stat.executeQuery(query);
		
		ResultSetMetaData rsMetaData=rs.getMetaData();	
		
		List<Map<String, String>> rsList =new ArrayList<Map<String, String>>();
		
		//loop through each row/record from sql query result
		while (rs.next()) {
			Map<String, String> rsMap = new HashMap<String, String>();
			
			//if we want info about columns and num of columns
			//looping through each column(start from 1)
			for (int i=1; i<=rsMetaData.getColumnCount(); i++) {
			//get me the column name (i), get me the value of that column(i) and convert to String
			rsMap.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			
			}
			//after looping through all columns, that map we store into list
			//than we loops through next row until we come to the very last row
			//all maps(for each row) are stored into list
			rsList.add(rsMap);
		}
		System.out.println(rsList);

		rs.close();
		stat.close();
		conn.close();
		
	}
	
	
	
	
	
	
	
	
	
}
