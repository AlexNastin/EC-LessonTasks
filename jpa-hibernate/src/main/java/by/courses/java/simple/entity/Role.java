package by.courses.java.simple.entity;

import java.util.Objects;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(name, role.name) &&
            Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, users);
    }

    @Override
    public String toString() {
        return "Role{" +
            "name='" + name + '\'' +
            ", users=" + users +
            '}';
    }
}
