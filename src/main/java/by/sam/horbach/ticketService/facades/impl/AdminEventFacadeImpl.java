package by.sam.horbach.ticketService.facades.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.facades.AdminEventFacade;
import by.sam.horbach.ticketService.services.EventService;

public class AdminEventFacadeImpl implements AdminEventFacade {

	private static final String ERROR_MESSAGE = "Failed to convert Event in EventDTO";
	private static final Logger LOGGER = LogManager.getLogger(AdminEventFacadeImpl.class);

	TwoWayConverter eventConverter;
	EventService eventService;

	@Override
	public EventDTO getEvent(int eventId) {
		EventDTO eventDTO = null;

		try {
			Event event = eventService.getEventById(eventId);
			eventDTO = (EventDTO) eventConverter.convertSourceToTargetClass(event, EventDTO.class);
		} catch (Exception exception) {
			LOGGER.error(ERROR_MESSAGE, exception);
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
