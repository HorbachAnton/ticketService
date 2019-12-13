package by.sam.horbach.ticketService.facades.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.dto.PaginationEventDTO;
import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.facades.EventCenterFacade;
import by.sam.horbach.ticketService.services.EventService;

public class EventCenterFacadeImpl implements EventCenterFacade {

	private static final Logger LOGGER = LogManager.getLogger(EventCenterFacadeImpl.class);
	private static final String CONVERT_LIST_EVENT_ERROR_MESSAGE = "Failed to convert List<Event> in List<DTO>";

	private static final int EVENTS_NUMBER_ON_PAGE = 6;

	private static final int FIRST_EVENT_DEFAULT_VALUE = 0;
	private static final int LAST_EVENT_DEFAULT_VALUE = 6;

	private EventService eventService;
	private TwoWayConverter eventListConverter;

	public PaginationEventDTO getPaginationEventDTO(int chosenPage) {
		List<Event> eventList = eventService.getEvents();

		PaginationEventDTO paginationEventDTO = new PaginationEventDTO();
		paginationEventDTO.setPagesNumber((int) Math.ceil(((double) eventList.size()) / 6));
		paginationEventDTO.setEventDTOList(convertEventDTOListToEventList(getEventSubList(eventList, chosenPage)));
		
		return paginationEventDTO;
	}

	private List<Event> getEventSubList(List<Event> eventList, int chosenPage) {
		List<Event> pagginationEventList = null;

		if (chosenPage == 1) {
			pagginationEventList = getEventSubList(eventList, FIRST_EVENT_DEFAULT_VALUE, LAST_EVENT_DEFAULT_VALUE);
		} else {
			int lastEvent = chosenPage * EVENTS_NUMBER_ON_PAGE;
			pagginationEventList = getEventSubList(eventList, lastEvent - EVENTS_NUMBER_ON_PAGE, lastEvent);
		}

		return pagginationEventList;
	}

	private List<Event> getEventSubList(List<Event> eventList, int firstEvent, int lastEvent) {
		List<Event> pagginationEventList = null;

		if (eventList.size() > lastEvent || eventList.size() == lastEvent) {
			pagginationEventList = eventList.subList(firstEvent, lastEvent);
		} else {
			pagginationEventList = eventList.subList(firstEvent, eventList.size() - 1);
		}

		return pagginationEventList;
	}

	@SuppressWarnings("unchecked")
	private List<EventDTO> convertEventDTOListToEventList(List<Event> eventList) {
		List<EventDTO> eventDTOList = null;

		try {
			eventDTOList = (List<EventDTO>) eventListConverter.convertSourceToTargetClass(eventList, List.class);
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
