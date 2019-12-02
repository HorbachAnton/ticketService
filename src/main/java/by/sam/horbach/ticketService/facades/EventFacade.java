package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.dto.EventDTO;

public interface EventFacade {

	EventDTO getEventById(Integer eventId);

}
