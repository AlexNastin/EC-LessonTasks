package com.dao;

import com.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getStudents();

    Student getStudentById(long id);

    void saveStudent(Student student);

    void update(Student student);

    void delete(long id);
}
