package breizhcamp2016;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(noClassnameStored = true)
public class Conference {

    @Id
    @JsonProperty("_id")
    public String id;

    public String title;

    public List<String> speakerIds;


    public Conference() {
    }


    public Conference(String id, String title, List<String> speakerIds) {
        this.id = id;
        this.title = title;
        this.speakerIds = speakerIds;
    }


    public Conference(String title, List<String> speakerIds) {
        this.title = title;
        this.speakerIds = speakerIds;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Conference [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", speakerIds=");
        builder.append(speakerIds);
        builder.append("]");
        return builder.toString();
    }

}
