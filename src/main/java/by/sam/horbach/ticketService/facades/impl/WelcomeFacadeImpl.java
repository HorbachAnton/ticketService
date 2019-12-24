package by.sam.horbach.ticketService.facades.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.facades.WelcomeFacade;
import by.sam.horbach.ticketService.services.EventService;

public class WelcomeFacadeImpl implements WelcomeFacade {

	private static final String CONVERT_LIST_EVENT_ERROR_MESSAGE = "Failed to convert List<Event> in List<DTO>";
	private static final Logger LOGGER = LogManager.getLogger(WelcomeFacadeImpl.class);

	TwoWayConverter eventListConverter;
	EventService eventService;

	@Override
	@SuppressWarnings("unchecked")
	public List<EventDTO> getUpcomingEvents() {
		List<EventDTO> eventsDTO = null;

		try {
			eventsDTO = (List<EventDTO>) eventListConverter.convertSourceToTargetClass(eventService.getUpcomingEvents(),
					List.class);
		} catch (Exception exception) {
			LOGGER.error(CONVERT_LIST_EVENT_ERROR_MESSAGE, exception);
		}

		return eventsDTO;
	}

	public void setEventListConverter(TwoWayConverter eventListConverter) {
		this.eventListConverter = eventListConverter;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

}
