package com.lesson9.service;

import com.lesson9.entity.Student;
import com.lesson9.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAStudentService implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public JPAStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student get(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }
}
