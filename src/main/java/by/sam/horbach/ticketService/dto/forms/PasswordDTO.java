package by.sam.horbach.ticketService.dto.forms;

public class PasswordDTO {
	
	private String password;
	
	public PasswordDTO() {
		
	}

	public PasswordDTO(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
