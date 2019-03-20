package by.courses.java;

import by.courses.java.entity.User;
import by.courses.java.service.impl.DefaultUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionApplicationTests {

	@Autowired
	private DefaultUserService userService;

	@Test
	public void save() {
		User user = new User("Alex");
		User save = userService.save(user);
		System.out.println(save);
	}

	@Test
	public void find() {
		User user = userService.findUser(2L);
		System.out.println(user);
	}

	@Test
	public void findAll() {
		List<User> users = userService.findUsers();
		users.forEach(System.out::println);
	}

	@Test
	public void delete() {
		User user = userService.findUser(2L);
		userService.delete(user);
	}
}
