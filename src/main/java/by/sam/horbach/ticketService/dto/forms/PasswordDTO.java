package by.sam.horbach.ticketService.dto.forms;

public class PasswordDTO {

	private String password;
	private String confirmPassword;

	public PasswordDTO() {

	}

	public PasswordDTO(String password, String confirmPassword) {
		super();
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
