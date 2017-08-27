package com.bhanu.pr.AppointmentManagement.Databse;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	
	Connection conn;
	
	public Connection getConnection(){
		
	
/*		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");*/

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

/*			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");*/
			e.printStackTrace();
		

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");



		try {

			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres",
					"bhanu123");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
	

		}

		if (conn != null) {
			System.out.println("You made it, take control your database now!");
	
		} else {
			System.out.println("Failed to make connection!");
		}
	
		return conn;
	}
}
