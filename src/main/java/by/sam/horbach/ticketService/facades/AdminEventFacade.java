package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.dto.EventDTO;

public interface AdminEventFacade {

	public EventDTO getEvent(int eventId);

}
