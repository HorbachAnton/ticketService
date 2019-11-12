package by.sam.horbach.ticketService.dao;

import java.util.List;

import by.sam.horbach.ticketService.entities.Event;

public interface EventDao extends IAbstractBaseDao {
	
	List<Event> getEvents();

}
