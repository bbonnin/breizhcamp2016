package breizhcamp2016;


import java.util.Arrays;
import java.util.Iterator;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DriverExample {

    public static void main(String[] args) {

     // Init with codecs
        //
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                CodecRegistries.fromCodecs(new ConferenceCodec()),
                MongoClient.getDefaultCodecRegistry());

        MongoClientOptions options = MongoClientOptions.builder()
                .codecRegistry(codecRegistry).build();

        MongoClient client = new MongoClient("localhost:28100", options);

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

        Conference newconf = new Conference("MongoDB, c'est pas trop mal, mais des fois, ça pourrait être mieux", Arrays.asList("bbo"));
        confCollection.insertOne(newconf);


        MongoCursor<Conference> conferences = confCollection.find().iterator();

        while (conferences.hasNext()) {
            Conference conf = conferences.next();
            System.out.println(conf);
        }



        // Fluent API
        //
        conferences = docCollection.find(Conference.class).skip(5).limit(10).iterator();



    }

}
