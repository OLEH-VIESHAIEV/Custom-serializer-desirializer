package model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Address implements Serializable {
    private String city;
    private String street;
    private Integer building;
    private Map<Long, Integer> zipCodes;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Map<Long, Integer> getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(Map<Long, Integer> zipCodes) {
        this.zipCodes = zipCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(city, address.city)
                && Objects.equals(street, address.street)
                && Objects.equals(building, address.building)
                && Objects.equals(zipCodes, address.zipCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, building, zipCodes);
    }

    @Override
    public String toString() {
        return "model.Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", building=" + building
                + ", zipCodes=" + zipCodes
                + '}';
    }
}
