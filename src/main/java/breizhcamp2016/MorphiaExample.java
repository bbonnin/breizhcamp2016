package breizhcamp2016;


import static org.mongodb.morphia.aggregation.Group.addToSet;
import static org.mongodb.morphia.aggregation.Group.grouping;
import static org.mongodb.morphia.aggregation.Projection.projection;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MorphiaExample {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:28100");

        Morphia morphia = new Morphia();
        morphia.map(Conference.class, Speaker.class);

        Datastore datastore = morphia.createDatastore(client, "breizhcamp2016");

        Conference conf1 = new Conference("Have fun With MongoDB", "@padewitte", "@_bruno_b_");

        Conference conf2 = new Conference("AWS is so good", "@padewitte");

        datastore.save(conf1, conf2);

        List<Conference> confWithPAD = datastore.find(Conference.class)
                .filter("speakers", "PAD")
                .field("speakers").sizeEq(1)
                .asList();

        datastore.createAggregation(Conference.class)
            .unwind("speakers")
            .project(projection("twitterHandle", "speakers"), projection("title"))
            .group("twitterHandle", grouping("conferences", addToSet("title")))
            .out(Speaker.class);

        List<Speaker> speakers = datastore.find(Speaker.class).asList();

        System.out.println(speakers);


        datastore.delete(datastore.createQuery(Speaker.class));
        datastore.delete(datastore.createQuery(Conference.class));

    }

}
