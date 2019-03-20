package by.courses.java.simple.entity;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Item extends BaseEntity{

    @Basic(optional = false)
    private String name;

    @ManyToOne
    private User user;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
            Objects.equals(user, item.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, user);
    }

    @Override
    public String toString() {
        return "Item{" +
            "name='" + name + '\'' +
            ", user=" + user +
            '}';
    }
}
