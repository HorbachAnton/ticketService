package by.sam.horbach.ticketService.facades.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.dto.LocationDTO;
import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.entities.Location;
import by.sam.horbach.ticketService.facades.AdminEventFacade;
import by.sam.horbach.ticketService.services.EventService;
import by.sam.horbach.ticketService.services.LocationService;

public class AdminEventFacadeImpl implements AdminEventFacade {

	private static final String CONVERT_IN_EVENT_DTO_ERROR_MESSAGE = "Failed to convert Event in EventDTO";
	private static final String CONVERT_IN_EVENT_ERROR_MESSAGE = "Failed to convert EventDTO in Event";
	private static final Logger LOGGER = LogManager.getLogger(AdminEventFacadeImpl.class);

	TwoWayConverter eventConverter;
	EventService eventService;
	LocationService locationService;

	@Override
	public EventDTO getEvent(int eventId) {
		EventDTO eventDTO = null;

		try {
			Event event = eventService.getEventById(eventId);
			eventDTO = (EventDTO) eventConverter.convertSourceToTargetClass(event, EventDTO.class);
		} catch (Exception exception) {
			LOGGER.error(CONVERT_IN_EVENT_DTO_ERROR_MESSAGE, exception);
		}

		return eventDTO;
	}

	@Override
	public void changeEventDetails(EventDTO eventDTO) {
		Event event = convertToEvent(eventDTO);
		eventService.updateEvent(event);

	}

	@Override
	public void addEvent(EventDTO eventDTO) {
		Event event = convertToEvent(eventDTO);
		eventService.saveEvent(event);
	}

	private Event convertToEvent(EventDTO eventDTO) {
		Event event = null;

		try {
			setupConvertingEventDTO(eventDTO);
			event = (Event) eventConverter.convertTargetToSourceClass(eventDTO, Event.class);
		} catch (Exception exception) {
			LOGGER.error(CONVERT_IN_EVENT_ERROR_MESSAGE, exception);
		}

		return event;
	}

	private void setupConvertingEventDTO(EventDTO eventDTO) {
		LocationDTO receivedLocation = eventDTO.getLocation();
		Location foundedLocation = locationService.getLocationByTitle(receivedLocation.getTitle());

		if (!isLocationExists(foundedLocation)) {
			Location savingLocation = new Location();
			savingLocation.setTitle(receivedLocation.getTitle());
			locationService.saveLocation(savingLocation);
			receivedLocation.setId(savingLocation.getId());
		} else if (foundedLocation.getId() != receivedLocation.getId()) {
			receivedLocation.setId(foundedLocation.getId());
		}

	}

	private boolean isLocationExists(Location foundedLocation) {
		boolean isLocationExist = true;

		if (foundedLocation == null) {
			isLocationExist = false;
		}

		return isLocationExist;
	}

	public void setEventConverter(TwoWayConverter eventConverter) {
		this.eventConverter = eventConverter;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

}
