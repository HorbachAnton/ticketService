package by.sam.horbach.ticketService.converters;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.forms.ChangePasswordDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

public class ChangePasswordDTOConverter implements TwoWayConverter {

	UserService userService;

	@Override
	public Class<ChangePasswordDTO> getSourceClass() {
		return ChangePasswordDTO.class;
	}

	@Override
	public Class<User> getTargetClass() {
		return User.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) throws Exception {
		ChangePasswordDTO sourceDTO = (ChangePasswordDTO) source;

		User targetUser = userService.getCurrentUser();
		targetUser.setPassword(sourceDTO.getPassword());

		return targetUser;
	}

	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) throws Exception {
		User targetUser = (User) target;

		ChangePasswordDTO sourceDTO = new ChangePasswordDTO();
		sourceDTO.setPassword(targetUser.getPassword());

		return sourceDTO;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
