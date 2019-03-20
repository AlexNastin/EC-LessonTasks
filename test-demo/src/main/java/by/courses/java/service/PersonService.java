package by.courses.java.service;

import by.courses.java.dto.Employer;
import by.courses.java.entity.Person;

import java.util.UUID;

public interface PersonService {

  UUID save(Employer employer);

  Person get(UUID uuid);
}