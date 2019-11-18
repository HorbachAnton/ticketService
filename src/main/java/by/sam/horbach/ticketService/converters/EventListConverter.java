package by.sam.horbach.ticketService.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.entities.Event;

public class EventListConverter implements TwoWayConverter {

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
			eventsDTO.add((EventDTO) eventConverter.convertSourceToTargetClass(event, EventDTO.class));
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

	public void setEventConverter(EventConverter eventConverter) {
		this.eventConverter = eventConverter;
	}

}
