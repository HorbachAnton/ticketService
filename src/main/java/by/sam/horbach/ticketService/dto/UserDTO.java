package by.sam.horbach.ticketService.dto;

import java.nio.file.Path;

import by.sam.horbach.ticketService.entities.UserRoles;

public class UserDTO {

	private int id;
	private String email;
	private String password;
	private boolean enabled;
	private String name;
	private String surname;
	private UserRoles role;
	private Path iconPath;

	public UserDTO() {
	}

	public UserDTO(int id, String email, String password, boolean enabled, String name, String surname, UserRoles role, Path iconPath) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.name = name;
		this.surname = surname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
