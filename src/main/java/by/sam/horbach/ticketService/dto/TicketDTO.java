package by.sam.horbach.ticketService.dto;

public class TicketDTO {

	private int id;
	private EventDTO eventDTO;
	private UserDTO userDTO;

	public TicketDTO() {

	}

	public TicketDTO(int id, EventDTO eventDTO, UserDTO userDTO) {
		this.id = id;
		this.eventDTO = eventDTO;
		this.userDTO = userDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EventDTO getEvent() {
		return eventDTO;
	}

	public void setEvent(EventDTO eventDTO) {
		this.eventDTO = eventDTO;
	}

	public UserDTO getUser() {
		return userDTO;
	}

	public void setUser(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
