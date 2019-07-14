package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataDemo {

	 String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
		String dbUsername="Syntax";
		String dbPassword="syntax123";
				
	@Test
	public void getMetaData() throws SQLException {
		System.out.println("---------DataBaseMetaData----------");
		//1. DataBaseMetaData
		
		
		//1. establish connection to DB
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		//no need to get statement, just working with Database here
		//2.let's see what type of methods we have there
		DatabaseMetaData dbMetaData=conn.getMetaData();
		
		//returns product you use -Oracle
		//print database name
		String dbName=dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		
		//version we are using in DB
		//print database version
		String dbVersion=dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVersion);
		
		System.out.println();
		System.out.println("---------ResultSetMetaData----------");
		//2.
		
		//conn.createStatement().executeQuery(sql);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from employees where job_id like 'IT%'");
		
		//there are a lot of methods we can use here
		ResultSetMetaData rsMetaData=rs.getMetaData();
		
		//to get total number of columns
		int colNum=rsMetaData.getColumnCount();
		System.out.println(colNum);  //11
		
		//get name of specified column
		String colName=rsMetaData.getColumnName(2);
		System.out.println(colName); //FIRST_NAME
		
		System.out.println();
		//print all column names
		for(int i=1; i<=colNum; i++) {
			System.out.println(rsMetaData.getColumnName(i)); 
		}
		
		rs.close();
		st.close();
		conn.close();
	}
	
	
	
	
	
	
	
	
}
