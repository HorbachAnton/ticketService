package by.sam.horbach.ticketService.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.TicketDao;
import by.sam.horbach.ticketService.entities.Ticket;
import by.sam.horbach.ticketService.services.TicketService;

@Transactional
public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;

	@Override
	public void buyTickets(List<Ticket> ticketsList) {
		for (Ticket element : ticketsList) {
			ticketDao.save(element);
		}
	}

	@Override
	public List<Ticket> getTickets() {
		return ticketDao.getTickets();
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

}
