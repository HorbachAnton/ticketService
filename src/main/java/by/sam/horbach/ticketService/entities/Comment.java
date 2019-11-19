package by.sam.horbach.ticketService.entities;

import java.io.Serializable;

public class Comment implements Serializable{


	private static final long serialVersionUID = 185775475888270963L;
	
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
}
