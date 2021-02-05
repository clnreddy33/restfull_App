package com.rntbci.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {
private static Connection conn=null;
	
	static {
		try {
			Class.forName("mongodb.jdbc.MongoDriver");
			conn= DriverManager.getConnection("jdbc:mongo://127.0.0.1:27017/radb", "RAG", "NIT");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		return conn;
	}

}
