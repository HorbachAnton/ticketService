package by.sam.horbach.ticketService.converters;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.entities.UserRoles;
import org.springframework.binding.convert.converters.TwoWayConverter;

/**
 * Converts User to UserDTO and vice versa.
 * 
 * @author Horbach Anton
 *
 */
public class UserConverter implements TwoWayConverter {

	@Override
	public Class<User> getSourceClass() {
		return User.class;
	}

	@Override
	public Class<UserDTO> getTargetClass() {
		return UserDTO.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) {
		User sourceUser = (User) source;

		UserDTO target = new UserDTO();
		target.setId(sourceUser.getId());
		target.setEmail(sourceUser.getEmail());
		target.setPassword(sourceUser.getPassword());
		target.setEnabled(sourceUser.isEnabled());
		target.setName(sourceUser.getName());
		target.setSurname(sourceUser.getSurname());
		target.setRole(UserRoles.getRoleById(sourceUser.getIdRole()));
		target.setIconPath(getIconPath(sourceUser));

		return target;
	}

	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) {
		UserDTO targetDTO = (UserDTO) target;

		User source = new User();
		source.setId(targetDTO.getId());
		source.setEmail(targetDTO.getEmail());
		source.setPassword(targetDTO.getPassword());
		source.setEnabled(targetDTO.isEnabled());
		source.setName(targetDTO.getName());
		source.setSurname(targetDTO.getSurname());
		source.setIdRole(targetDTO.getRole().getId());
		source.setIconPath(targetDTO.getIconPath().toString());

		return source;
	}

	private Path getIconPath(User user) {
		Path path = null;
		Optional<String> value = Optional.ofNullable(user.getIconPath());
		if (value.isPresent()) {
			path = Paths.get(value.get());
		}
		return path;
	}

}
