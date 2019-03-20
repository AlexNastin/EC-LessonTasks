package by.courses.java.stream.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class User {

    private String name;
    private String secondName;
    private int age;
    private Map<Relation, List<User>> relations;
    private List<String> hobbies;
}
