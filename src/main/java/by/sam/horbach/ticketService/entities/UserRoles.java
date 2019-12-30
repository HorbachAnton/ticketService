package by.sam.horbach.ticketService.entities;

public enum UserRoles {

	NOT_INSTALLED(0), CONSUMER(1), ADMINISTRATOR(2);

	private final int id;

	private UserRoles(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static UserRoles getRoleById(int id) {
		return id == 1 ? UserRoles.CONSUMER : UserRoles.ADMINISTRATOR;
	}

}
