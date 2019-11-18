package by.sam.horbach.ticketService.facades;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.entities.Comment;
import by.sam.horbach.ticketService.services.EventService;

public class WelcomeFacade {
	
	private static final String ERROR_MESSAGE = "Failed to convert List<Event> in List<DTO>";
	private static final Logger LOGGER = LogManager.getLogger(WelcomeFacade.class);

	TwoWayConverter eventListConverter;
	EventService eventService;

	@SuppressWarnings("unchecked")
	public List<EventDTO> getUpcomingEvents() {
		List<EventDTO> eventsDTO = null;
		
		try {
			eventsDTO = (List<EventDTO>) eventListConverter.convertSourceToTargetClass(eventService.getUpcomingEvents(), List.class);
		} catch (Exception exception) {
			LOGGER.error(ERROR_MESSAGE, exception);
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
