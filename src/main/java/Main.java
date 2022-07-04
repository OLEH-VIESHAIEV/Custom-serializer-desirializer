import deserializer.CustomByteArrayDeserializer;
import deserializer.CustomByteArrayDeserializerImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Address;
import model.User;
import serializer.CustomByteArraySerializer;
import serializer.CustomByteArraySerializerImpl;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        Map<Long, Integer> map = new HashMap<>();
        map.put(1L, 10010);
        address.setCity("Kyiv");
        address.setStreet("Peremohy");
        address.setBuilding(25);
        address.setZipCodes(map);
        List<Address> list = new ArrayList<>();
        list.add(address);

        User user = new User();
        LocalDate date = LocalDate.of(2000, 11, 30);
        user.setName("Bob");
        user.setBirthDate(date);
        user.setAddresses(list);

        CustomByteArraySerializer byteArraySerializer = new CustomByteArraySerializerImpl();
        byteArraySerializer.serialize(user);

        CustomByteArrayDeserializer byteArrayDeserializer = new CustomByteArrayDeserializerImpl();
        byteArrayDeserializer.deSerialize(byteArraySerializer.serialize(user));
    }
}
