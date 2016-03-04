package java2ranjith.mokito.test;

import java2ranjith.mokito.dao.PersonDao;
import java2ranjith.mokito.service.PersonService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PersonService.class, PersonDao.class })
public class PersonServiceTest {

	@Before
	public void setUp() throws Exception {
		mockPrivateClasses();
	}

	@Spy
	@InjectMocks
	PersonService personService = initPersonService();

	@Test
	public void testAge() throws Exception {

		String age = personService.getAge();
		System.out.println(age);
		Assert.assertEquals("30", age);
	}

	private void mockPrivateClasses() {
		PowerMockito.mockStatic(PersonService.class);
		PowerMockito.mockStatic(PersonDao.class);
	}

	private PersonService initPersonService() {
		return Whitebox.newInstance(PersonService.class);
	}
}
