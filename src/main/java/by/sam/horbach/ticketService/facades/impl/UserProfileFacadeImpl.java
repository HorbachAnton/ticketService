package by.sam.horbach.ticketService.facades.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;
import org.springframework.security.core.context.SecurityContextHolder;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.facades.UserProfileFacade;
import by.sam.horbach.ticketService.services.UserService;

public class UserProfileFacadeImpl implements UserProfileFacade {

	private static final String ERROR_MESSAGE = "Failed to convert User in UserDTO";
	private static final Logger LOGGER = LogManager.getLogger(UserProfileFacadeImpl.class);

	TwoWayConverter userConverter;
	UserService userService;

	@Override
	public UserDTO getUserByEmail() {
		UserDTO userDTO = null;
		try {
			userDTO = (UserDTO) userConverter.convertSourceToTargetClass(
					userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()),
					UserDTO.class);
		} catch (Exception exception) {
			LOGGER.error(ERROR_MESSAGE, exception);
		}
		return userDTO;

	}

	public void setUserConverter(TwoWayConverter userConverter) {
		this.userConverter = userConverter;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
