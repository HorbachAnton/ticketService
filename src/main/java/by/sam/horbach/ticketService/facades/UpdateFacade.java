package by.sam.horbach.ticketService.facades;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

public class UpdateFacade {

	TwoWayConverter userConverter;
	UserService userService;

	public UserDTO getUserByEmail(String userEmail) {
		User user = userService.getUserByEmail(userEmail);
		UserDTO userDTO = null;
		try {
			userDTO = (UserDTO) userConverter.convertSourceToTargetClass(user, UserDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;

	}

	public void update() {

	}

}
