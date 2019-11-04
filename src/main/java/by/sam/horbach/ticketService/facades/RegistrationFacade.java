package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.converters.UserConverter;
import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

public class RegistrationFacade {

	UserConverter userConverter;
	UserService userService;

	public void register(UserDTO userDTO) {
		try {
			User user = userConverter.convertTargetToSourceClass(userDTO, User.class);
			userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserConverter getUserConverter() {
		return userConverter;
	}

	public void setUserConverter(UserConverter userConverter) {
		this.userConverter = userConverter;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
