package com.lesson9.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student_group", indexes = {@Index(name = "idx_group_number", columnList = "number")})
@AttributeOverride(name = "id", column = @Column(name = "id_group"))
public class Group extends BaseEntity {

    private String number;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public Group() {
    }

    public Group(String number, List<Student> students) {
        this.number = number;
        this.students = students;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Group group = (Group) o;
        return Objects.equals(number, group.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
