package com.rntbci.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.bson.Document;

 import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbConn {
	public static MongoCollection <Document> collection=null;
	
	 static {
		try {
		MongoClient mongoClient = new MongoClient("mongodb://127.0.0.1:27017");
		 MongoDatabase database = mongoClient.getDatabase("radb");
		 
		 collection = database.getCollection("RAG");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MongoCollection<Document> getConn() {
		return collection;
	}

}
