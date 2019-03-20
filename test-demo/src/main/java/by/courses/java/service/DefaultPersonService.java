package by.courses.java.service;

import by.courses.java.exception.NotPersonException;
import by.courses.java.exception.PersonNotFoundException;
import by.courses.java.dao.DefaultPersonDao;
import by.courses.java.dao.PersonDao;
import by.courses.java.dto.Employer;
import by.courses.java.entity.Person;

import java.util.UUID;

public class DefaultPersonService implements PersonService {

  private PersonDao personDao = new DefaultPersonDao();

  @Override
  public UUID save(Employer employer) {
    Person person = createPerson(employer);
    String id = personDao.savePerson(person);
    return UUID.fromString(id);
  }

  @Override
  public Person get(UUID uuid) {
    Person person = null;
    try {
      person = personDao.getPerson(uuid.toString());
    } catch (PersonNotFoundException | NotPersonException e) {
      System.err.println("ERROR");
    }
    return person;
  }

  private Person createPerson(Employer employer) {
    return new Person(employer.getName(), (byte) employer.getAge());
  }
}