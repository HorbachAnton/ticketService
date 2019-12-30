package by.sam.horbach.ticketService.facades.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.facades.RegistrationFacade;
import by.sam.horbach.ticketService.services.UserService;

public class RegistrationFacadeImpl implements RegistrationFacade {

	private static final String ERROR_MESSAGE = "Failed to convert UserDTO in User";
	private static final Logger LOGGER = LogManager.getLogger(RegistrationFacadeImpl.class);

	TwoWayConverter userConverter;
	UserService userService;

	@Override
	public void register(UserDTO userDTO) {
		try {
			User user = (User) userConverter.convertTargetToSourceClass(userDTO, User.class);
			userService.register(user);
		} catch (Exception exception) {
			LOGGER.error(ERROR_MESSAGE, exception);
		}
	}

	public void setUserConverter(TwoWayConverter userConverter) {
		this.userConverter = userConverter;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
