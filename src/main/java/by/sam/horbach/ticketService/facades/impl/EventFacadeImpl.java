package by.sam.horbach.ticketService.facades.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.facades.EventFacade;
import by.sam.horbach.ticketService.services.EventService;

public class EventFacadeImpl implements EventFacade{

	TwoWayConverter eventConverter;
	EventService eventService;

	private static final String CONVERT_EVENT_ERROR_MESSAGE = "Failed to convert Event in EventDTO";
	private static final Logger LOGGER = LogManager.getLogger(EventFacadeImpl.class);

	public EventDTO getEventById(Integer eventId) {
		EventDTO eventDTO = null;

		try {
			eventDTO = (EventDTO) eventConverter.convertSourceToTargetClass(eventService.getEventById(eventId),
					EventDTO.class);
		} catch (Exception exception) {
			LOGGER.error(CONVERT_EVENT_ERROR_MESSAGE, exception);
		}

		return eventDTO;
	}

	public void setEventConverter(TwoWayConverter eventConverter) {
		this.eventConverter = eventConverter;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

}
