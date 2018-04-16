package yyl.springboot.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

	private String username;
	private String password;
	private String[] roles;
	private String[] permissions;

	public User() {
	}

	public User(String username, String password, String[] roles, String[] permissions) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getPermissions() {
		return permissions;
	}

	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
}