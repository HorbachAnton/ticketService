package by.sam.horbach.ticketService.entities;

public enum UserRoles {
	
	CONSUMER(1), ADMINISTRATOR(2), GUEST(3);
	
	private final int id;
	
	private UserRoles(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

}
