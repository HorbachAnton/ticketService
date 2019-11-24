package by.sam.horbach.ticketService.dao;

import java.util.List;

import by.sam.horbach.ticketService.entities.Event;

/**
 * A class implementing this interface must implement database operations
 * associated with the Event entity.
 * 
 * @author Horach Anton
 *
 */
public interface EventDao extends IAbstractBaseDao {

	/**
	 * Returns a list of events from the database.
	 * 
	 * @return a list of events
	 */
	List<Event> getEvents();

	/**
	 * Returns a list of upcoming events from the database.
	 * 
	 * @return a list of upcoming events
	 */
	List<Event> getUpcomingEvents();

}
