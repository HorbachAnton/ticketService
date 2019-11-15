package by.sam.horbach.ticketService.converters;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;

public class UserRegistrationConverter implements TwoWayConverter {

	@Override
	public Class<User> getSourceClass() {
		return User.class;
	}

	@Override
	public Class<UserDTO> getTargetClass() {
		return UserDTO.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) throws Exception {
		User sourceUser = (User) source;

		UserDTO target = new UserDTO();
		target.setEmail(sourceUser.getEmail());
		target.setPassword(sourceUser.getPassword());

		return target;
	}

	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) throws Exception {
		UserDTO targetDTO = (UserDTO) target;

		User source = new User();
		source.setEmail(targetDTO.getEmail());
		source.setPassword(targetDTO.getPassword());

		return source;
	}

}
