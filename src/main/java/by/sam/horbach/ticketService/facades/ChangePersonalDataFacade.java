package by.sam.horbach.ticketService.facades;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.forms.PersonalDataDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

public class ChangePersonalDataFacade {

	private static final String ERROR_MESSAGE = "Failed to convert personalDataDTO in User";
	private static final Logger LOGGER = LogManager.getLogger(ChangePersonalDataFacade.class);

	TwoWayConverter converter;
	UserService userService;

	public void changePersonalData(PersonalDataDTO personalDataDTO) {
		try {
			User user = (User) converter.convertSourceToTargetClass(personalDataDTO, User.class);
			userService.changePersonalData(user);
		} catch (Exception exception) {
			LOGGER.error(ERROR_MESSAGE, exception);
		}

	}

	public void setConverter(TwoWayConverter converter) {
		this.converter = converter;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
