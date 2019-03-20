
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class DefaultStudentDao implements StudentDao{

    private final Storage storage;

    private Random random = new Random();

    @Autowired
    public DefaultStudentDao(Storage storage) {
        this.storage = storage;
    }

    public Student save(Student student) {
        student.setId(random.nextLong());
        return storage.getStorage().put(student.getId(), student);
    }

    public Student update(Student student) {
        return storage.getStorage().put(student.getId(), student);
    }

    public Student get(Long id){
        return storage.getStorage().get(id);
    }

    public List<Student> getAll(){
        return new ArrayList<>(storage.getStorage().values());
    }
}
