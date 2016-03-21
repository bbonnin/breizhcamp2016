package breizhcamp2016;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

public class ConferenceCodec implements Codec<Conference> {

    @Override
    public void encode(BsonWriter writer, Conference conf, EncoderContext encoderContext) {
        writer.writeStartDocument();
        if (conf.id != null) {
            writer.writeObjectId(new ObjectId(conf.id));
        }
        writer.writeString("title", conf.title);
        writer.writeEndDocument();
    }

    @Override
    public Class<Conference> getEncoderClass() {
        return Conference.class;
    }

    @Override
    public Conference decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readStartDocument();
        String id = reader.readObjectId().toString();
        String title = reader.readString("title");
        reader.readEndDocument();
        return new Conference(id, title, null);
    }

}
