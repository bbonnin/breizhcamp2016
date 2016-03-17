package breizhcamp2016;

import java.util.Arrays;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(noClassnameStored = true)
public class Conference {

    @Id
    public String id;

    public String title;

    public String[] speakers;

    public Conference() {

    }

    public Conference(String title, String... speakers) {
        this.title = title;
        this.speakers = speakers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Conference [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", speakers=");
        builder.append(Arrays.toString(speakers));
        builder.append("]");
        return builder.toString();
    }

}
