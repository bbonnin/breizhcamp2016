package breizhcamp2016;


import java.util.Iterator;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class NewClassesExample {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:28100");

        // New Database and Collection Classes
        //
        // Before:
        // - DB
        // - DBCollection
        //
        DB db = client.getDB("breizhcamp2016");
        DBCollection dbCollection = db.getCollection("conferences");

        Iterator<DBObject> confIter = dbCollection.find().iterator();

        // ... traitements ...


        // After:
        // - MongoDatabase
        // - MongoCollection
        //
        MongoDatabase database = client.getDatabase("breizhcamp2016");

        // On manipule des Documents
        MongoCollection<Document> docCollection = database.getCollection("conferences");
        MongoCursor<Document> docs = docCollection.find().iterator();

        // Mieux : on manipule des objets métiers
        MongoCollection<Conference> confCollection = database.getCollection("conferences", Conference.class);
        MongoCursor<Conference> conferences = confCollection.find().iterator();

        // Fluent API
        //
        conferences = docCollection.find(Conference.class).skip(5).limit(10).iterator();


    }

}
