package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {
	            
	 String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
		String dbUsername="Syntax";
		String dbPassword="syntax123";
				
	@Test
	public void getMetaData() throws SQLException {
		
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		DatabaseMetaData dbMetaData=conn.getMetaData();
		
		String dbName=dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		
		String dbVersion=dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVersion);
		
		System.out.println();
		System.out.println("---------ResultSetMetaData----------");
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from employees where job_id like 'IT%'");
		
		ResultSetMetaData rsMetaData=rs.getMetaData();
		
		//to get total number of columns
		int colNum=rsMetaData.getColumnCount();
		System.out.println(colNum);  //11
		
		//get name of specified column
		String colName=rsMetaData.getColumnName(2);
		System.out.println(colName); //FIRST_NAME
		
		System.out.println("-------Printing all column names using loop------");
		//print all column names:
		//column name start with index 1
		for(int i=1; i<=colNum; i++) {
			colName=rsMetaData.getColumnName(i);
			System.out.println(colName); 
		}
		
		rs.close();
		st.close();
		conn.close();
	}
	
	
	
	
}
