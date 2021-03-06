package by.sam.horbach.ticketService.converters;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.forms.PasswordDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

/**
 * Converts PasswordDTO to User and vice versa. Allows to set UserService for
 * receiving the current User.
 * 
 * @author Horbach Anton
 *
 */
public class PasswordDTOConverter implements TwoWayConverter {

	UserService userService;

	@Override
	public Class<PasswordDTO> getSourceClass() {
		return PasswordDTO.class;
	}

	@Override
	public Class<User> getTargetClass() {
		return User.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) {
		PasswordDTO sourceDTO = (PasswordDTO) source;

		User targetUser = userService.getCurrentUser();
		targetUser.setPassword(sourceDTO.getPassword());

		return targetUser;
	}

	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) {
		User targetUser = (User) target;

		PasswordDTO sourceDTO = new PasswordDTO();
		sourceDTO.setPassword(targetUser.getPassword());

		return sourceDTO;
	}

	/**
	 * Sets UserService for receiving the current User.
	 * 
	 * @param userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
