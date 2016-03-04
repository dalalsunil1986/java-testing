package jbr.testing.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import jbr.testing.mockito.dao.DataHolder;
import jbr.testing.mockito.dto.Person;
import jbr.testing.mockito.service.PersonService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PersonService.class, Person.class, DataHolder.class })
public class PersonServiceTest {

  @Before
  public void setUp() throws Exception {
    mockPrivateClasses();
  }

  @Spy
  @InjectMocks
  PersonService personService = initPersonService();

  @Mock
  DataHolder mockedDataHolder;

  @Test
  public void testAdd() {
    final String empId = "1000";
    // GIVEN (do the required things before the actual service method called.)
    /**
     * Here i am building the required object to be stored into the database.
     */
    Person person = buildPerson();
    person.setId(empId); // setting my own id.

    /**
     * Mocking the return object of the DAO method. The meaning of the below
     * code is, when any service method which calls the dao method get() with
     * any string, i.e any empId, then return my constructed(mocked) object.
     */
    Mockito.doReturn(person).when(mockedDataHolder).get(anyString());

    // WHEN (fire the service method)
    personService.add(person); // calling the service method
    // to check retrieve the Person object with the empId.
    Person newPersonObject = personService.get(empId);

    // THEN (do the necessary testing on the retrived object.)
    Assert.assertNotNull(newPersonObject);
    Assert.assertEquals(newPersonObject.getName(), person.getName());
  }

  /**
   * Construct the Person object with required values.
   *
   * @return
   */
  private Person buildPerson() {
    Person person1 = new Person();
    person1.setId("1");
    person1.setName("one");
    person1.setAge("10");
    person1.setAddress("OneOneOne");

    return person1;
  }

  /**
   * Mock the private classes for the testing.
   */
  private void mockPrivateClasses() {
    PowerMockito.mockStatic(PersonService.class);
    PowerMockito.mockStatic(Person.class);
    PowerMockito.mockStatic(DataHolder.class);
  }

  private PersonService initPersonService() {
    return Whitebox.newInstance(PersonService.class);
  }
}
