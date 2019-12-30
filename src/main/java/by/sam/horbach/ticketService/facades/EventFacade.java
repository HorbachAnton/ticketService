package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.dto.forms.BuyTicketsDTO;

public interface EventFacade {

	EventDTO getEventById(Integer eventId);

	void buyTickets(BuyTicketsDTO buyTicketsDTO);

}
