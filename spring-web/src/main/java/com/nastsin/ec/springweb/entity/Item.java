package com.nastsin.ec.springweb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Item extends BaseEntity {

    @NotNull
    private String title;

    @ManyToOne
    private User user;

    public Item() {
    }

    public Item(String name) {
        this.title = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Item item = (Item) o;

        return title != null ? title.equals(item.title) : item.title == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        sb.append(", name='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
