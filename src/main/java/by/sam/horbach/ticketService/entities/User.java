package by.sam.horbach.ticketService.entities;

import java.nio.file.Path;

public class User {
	private int id;
	private String email;
	private String name;
	private String surname;
	private UserRoles role;
	private Path iconPath;

	public User() {

	}

	public User(int id, String email, String name, String surname, UserRoles role, Path iconPath) {
		this.id = id;
		this.email = email;
		this.name = surname;
		this.role = role;
		this.iconPath = iconPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public UserRoles getRole() {
		return role;
	}

	public void setRole(UserRoles role) {
		this.role = role;
	}

	public Path getIconPath() {
		return iconPath;
	}

	public void setIconPath(Path iconPath) {
		this.iconPath = iconPath;
	}

}
