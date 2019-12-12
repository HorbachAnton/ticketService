package by.sam.horbach.ticketService.facades.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.facades.EventCenterFacade;
import by.sam.horbach.ticketService.services.EventService;

public class EventCenterFacadeImpl implements EventCenterFacade {

	private static final Logger LOGGER = LogManager.getLogger(EventCenterFacadeImpl.class);
	private static final String CONVERT_LIST_EVENT_ERROR_MESSAGE = "Failed to convert List<Event> in List<DTO>";

	private EventService eventService;
	private TwoWayConverter eventListConverter;

	@SuppressWarnings("unchecked")
	@Override
	public List<EventDTO> getEventList() {
		List<EventDTO> eventDTOList = null;

		try {
			eventDTOList = (List<EventDTO>) eventListConverter.convertSourceToTargetClass(eventService.getEvents(),
					List.class);
		} catch (Exception exception) {
			LOGGER.error(CONVERT_LIST_EVENT_ERROR_MESSAGE, exception);
		}

		return eventDTOList;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setEventListConverter(TwoWayConverter eventListConverter) {
		this.eventListConverter = eventListConverter;
	}

}
