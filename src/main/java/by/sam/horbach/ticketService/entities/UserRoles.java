package by.sam.horbach.ticketService.entities;

public enum UserRoles {
	
	Consumer(1), Administrator(2);
	
	private final int id;
	
	private UserRoles(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

}
