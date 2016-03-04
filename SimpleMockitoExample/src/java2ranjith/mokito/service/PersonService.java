package java2ranjith.mokito.service;

import java2ranjith.mokito.dao.PersonDao;

public class PersonService {

  private static PersonDao personDao = new PersonDao();

  public static String name() {
    return personDao.getName();
  }

  public String getAge() {
    return personDao.getAge();
  }
}
