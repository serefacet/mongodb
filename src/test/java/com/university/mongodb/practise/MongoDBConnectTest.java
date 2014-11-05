package com.university.mongodb.practise;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongoDBConnectTest{


	@Test
	public void connect() throws UnknownHostException{
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost",27017));
        DB database = mongoClient.getDB("school");
        DBCollection collection = database.getCollection("students");
        
        BasicDBObject allQuery = new BasicDBObject();
    	BasicDBObject fields = new BasicDBObject();
    	fields.put("scores", 1);
    	DBCursor cursor = collection.find(allQuery,fields);
    
    	while(cursor.hasNext()) {
    		BasicDBObject basicDBObject = (BasicDBObject) cursor.next();
System.out.println(basicDBObject.get("type"));
    	}
    	
//        System.out.println(document);
	}
	
}
