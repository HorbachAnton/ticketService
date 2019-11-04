package by.sam.horbach.ticketService.converters;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;

public interface UserConverter extends TwoWayConverter {

	@Override
	public UserDTO convertSourceToTargetClass(Object source, Class<?> targetClass) throws Exception;

	@Override
	public User convertTargetToSourceClass(Object target, Class<?> sourceClass) throws Exception;
}
