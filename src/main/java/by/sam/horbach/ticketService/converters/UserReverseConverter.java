package by.sam.horbach.ticketService.converters;

import org.springframework.core.convert.converter.Converter;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;

public class UserReverseConverter implements Converter<User, UserDTO>{

	@Override
	public UserDTO convert(User source) {
		return null;
	}

}
