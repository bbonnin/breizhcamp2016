package breizhcamp2016;

import java.util.Arrays;

import org.bson.codecs.configuration.CodecRegistries;

import com.mongodb.ServerAddress;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import com.mongodb.connection.ClusterSettings;

public class AsyncExample {

    public static void main(String[] args) throws Exception {

        // Ce ne sont pas les mêmes classes que pour le driver synchrone !
        //

        // Async Client
        //
        ClusterSettings clusterSettings = ClusterSettings.builder().hosts(Arrays.asList(new ServerAddress("localhost", 28100))).build();
        MongoClientSettings settings = MongoClientSettings.builder().clusterSettings(clusterSettings).codecRegistry(CodecRegistries.fromCodecs(new ConferenceCodec())).build();

        MongoClient client = MongoClients.create(settings);


        // Async Database et Collection
        //
        MongoDatabase database = client.getDatabase("breizhcamp2016");
        MongoCollection<Conference> collection = database.getCollection("conferences", Conference.class);

        Conference conf = new Conference(
                "Framework TrucMachinChoseJS et Dockerification de mes microservices",
                Arrays.asList("JsAndDockerAndMicroServicesManiac"));

        collection.insertOne(conf,
            (final Void result, final Throwable t) -> {
                System.out.println("Conference inserée");
            });


        collection.count((final Long count, final Throwable t) -> {
            if (t == null) {
                System.out.println("Count = " + count);
            } else {
                System.err.println("Error = " + t);
            }
        });

        Thread.sleep(10000);

    }

}
