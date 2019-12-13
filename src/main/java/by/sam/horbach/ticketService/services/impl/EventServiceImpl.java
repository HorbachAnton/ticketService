package by.sam.horbach.ticketService.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.EventDao;
import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.services.EventService;

@Transactional
public class EventServiceImpl implements EventService {

	private EventDao eventDao;

	@Override
	public Event getEventById(Integer eventID) {
		return (Event) eventDao.getById(Event.class, eventID.intValue());
	}

	@Override
	public List<Event> getEvents() {
		return eventDao.getEvents();
	}

	@Override
	public List<Event> getUpcomingEvents() {
		return eventDao.getUpcomingEvents();
	}

	@Override
	public void deleteEvent(int eventId) {
		eventDao.delete(getEventById(eventId));
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

}
