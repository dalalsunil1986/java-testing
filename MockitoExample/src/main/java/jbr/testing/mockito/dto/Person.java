package jbr.testing.mockito.dto;

public class Person {

  private String _id;
  private String _name;
  private String _age;
  private String _address;

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    this._id = id;
  }

  public String getName() {
    return _name;
  }

  public void setName(String name) {
    this._name = name;
  }

  public String getAge() {
    return _age;
  }

  public void setAge(String age) {
    this._age = age;
  }

  public String getAddress() {
    return _address;
  }

  public void setAddress(String address) {
    this._address = address;
  }
}
