package by.sam.horbach.ticketService.dto;

import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.entities.User;

public class CommentDTO {

	private int id;
	private User user;
	private Event event;
	private String text;

	public CommentDTO() {

	}

	public CommentDTO(int id, User user, Event event, String text) {
		this.id = id;
		this.user = user;
		this.event = event;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
