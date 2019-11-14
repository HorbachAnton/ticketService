package by.sam.horbach.ticketService.dto;

import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.entities.User;

public class TicketDTO {

	private int id;
	private Event event;
	private User user;

	public TicketDTO() {

	}

	public TicketDTO(int id, Event event, User user) {
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
