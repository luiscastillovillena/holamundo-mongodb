package edu.pe.cibertec;



import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class HelloMongo {
	private final static String HOST = "localhost";
	private final static int PORT = 27017;
	
	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient(HOST, PORT);
			
			MongoDatabase db = mongoClient.getDatabase("test");
			MongoCollection<Document> coll = db.getCollection("alumnos");
			
			MongoCursor<Document> cursor = coll.find().iterator();
			
			try {
				while (cursor.hasNext()) {
					Document doc = cursor.next();
					
					System.out.println(doc.toJson());
				}
				
				mongoClient.close();
				
			} finally {
				cursor.close();
			}
					
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		
	}

}
