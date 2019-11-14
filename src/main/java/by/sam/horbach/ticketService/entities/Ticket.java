package by.sam.horbach.ticketService.entities;

public class Ticket {
	
	private int id;
	private int idEvent;
	private int idUser;
	
	public Ticket() {
		
	}

	public Ticket(int id, int idEvent, int idUser) {
		this.id = id;
		this.idEvent = idEvent;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
