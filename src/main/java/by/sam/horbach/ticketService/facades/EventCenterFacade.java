package by.sam.horbach.ticketService.facades;

import java.util.List;

import by.sam.horbach.ticketService.dto.EventDTO;

public interface EventCenterFacade {

	public List<EventDTO> getEventList();

}
