package deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import model.User;

public class CustomByteArrayDeserializerImpl implements CustomByteArrayDeserializer {
    public Object deSerialize(byte[] bytes) {
        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
                ObjectInputStream in = new ObjectInputStream(byteIn)) {
            User user = (User) in.readObject();
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't deserialize byte array to User", e);
        }
    }
}
