package deserializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import deserializer.CustomByteArrayDeserializer;
import deserializer.CustomByteArrayDeserializerImpl;
import model.Address;
import model.User;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import serializer.CustomByteArraySerializer;
import serializer.CustomByteArraySerializerImpl;

class CustomByteArrayDeserializerImplTest {
    private static CustomByteArrayDeserializer deserializer;
    private static CustomByteArraySerializer serializer;
    private byte[] data;
    private User user;
    private Address address;
    private Map<Long, Integer> map;
    private LocalDate date;
    private List<Address> addresses;

    @BeforeAll
    static void beforeAll() {
        deserializer = new CustomByteArrayDeserializerImpl();
        serializer = new CustomByteArraySerializerImpl();
    }

    @BeforeEach
    void setUp() {
        user = new User();
        date = LocalDate.of(2000, 11, 30);
        addresses = new ArrayList<>();
        user.setName("Bob");
        user.setBirthDate(date);
        address = new Address();
        address.setCity("Kyiv");
        address.setStreet("Peremohy");
        address.setBuilding(25);
        map = new HashMap<>();
        map.put(1L, 10010);
        address.setZipCodes(map);
        addresses.add(address);
        user.setAddresses(addresses);
        data = serializer.serialize(user);
    }

    @Test
    void test_notEmpty_array() {
        byte[] actual = data;
        assertNotEquals(0, actual.length);
    }

    @Test
    void equal_objects_after_deserialization() {
        User expected = user;
        User actual = (User) deserializer.deSerialize(data);
        assertEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

}