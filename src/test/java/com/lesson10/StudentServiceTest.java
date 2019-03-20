package com.lesson10;

import com.lesson9.entity.Student;
import com.lesson9.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest(classes = TestConfiguration.class)
@DataJpaTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student("Alex", "Pupkin", null, null, new ArrayList<>());
        Student save = studentService.save(student);
        assertNotNull(save);
        assertNotNull(save.getId());
        assertEquals(save.getName(), student.getName());
    }
}
