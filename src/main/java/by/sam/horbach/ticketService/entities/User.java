package by.sam.horbach.ticketService.entities;

import java.nio.file.Path;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import by.sam.horbach.ticketService.converters.PathConverter;
import by.sam.horbach.ticketService.converters.UserRolesConverter;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue
	@Column()
	private int id;
	@Column()
	private String email;
	@Column()
	private String password;
	@Column()
	private String name;
	@Column()
	private String surname;
	@Column(name="Role_id")
	@Convert(converter = UserRolesConverter.class)
	private UserRoles role;
	@Column()
	@Convert(converter = PathConverter.class)
	private Path iconPath;

	public User() {

	}

	public User(int id, String email, String password, String name, String surname, UserRoles role, Path iconPath) {
		this.id = id;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((iconPath == null) ? 0 : iconPath.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (iconPath == null) {
			if (other.iconPath != null)
				return false;
		} else if (!iconPath.equals(other.iconPath))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", role=" + role + ", iconPath=" + iconPath + "]";
	}

}
