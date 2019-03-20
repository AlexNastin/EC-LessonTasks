package by.courses.java.entity;

import java.util.Objects;

public class Person {

  private String id;

  private String name;

  private byte age;

  public Person() {
  }

  public Person(String name, byte age) {
    this.name = name;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public byte getAge() {
    return age;
  }

  public void setAge(byte age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age &&
            Objects.equals(id, person.id) &&
            Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Person{");
    sb.append("id='").append(id).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", age=").append(age);
    sb.append('}');
    return sb.toString();
  }
}