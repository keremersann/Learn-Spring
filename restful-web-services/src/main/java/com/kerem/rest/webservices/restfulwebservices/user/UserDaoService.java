package com.kerem.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int count = 0;
	
	static {
		users.add(new User(++count, "Kerem", LocalDate.now().minusYears(30)));
		users.add(new User(++count, "Mars", LocalDate.now().minusYears(25)));
		users.add(new User(++count, "Venüs", LocalDate.now().minusYears(20)));
	}
	
	public void save(User user) {
		user.setId(++count);
		users.add(user);
	}
	
	public List<User> findAll(){
		return users;
	}

	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}
	
}
