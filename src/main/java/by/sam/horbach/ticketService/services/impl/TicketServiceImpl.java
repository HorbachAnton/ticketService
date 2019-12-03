package by.sam.horbach.ticketService.services.impl;

import java.util.List;

import by.sam.horbach.ticketService.dao.TicketDao;
import by.sam.horbach.ticketService.entities.Ticket;
import by.sam.horbach.ticketService.services.TicketService;

public class TicketServiceImpl implements TicketService {

	TicketDao ticketDao;

	public void buyTickets(List<Ticket> ticketsList) {
		for (int j = 0; j < ticketsList.size(); j++) {
			ticketDao.save(ticketsList.get(j));
		}
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

}
