package by.sam.horbach.ticketService.dto.forms;

public class ChangePasswordDTO {
	
	private String password;
	
	public ChangePasswordDTO() {
		
	}

	public ChangePasswordDTO(String password) {
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
