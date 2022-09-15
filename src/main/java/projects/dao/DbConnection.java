package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	
	private static final String HOST = "localhost";
	private static final String PASSWORD = "H3rdn3r24*";
	private static final int PORT = 3306;
	private static final String SCHEMA = "projects";
	private static final String USER = "root";

	
	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&allowPublicKeyRetrieval=true&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		
		System.out.println("Connecting with url= " + url);
		
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connection successful!");
			return conn;
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			throw new DbException(e);
		}
	}

}
