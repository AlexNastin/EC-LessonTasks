package com.lesson9.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personal_card")
@AttributeOverride(name = "id", column = @Column(name = "id_personal_card"))
public class PersonalCard extends BaseEntity {

    private int age;

    private double averageScore;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Student student;

    public PersonalCard() {
    }

    public PersonalCard(int age, double averageScore, Gender gender, Student student) {
        this.age = age;
        this.averageScore = averageScore;
        this.gender = gender;
        this.student = student;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonalCard that = (PersonalCard) o;
        return age == that.age &&
                Double.compare(that.averageScore, averageScore) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age, averageScore);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonalCard{");
        sb.append("age=").append(age);
        sb.append(", averageScore=").append(averageScore);
        sb.append('}');
        return sb.toString();
    }
}
