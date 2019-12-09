package by.sam.horbach.ticketService.dao.impl;

import java.util.List;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.EventDao;
import by.sam.horbach.ticketService.entities.Event;

/**
 * A class implementing database operations associated with the Event entity.
 * 
 * @author Horbach Anton
 *
 */
public class EventDaoImpl extends AbstractBaseDao implements EventDao {

	private static final String QUERY_LIST_ALL_EVENTS = "select * from event";
	private static final String QUERY_LIST_UPCOMING_EVENTS = "select * from event order by date desc limit 4";

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents() {
		return getCurrentSession().createSQLQuery(QUERY_LIST_ALL_EVENTS).addEntity(Event.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getUpcomingEvents() {
		return getCurrentSession().createSQLQuery(QUERY_LIST_UPCOMING_EVENTS).addEntity(Event.class).list();
	}

}
