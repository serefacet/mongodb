package com.university.mongodb.practise;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class Snippet {
	public static void main(String[] args) throws UnknownHostException {

		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
		DB database = mongoClient.getDB("school");
		DBCollection collection = database.getCollection("students");

		BasicDBObject allQuery = new BasicDBObject();
		allQuery.put("scores.type", "homework");
		BasicDBObject fields = new BasicDBObject();
		fields.put("scores.score", 2);
		fields.put("scores.type", 1);
		DBCursor cursor = collection.find(allQuery, fields);

		while (cursor.hasNext()) {
			BasicDBObject object = (BasicDBObject) cursor.next();
			System.out.println(object);
		}
	}

}