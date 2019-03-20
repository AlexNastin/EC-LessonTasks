package com.lesson9.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course", indexes = {@Index(name = "idx_course_title", columnList = "title")})
@AttributeOverride(name = "id", column = @Column(name = "id_course"))
public class Course extends BaseEntity {

    private String title;

    private String description;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {
    }

    public Course(String title, String description, List<Student> students) {
        this.title = title;
        this.description = description;
        this.students = students;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Course course = (Course) o;
        return Objects.equals(title, course.title) &&
                Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, description);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
