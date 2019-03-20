
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
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Student get(Long id) {
        return studentDao.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }
}
