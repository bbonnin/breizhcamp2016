package breizhcamp2016;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class ConferenceCodecProvider implements CodecProvider {

    @Override
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (clazz == Conference.class) {
            return (Codec<T>) new ConferenceCodec();
        }
        return null;
    }

}
