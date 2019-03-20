package com.nectracker.test;

import by.courses.java.dao.PersonDao;
import by.courses.java.dto.Employer;
import by.courses.java.entity.Person;
import by.courses.java.exception.NotPersonException;
import by.courses.java.exception.PersonNotFoundException;
import by.courses.java.service.DefaultPersonService;
import by.courses.java.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.sun.tools.javac.util.Assert.checkNonNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  @InjectMocks
  private PersonService personService = new DefaultPersonService();

  @Mock
  private PersonDao personDao;

  private Employer employer;
  private Person person;
  private String id;
  private UUID uuid;

  @BeforeEach
  public void init() {
    employer = new Employer();
    employer.setAge(30);
    employer.setName("Dima");
    employer.setSurname("Pushkin");

    uuid = UUID.randomUUID();
    id = UUID.randomUUID().toString();

    person = new Person("Alex", (byte) 25);
  }

  @Test
  public void save() {
    when(personDao.savePerson(any(Person.class))).thenReturn(id);
    UUID uuid = personService.save(employer);
    checkNonNull(uuid);
  }

  @Test
  public void get() throws NotPersonException, PersonNotFoundException {
    when(personDao.getPerson(uuid.toString())).thenReturn(person);
    Person person = personService.get(uuid);
    checkNonNull(person);
  }
}