package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.dto.EventDTO;

public interface AdminEventFacade {

	EventDTO getEvent(int eventId);
	
	void changeEventDetails(EventDTO eventDTO); 

}
