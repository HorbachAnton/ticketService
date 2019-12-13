package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.dto.PaginationEventDTO;

public interface EventCenterFacade {

	public PaginationEventDTO getPaginationEventDTO(int chosenPage);

	void deleteEvent(int eventId);

}
