package by.sam.horbach.ticketService.converters;

import java.nio.file.Paths;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.dto.LocationDTO;
import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.services.LocationService;

/**
 * Converts Event to EventDTO and vice versa. Allows to set the converter for
 * Location on the basis of which Location will be converted to LocationDTO.
 * Also allows to set LocationService for receiving the Location.
 * 
 * @author Horbach Anton
 *
 */
public class EventConverter implements TwoWayConverter {

	TwoWayConverter locationConverter;
	LocationService locationService;

	@Override
	public Class<Event> getSourceClass() {
		return Event.class;
	}

	@Override
	public Class<EventDTO> getTargetClass() {
		return EventDTO.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) throws Exception {
		Event sourceEvent = (Event) source;

		EventDTO target = new EventDTO();
		target.setId(sourceEvent.getId());
		target.setTitle(sourceEvent.getTitle());
		target.setSummary(sourceEvent.getSummary());
		target.setDate(sourceEvent.getDate());
		target.setLocation((LocationDTO) locationConverter.convertSourceToTargetClass(
				locationService.getLocation(sourceEvent.getIdLocation()), LocationDTO.class));
		target.setPrice(sourceEvent.getPrice());
		target.setIconPath(Paths.get(sourceEvent.getIconPath()));

		return target;
	}

	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) {
		EventDTO targetDTO = (EventDTO) target;

		Event source = new Event();
		source.setId(targetDTO.getId());
		source.setTitle(targetDTO.getTitle());
		source.setSummary(targetDTO.getSummary());
		source.setDate(targetDTO.getDate());
		source.setIdLocation(targetDTO.getLocation().getId());
		source.setPrice(targetDTO.getPrice());
		source.setIconPath(targetDTO.getIconPath().toString());

		return source;
	}

	/**
	 * Sets LocationService for receiving the Location.
	 * 
	 * @param locationService - an instance implementing the LocationService
	 *                        interface
	 */
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	/**
	 * Sets the converter for Location on the basis of which Location will be
	 * converted to LocationDTO
	 * 
	 * @param locationConverter - location converter to locationDTO
	 */
	public void setLocationConverter(TwoWayConverter locationConverter) {
		this.locationConverter = locationConverter;
	}

}
