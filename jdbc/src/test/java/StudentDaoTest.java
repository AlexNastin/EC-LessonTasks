import com.dao.DefaultStudentDao;
import com.dao.StudentDao;
import com.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentDaoTest {

    private static final int TEST_ID = 999;
    private static final String UPDATE_TEST_NAME = "UpdateTestName";
    private static final String UPDATE_TEST_SURNAME = "UpdateTestSurname";
    private final int TEST_AGE = 15;
    private final String TEST_NAME = "TestName";
    private final String TEST_SURNAME = "TestSurname";

    private static StudentDao studentDao;
    private static Random random;

    private Student student = new Student();

    @BeforeClass
    public static void init() {
        studentDao = DefaultStudentDao.getInstance();
        random = new Random();
    }

    @Before
    public void createTestStudent() {
        student.setId(TEST_ID);
        student.setAge(TEST_AGE);
        student.setName(TEST_NAME);
        student.setSurname(TEST_SURNAME);
        studentDao.saveStudent(student);
    }

    @After
    public void removeTestStudent() {
        studentDao.delete(TEST_ID);
    }

    @Test
    public void saveStudent() throws Exception {
        student.setId(TEST_ID + 1);
        student.setAge(TEST_AGE);
        student.setName(TEST_NAME);
        student.setSurname(TEST_SURNAME);
        studentDao.saveStudent(student);

        Student student = studentDao.getStudentById(TEST_ID + 1);
        assertEquals(TEST_ID + 1, student.getId());
        assertEquals(TEST_NAME, student.getName());
        assertEquals(TEST_SURNAME, student.getSurname());
        assertEquals(TEST_AGE, student.getAge());

        studentDao.delete(TEST_ID + 1);
    }

    @Test
    public void getStudents() throws Exception {
        List<Student> students = studentDao.getStudents();
        assertNotNull(students);
        assertEquals(students.size(), 1);
    }

    @Test
    public void getStudent() throws Exception {
        Student student = studentDao.getStudentById(TEST_ID);
        assertNotNull(student);
    }

    @Test
    public void update() throws Exception {
        Student student = studentDao.getStudentById(TEST_ID);
        student.setName(UPDATE_TEST_NAME);
        student.setSurname(UPDATE_TEST_SURNAME);
        studentDao.update(student);
        Student studentUpdate = studentDao.getStudentById(TEST_ID);
        assertEquals(UPDATE_TEST_NAME, studentUpdate.getName());
        assertEquals(UPDATE_TEST_SURNAME, studentUpdate.getSurname());
    }
}
