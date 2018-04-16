package yyl.springboot.sevice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import yyl.springboot.pojo.User;

@Service
public class UserService {

	private Map<String, User> users = new ConcurrentHashMap<>();

	public User getByUsername(String username) {
		return users.get(username);
	}

	@PostConstruct
	public void afterPropertiesSet() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("password");
		user.setRoles(new String[] { "admin" });
		user.setPermissions(new String[] { "permission:page1" });
		users.put(user.getUsername(), user);
	}
}