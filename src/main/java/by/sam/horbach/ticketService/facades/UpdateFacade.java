package by.sam.horbach.ticketService.facades;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.services.UserService;

public class UpdateFacade {

	TwoWayConverter userConverter;
	UserService userService;

	public UserDTO getUserByEmail(String userEmail) {
		UserDTO userDTO = null;
		try {
			userDTO = (UserDTO) userConverter.convertSourceToTargetClass(userService.getUserByEmail(userEmail), UserDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;

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
