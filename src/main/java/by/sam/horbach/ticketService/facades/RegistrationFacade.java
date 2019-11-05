package by.sam.horbach.ticketService.facades;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;
import org.springframework.binding.convert.converters.TwoWayConverter;

public class RegistrationFacade {

	TwoWayConverter userConverter;
	UserService userService;

	public void register(UserDTO userDTO) {
		try {
			User user = (User) userConverter.convertTargetToSourceClass(userDTO, User.class);
			userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TwoWayConverter getUserConverter() {
		return userConverter;
	}

	public void setUserConverter(TwoWayConverter userConverter) {
		this.userConverter = userConverter;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
