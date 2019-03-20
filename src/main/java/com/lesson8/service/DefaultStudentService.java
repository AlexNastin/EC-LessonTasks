package com.lesson8.service;

import com.lesson8.dao.StudentDao;
import com.lesson8.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultStudentService implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public DefaultStudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public boolean save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student get(Long id) {
        return studentDao.get(id);
    }

    @Override
    public boolean update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public void delete(Long id) {
        studentDao.delete(id);
    }
}
