package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Task1 {
	//display in console id and department name in 1 row
	
    String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	String dbUsername="Syntax";
	String dbPassword="syntax123";

	@Test
	public void printRowData() throws SQLException {
		 
		Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		Statement statement=connection.createStatement();
		
		ResultSet resulSet=statement.executeQuery("select department_id, department_name from departments");
		
		while(resulSet.next()) {
			int depId=resulSet.getInt("Department_ID");
			String depName=resulSet.getString("Department_Name");
			System.out.println(depId+" "+depName);
		}
		
		resulSet.close();
		statement.close();
		connection.close();
	}
	
	
}
