package com.lesson9.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student", indexes = {@Index(name = "idx_student_name", columnList = "name")})
@AttributeOverride(name = "id", column = @Column(name = "id_student"))
public class Student extends BaseEntity {

    private String name;

    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonalCard personalCard;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(name = "student_course", joinColumns = {@JoinColumn(name = "id_student")},
            inverseJoinColumns = {@JoinColumn(name = "id_course")})
    private List<Course> courses;

    public Student() {
    }

    public Student(String name, String surname, Group group, PersonalCard personalCard, List<Course> courses) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.personalCard = personalCard;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public PersonalCard getPersonalCard() {
        return personalCard;
    }

    public void setPersonalCard(PersonalCard personalCard) {
        this.personalCard = personalCard;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
