package com.lesson8.dao;

import com.lesson8.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAll();

    Student get(long idStudent);

    boolean save(Student student);

    boolean update(Student student);

    void delete(Long id);
}
