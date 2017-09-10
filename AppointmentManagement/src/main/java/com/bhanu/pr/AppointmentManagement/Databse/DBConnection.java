package com.bhanu.pr.AppointmentManagement.Databse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	
	Connection conn;
	Properties prop = new Properties();
	InputStream input = null;
	
	public Connection getConnection(){
		
	
/*		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");*/

		try {
			//input = new FileInputStream("DBProp.properties");
			input =getClass().getClassLoader().getResourceAsStream("DBProp.properties");

			prop.load(input);

			//Class.forName("org.postgresql.Driver");
			Class.forName(prop.getProperty("CLASSNAME"));

		} catch (ClassNotFoundException e) {

/*			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");*/
			e.printStackTrace();
		

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");



		try {

			conn = DriverManager.getConnection(
					prop.getProperty("URL"), prop.getProperty("USERNAME"),
					prop.getProperty("PASSWORD"));

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
