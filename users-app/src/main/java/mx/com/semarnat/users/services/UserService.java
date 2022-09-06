package mx.com.semarnat.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;

import mx.com.semarnat.users.models.User;

@Service
public class UserService {
	@Autowired
	private Faker faker;
	
	private List<User> users=new ArrayList<>();
	
	@PostConstruct
	public void init() {
		for (int i = 0; i<100; i++) {
		users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
		
		}
	}
	/**
	 * Código para mi servicio
	 */
	public List<User> getUsers(String startWith){
		if (startWith != null) {
			return users.stream().filter(u-> u.getUserName().startsWith(startWith)).collect(Collectors.toList());
		} else {
			return users;
		}
		
	}
	
	public User getUserByUsername(String username) {
		return users.stream().filter(u -> u.getUserName().equals(username)).findAny().orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
						String.format("User %5 not found",username)));
	}
	 public User createUser (User user) {
		 if (users.stream().anyMatch(u-> u.getUserName().equals(user.getUserName()))) {
			 throw new ResponseStatusException(HttpStatus.CONFLICT,
					 String.format("User %5 already exists", user.getUserName()));
		 }
		 users.add(user);
		 return user;
	 }
	 
	 public User UpdateUser(User user, String username) {
		 User userToBeUpdated = getUserByUsername(username);
		 userToBeUpdated.setNickName(user.getNickName());
		 userToBeUpdated.setPassword(user.getPassword());
		 return userToBeUpdated;
	 }
	 
	 public void deletedUser(String username) {
		 User userByUsername = getUserByUsername(username);
		 users.remove(userByUsername);
	 }
}
