package test;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoTest {

	public static void main(String[] args) {
	    try{
			
	         // To connect to mongodb server
	        // MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         MongoCredential testAuth = MongoCredential.createPlainCredential("samarjeet", "samarjeetdb", "samar123".toCharArray());
	         List<MongoCredential> auths = new ArrayList<MongoCredential>();
	         auths.add(testAuth);	
	         ServerAddress serverAddress = new ServerAddress("localhost", 27017);
	         MongoClient mongo = new MongoClient(serverAddress);
	         
	         // Now connect to your databases
	        DB db = mongo.getDB( "samarjeetdb" );
	         System.out.println("Connect to database successfully");
	         BasicDBObject dbObject=new BasicDBObject();
	         dbObject.append("title", "MongoDB").
	                 append("description", "database").
	                 append("likes", 100).
	                 append("url", "http://www.tutorialspoint.com/mongodb/").
	                 append("by", "tutorials point");
	         DBCollection coll = db.createCollection("firstCollection1", dbObject);
	         coll.insert(dbObject);
	         DBCollection coll2 = db.getCollection("firstCollection1");
	         DBCursor dbCurson=coll2.find();
	         System.out.println(dbCurson.hasNext());
	         int i=0;
	         while (dbCurson.hasNext()) { 
	             System.out.println("Inserted Document: "+i); 
	             System.out.println(dbCurson.next()); 
	             i++;
	          }
	         
	         System.out.println("Collection created successfully:"+coll.find());
				
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }

	}

}
