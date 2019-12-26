package by.sam.horbach.ticketService.services;

import java.util.List;

import by.sam.horbach.ticketService.entities.Ticket;

public interface TicketService {
	
	void buyTickets(List<Ticket> ticketsList);
	
	List<Ticket> getTickets();

}
