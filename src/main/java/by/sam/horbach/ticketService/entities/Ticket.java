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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idEvent;
		result = prime * result + idUser;
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
		Ticket other = (Ticket) obj;
		if (id != other.id)
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", idEvent=" + idEvent + ", idUser=" + idUser + "]";
	}

}
