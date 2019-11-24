package by.sam.horbach.ticketService.converters;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.entities.Event;

/**
 * Converts a list of Event to list of EventDTO and vice versa. Allows to set
 * the converter for Event on the basis of which Event will be converted to
 * EventDTO.
 * 
 * @author Horbach Anton
 *
 */
public class EventListConverter implements TwoWayConverter {

	private static final String ERROR_MESSAGE = "Failed to convert List<Event> in List<EventDTO>";
	private static final Logger LOGGER = LogManager.getLogger(EventListConverter.class);

	EventConverter eventConverter;

	@Override
	public Class<?> getSourceClass() {
		return List.class;
	}

	@Override
	public Class<?> getTargetClass() {
		return List.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) {
		List<Event> events = (List<Event>) source;

		List<EventDTO> eventsDTO = new ArrayList<>(events.size());

		events.forEach(event -> {
			try {
				eventsDTO.add((EventDTO) eventConverter.convertSourceToTargetClass(event, EventDTO.class));
			} catch (Exception exception) {
				LOGGER.error(ERROR_MESSAGE, exception);
			}
		});

		return eventsDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) {
		List<EventDTO> eventsDTO = (List<EventDTO>) target;

		List<Event> events = new ArrayList<>(eventsDTO.size());

		eventsDTO.forEach(eventDTO -> {
			events.add((Event) eventConverter.convertTargetToSourceClass(eventDTO, Event.class));
		});

		return events;
	}

	/**
	 * Sets the converter for Event on the basis of which Event will be converted to
	 * EventDTO.
	 * 
	 * @param eventConverter - event converter to eventDTO
	 */
	public void setEventConverter(EventConverter eventConverter) {
		this.eventConverter = eventConverter;
	}

}
