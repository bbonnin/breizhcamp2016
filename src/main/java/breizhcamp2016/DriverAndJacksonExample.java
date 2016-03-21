package breizhcamp2016;


import java.util.Arrays;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;

import fr.javatic.mongo.jacksonCodec.JacksonCodecProvider;
import fr.javatic.mongo.jacksonCodec.ObjectMapperFactory;

public class DriverAndJacksonExample {

    public static void main(String[] args) {


        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(new JacksonCodecProvider(ObjectMapperFactory.createObjectMapper())));

        MongoClientOptions clientOptions = MongoClientOptions.builder()
                .codecRegistry(codecRegistry)
                .build();

        MongoClient client = new MongoClient(new ServerAddress("localhost", 28100), clientOptions);

        MongoDatabase database = client.getDatabase("breizhcamp2016");

        MongoCollection<Conference> confCollection = database.getCollection("conferences", Conference.class);

        Conference newconf = new Conference("1", "Driver 3.0, c'est pas trop mal, mais ça pourrait être mieux", Arrays.asList("bbo"));
        confCollection.insertOne(newconf);


        MongoCursor<Conference> conferences = confCollection.find().iterator();

        while (conferences.hasNext()) {
            Conference conf = conferences.next();
            System.out.println(conf);
        }


        FindOneAndUpdateOptions options = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
        Conference updConf = confCollection.findOneAndUpdate(new Document(),
                new Document("$push", new Document("speakerIds", "pad")),
                options);
        System.out.println(updConf);

        confCollection.deleteMany(new Document());

    }

}
