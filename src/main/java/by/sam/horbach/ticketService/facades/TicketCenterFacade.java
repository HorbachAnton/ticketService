package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.dto.PaginationTicketDTO;

public interface TicketCenterFacade {

	PaginationTicketDTO getPaginationTicketDTO(int chosenPage);

}
