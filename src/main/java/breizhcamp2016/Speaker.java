package breizhcamp2016;

import java.util.Arrays;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(noClassnameStored = true)
public class Speaker {

    @Id
    public String twitterHandle;

    public String name;

    public String email;

    public String[] conferences;

    public Speaker() {

    }

    public Speaker(String name) {
        this.name = name;
        String login = name.toLowerCase().replace(" ", "_");
        this.twitterHandle = "@" + login;
        this.email = login + "@breizhcamp.org";

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Speaker [twitterHandle=");
        builder.append(twitterHandle);
        builder.append(", conferences=");
        builder.append(Arrays.toString(conferences));
        builder.append("]");
        return builder.toString();
    }



}
