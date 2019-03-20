package com.example.springdata.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Address extends BaseEntity{

    @NotNull
    private String street;
    @NotNull
    private String city;

//    @OneToOne
//    private User user;

    protected Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Address address = (Address) o;

        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return city != null ? city.equals(address.city) : address.city == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("id='").append(this.getId()).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}