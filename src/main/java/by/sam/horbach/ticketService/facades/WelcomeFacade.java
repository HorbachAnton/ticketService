package by.sam.horbach.ticketService.facades;

import java.util.List;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.entities.Comment;
import by.sam.horbach.ticketService.services.EventService;

public class WelcomeFacade {

	TwoWayConverter eventListConverter;
	EventService eventService;

	@SuppressWarnings("unchecked")
	public List<EventDTO> getUpcomingEvents() {
		List<EventDTO> eventsDTO = null;
		
		try {
			eventsDTO = (List<EventDTO>) eventListConverter.convertSourceToTargetClass(eventService.getUpcomingEvents(), List.class);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return eventsDTO;
	}

	public List<Comment> getComments() {
		return null;
	}

	public void setEventListConverter(TwoWayConverter eventListConverter) {
		this.eventListConverter = eventListConverter;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

}
