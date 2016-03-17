package breizhcamp2016;


import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MorphiaExample {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:28100");

        Morphia morphia = new Morphia();
        morphia.map(Conference.class);

        Datastore store = morphia.createDatastore(client, "breizhcamp2016");

        store.findAndDelete(arg0)

        while (confIter.hasNext()) {
            Conference conf = mapper.fromDBObject(Conference.class, confIter.next()); // OK, jusqu'à version 1.0
        }

    }

}
