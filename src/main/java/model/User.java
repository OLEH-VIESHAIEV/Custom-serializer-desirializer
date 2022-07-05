package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private LocalDate birthDate;
    private List<Address> addresses;

    public User() {
    }

    public User(String name, LocalDate birthDate, List<Address> addresses) {
        this.name = name;
        this.birthDate = birthDate;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddresses() {

        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(birthDate, user.birthDate)
                && Objects.equals(addresses, user.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, addresses);
    }

    @Override
    public String toString() {
        return "model.User{"
                    + "name='" + name + '\''
                    + ", birthDate=" + birthDate
                    + ", addresses=" + addresses
                    + '}';
    }
}

