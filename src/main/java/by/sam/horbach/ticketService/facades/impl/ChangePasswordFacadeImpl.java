package by.sam.horbach.ticketService.facades.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.forms.PasswordDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.facades.ChangePasswordFacade;
import by.sam.horbach.ticketService.services.UserService;

public class ChangePasswordFacadeImpl implements ChangePasswordFacade {

	private static final String ERROR_MESSAGE = "Failed to convert changePasswordDTO in User";
	private static final Logger LOGGER = LogManager.getLogger(ChangePasswordFacadeImpl.class);

	TwoWayConverter converter;
	UserService userService;

	@Override
	public void changePassword(PasswordDTO changePasswordDTO) {
		User user = null;

		try {
			user = (User) converter.convertSourceToTargetClass(changePasswordDTO, User.class);
		} catch (Exception exception) {
			LOGGER.error(ERROR_MESSAGE, exception);
		}

		userService.changePassword(user);
	}

	public void setConverter(TwoWayConverter converter) {
		this.converter = converter;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
