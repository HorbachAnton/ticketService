package by.sam.horbach.ticketService.dao;

import java.util.List;

import by.sam.horbach.ticketService.entities.Ticket;

/**
 * A class implementing this interface must implement database operations
 * associated with the Ticket entity.
 * 
 * @author Horbach Anton
 *
 */
public interface TicketDao extends IAbstractBaseDao {

	List<Ticket> getTickets();

}
