package by.sam.horbach.ticketService.entities;

import java.io.Serializable;

public class Ticket implements Serializable {

	private static final long serialVersionUID = 4252623676898191747L;

	private int id;
	private Event event;
	private User user;

	public Ticket() {

	}

	public Ticket(int id, Event event, User user) {
		super();
		this.id = id;
		this.event = event;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
