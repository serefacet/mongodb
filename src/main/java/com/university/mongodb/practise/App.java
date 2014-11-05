package com.university.mongodb.practise;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost",27017));
        
        DB database = mongoClient.getDB("course");
        DBCollection collection = database.getCollection("hello");
        DBObject document = collection.findOne();
        System.out.println(document);
        
    }
}
