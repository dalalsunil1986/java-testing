package jbr.testing.mockito.dao;

import java.util.HashMap;
import java.util.Map;

import jbr.testing.mockito.dto.Person;

public class DataHolder {

  public static Map<String, Person> data = new HashMap<>();

  public void add(Person person) {
    data.put(person.getId(), person);
  }

  public Person get(String id) {
    return data.get(id);
  }

  public void remove(String id) {
    data.remove(id);
  }
}
