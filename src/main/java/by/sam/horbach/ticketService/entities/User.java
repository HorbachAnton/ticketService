package by.sam.horbach.ticketService.entities;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -7058462798911073661L;

	private int id;
	private String email;
	private String password;
	private boolean enabled;
	private String name;
	private String surname;
	private int idRole;
	private String iconPath;

	public User() {

	}

	public User(int id, String email, String password, boolean enabled, String name, String surname, int idRole,
			String iconPath) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.name = name;
		this.surname = surname;
		this.idRole = idRole;
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

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (email == null ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + (iconPath == null ? 0 : iconPath.hashCode());
		result = prime * result + id;
		result = prime * result + idRole;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (password == null ? 0 : password.hashCode());
		result = prime * result + (surname == null ? 0 : surname.hashCode());
		return result;
	}

}
