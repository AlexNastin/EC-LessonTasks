package com.lesson9.service;

import com.lesson9.entity.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> getAll();

    Student get(Long id);

    Student update(Student student);

    void delete(Long id);
}
