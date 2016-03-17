package breizhcamp2016;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

public class AsyncExample {

    public static void main(String[] args) {

        // Ce ne sont pas les mêmes classes que pour le driver synchrone !
        //

        // Async Client
        //
        MongoClient client = MongoClients.create("mongodb://localhost:28100");


        // Async Database et Collection
        //
        MongoDatabase database = client.getDatabase("breizhcamp2016");
        MongoCollection<Conference> collection = database.getCollection("conferences", Conference.class);

        Conference conf = new Conference("Framework TrucMachinChoseJS et Dockerification de mes microservices",
                "C'est trop cool !", new Speaker("JsAndDockerAndMicroServicesManiac", "@..."));

        collection.insertOne(conf,
            (final Void result, final Throwable t) -> {
                System.out.println("Conference inserée");
            });

        collection.count((final Long count, final Throwable t) -> {
            if (t != null) {
                System.out.println("Count = " + count);
            }
        });

    }

}
