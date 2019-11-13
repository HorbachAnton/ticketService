package by.sam.horbach.ticketService.services.impl;

import java.util.List;

import by.sam.horbach.ticketService.dao.EventDao;
import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.services.EventService;

public class EventServiceImpl implements EventService {

	EventDao eventDao;

	@Override
	public List<Event> getEvents() {
		return eventDao.getEvents();
	}

	@Override
	public List<Event> getUpcomingEvents() {
		return eventDao.getUpcomingEvents();
	}

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

}
