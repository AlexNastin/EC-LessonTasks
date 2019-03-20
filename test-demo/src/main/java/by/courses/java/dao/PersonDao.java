package by.courses.java.dao;

import by.courses.java.entity.Person;
import by.courses.java.exception.NotPersonException;
import by.courses.java.exception.PersonNotFoundException;

public interface PersonDao {

  String savePerson(Person person);

  Person getPerson(String id) throws PersonNotFoundException, NotPersonException;
}
