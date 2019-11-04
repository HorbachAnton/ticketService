package by.sam.horbach.ticketService.converters;

import org.springframework.core.convert.converter.Converter;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;

public class UserConverter implements Converter<UserDTO, User>{

	@Override
	public User convert(UserDTO source) {
		User user = new User();
		user.setEmail(source.getEmail());
		user.setPassword(source.getPassword());
		return user;
	}

}
