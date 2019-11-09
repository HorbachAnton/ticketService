package by.sam.horbach.ticketService.entities;

public class Comment {

	private int id;
	private int idUser;
	private int idEvent;
	private String text;

	public Comment() {

	}

	public Comment(int id, int idUser, int idEvent, String text) {
		this.id = id;
		this.idUser = idUser;
		this.idEvent = idEvent;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idEvent;
		result = prime * result + idUser;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Comment other = (Comment) obj;
		if (id != other.id)
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", idUser=" + idUser + ", idEvent=" + idEvent + ", text=" + text + "]";
	}

}
