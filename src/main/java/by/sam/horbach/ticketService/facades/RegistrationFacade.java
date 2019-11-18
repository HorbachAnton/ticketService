package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

public class RegistrationFacade {

	private static final String ERROR_MESSAGE= "Failed to convert UserDTO in User";
	private static final Logger LOGGER = LogManager.getLogger(RegistrationFacade.class);
	
	TwoWayConverter userConverter;
	UserService userService;
	
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
