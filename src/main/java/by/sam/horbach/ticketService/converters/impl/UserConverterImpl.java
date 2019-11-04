package by.sam.horbach.ticketService.converters.impl;

import java.nio.file.Paths;

import by.sam.horbach.ticketService.converters.UserConverter;
import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.entities.UserRoles;

public class UserConverterImpl implements UserConverter {

	@Override
	public Class<User> getSourceClass() {
		return User.class;
	}

	@Override
	public Class<UserDTO> getTargetClass() {
		return UserDTO.class;
	}

	@Override
	public UserDTO convertSourceToTargetClass(Object source, Class<?> targetClass) throws Exception {
		User user = (User) source;
		return new UserDTO(user.getId(), user.getEmail(), user.getPassword(), user.isEnabled(), user.getName(),
				user.getSurname(), UserRoles.getRoleById(user.getIdRole()), Paths.get(user.getIconPath()));
	}

	@Override
	public User convertTargetToSourceClass(Object target, Class<?> sourceClass) throws Exception {
		UserDTO userDTO = (UserDTO) target;
		return new User(userDTO.getId(), userDTO.getEmail(), userDTO.getPassword(), userDTO.isEnabled(),
				userDTO.getName(), userDTO.getSurname(), userDTO.getRole().getId(), userDTO.getIconPath().toString());
	}

}
