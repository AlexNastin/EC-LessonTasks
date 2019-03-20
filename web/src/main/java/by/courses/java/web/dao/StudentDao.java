import java.util.List;

public interface StudentDao {

    Student save(Student student);

    Student update(Student student);

    Student get(Long id);

    List<Student> getAll();
}
