package com.lesson8.service;

import com.lesson8.entity.Student;

import java.util.List;

public interface StudentService {

    boolean save(Student student);

    List<Student> getAll();

    Student get(Long id);

    boolean update(Student student);

    void delete(Long id);
}
