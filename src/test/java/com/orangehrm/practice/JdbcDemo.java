package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {

	//copy this path from sql developer(right click--> properties)
	//and we add at the end:   :1521:orcl 
	//and we add at front      :jdbc:oracle:thin:@
	//thin --> type of driver to connect oracle
	String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	
	//username and password for Database
	String dbUsername="Syntax";
	String dbPassword="syntax123";
	
	@Test
	public void dbConnection() throws SQLException {
		//1.
		//to build connection to DataBase, we use DriverManager Class:
		//it will go to DB and ESTABLISH CONNECTION--valid path to db
		//returns  us 1 object which is type of connection:
		Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		//2.
		//create a STATEMENT:
		//returns us 1 object type of statement
		Statement statement=connection.createStatement();
		
		//3.
		//passing REQUIREMENTS in form of sql query
		//EXECUTE QUERY and store results from database in ResultSet object
		//ResultSet holds all the results from sql statement -- 25 countries
		ResultSet resultSet=statement.executeQuery("Select * from Countries");
		
		//4.
		//RETRIVE values from ResultSet:
		//we have to use method next() to point out from row 0(column name) to row 1(country)
		resultSet.next();
		
		String columnData=resultSet.getString("Country_Name");
		System.out.println(columnData);
		
		//to move courser to Australia(row 2)
		resultSet.next();
		columnData=resultSet.getString("Country_Name");
		System.out.println(columnData);
		
		//using WHILE LOOP to get all values :
		System.out.println("---------Printing values using loop----------");
		while(resultSet.next()) {
			columnData=resultSet.getString("Country_Name");
			System.out.println(columnData);
		}
		
		//once we retrieve all data, we have to CLOSE all connections to DB:
		resultSet.close();
		statement.close();
		connection.close();
		
	}
	
	@Test
	public void dbConnection2() throws SQLException {
		 
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		Statement stat=conn.createStatement();
		
		ResultSet rs=stat.executeQuery("select department_id, department_name from departments");
		
		while(rs.next()) {
			int columnData1=rs.getInt("Department_ID");
			String columnData2=rs.getString("Department_Name");
			System.out.println(columnData1+" "+columnData2);
		}
		
		rs.close();
		stat.close();
		conn.close();
	}
	
	
	
	
	
}
