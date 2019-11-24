package by.sam.horbach.ticketService.converters;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.LocationDTO;
import by.sam.horbach.ticketService.entities.Location;

/**
 * Converts Location to LocationDTO and vice versa.
 * 
 * @author Horbach Anton
 *
 */
public class LocationConverter implements TwoWayConverter {

	@Override
	public Class<Location> getSourceClass() {
		return Location.class;
	}

	@Override
	public Class<LocationDTO> getTargetClass() {
		return LocationDTO.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) {
		Location sourceLocation = (Location) source;

		LocationDTO target = new LocationDTO();
		target.setId(sourceLocation.getId());
		target.setTitle(sourceLocation.getTitle());

		return target;
	}

	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) {
		LocationDTO targetDTO = new LocationDTO();

		Location source = new Location();
		source.setId(targetDTO.getId());
		source.setTitle(targetDTO.getTitle());

		return source;
	}

}
