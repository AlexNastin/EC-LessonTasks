package by.courses.java.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Item extends BaseEntity {

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
    public String toString() {
        final StringBuffer sb = new StringBuffer("Item{");
        sb.append("id='").append(this.getId()).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
