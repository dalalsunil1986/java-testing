package jbr.testing.mockito.service;

import jbr.testing.mockito.dao.DataHolder;
import jbr.testing.mockito.dto.Person;

public class PersonService {

  private DataHolder _dataholder = new DataHolder();

  public void add(Person person) {
    _dataholder.add(person);
  }

  public void remove(String id) {
    _dataholder.remove(id);
  }

  public Person get(String id) {
    return _dataholder.get(id);
  }
}
