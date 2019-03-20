package by.courses.java.simple.entity;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Address extends BaseEntity{

    @Basic(optional = false)
    private String street;
    @Basic(optional = false)
    private String city;

    @OneToOne
    private User user;

    protected Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
            Objects.equals(city, address.city) &&
            Objects.equals(user, address.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), street, city, user);
    }

    @Override
    public String toString() {
        return "Address{" +
            "street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", user=" + user +
            '}';
    }
}