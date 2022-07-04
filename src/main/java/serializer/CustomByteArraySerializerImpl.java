package serializer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class CustomByteArraySerializerImpl implements CustomByteArraySerializer {
    public byte[] serialize(Object o) {

        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOut)) {
            out.writeObject(o);
            out.flush();
            byte[] data = byteOut.toByteArray();
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't serialize object", e);
        }
    }
}
