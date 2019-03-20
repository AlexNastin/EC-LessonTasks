


import java.util.List;

public interface StudentService {

    Student save(Student student);

    Student update(Student student);

    Student get(Long id);

    List<Student> getAll();
}
