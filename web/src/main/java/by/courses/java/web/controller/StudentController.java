
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/project/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Student get(@PathVariable("id") Long id) {
        return studentService.get(id);
    }
}
