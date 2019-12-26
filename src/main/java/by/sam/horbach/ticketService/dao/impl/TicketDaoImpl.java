package by.sam.horbach.ticketService.dao.impl;

import java.util.List;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.TicketDao;
import by.sam.horbach.ticketService.entities.Ticket;

/**
 * A class implementing database operations associated with the Ticket entity.
 * 
 * @author Horbach Anton
 *
 */
public class TicketDaoImpl extends AbstractBaseDao implements TicketDao {

	private String GET_TICKETS_RESULT = "SELECT * FROM ticket";

	@Override
	@SuppressWarnings("unchecked")
	public List<Ticket> getTickets() {
		return getCurrentSession().createSQLQuery(GET_TICKETS_RESULT).addEntity(Ticket.class).list();
	}

}
