package by.courses.java;

import by.courses.java.dao.DefaultPersonDao;
import by.courses.java.entity.Person;
import by.courses.java.exception.NotPersonException;
import by.courses.java.exception.PersonNotFoundException;

import java.util.UUID;

public class Main {

  public static void main(String[] args) {

    Person person = new Person("Alex", (byte) 26);

    DefaultPersonDao defaultPersonDao = new DefaultPersonDao();

    String id = defaultPersonDao.savePerson(person);

    try {
      Person getPerson = defaultPersonDao.getPerson(id);
      System.out.println(getPerson);
    } catch (PersonNotFoundException | NotPersonException e) {
      e.printStackTrace();
    }

    try {
      defaultPersonDao.getPerson(UUID.randomUUID().toString());
    } catch (PersonNotFoundException | NotPersonException e) {
      e.printStackTrace();
    }
  }
}