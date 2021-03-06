package by.sam.horbach.ticketService.services;

import java.util.List;

import by.sam.horbach.ticketService.entities.Event;

public interface EventService {

	Event getEventById(Integer eventID);

	List<Event> getEvents();

	List<Event> getUpcomingEvents();

	void saveEvent(Event event);

	void deleteEvent(int eventId);

	void updateEvent(Event event);

}
