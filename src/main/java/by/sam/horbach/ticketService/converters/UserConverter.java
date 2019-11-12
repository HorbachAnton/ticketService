package by.sam.horbach.ticketService.converters;

import java.nio.file.Paths;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.entities.UserRoles;
import org.springframework.binding.convert.converters.TwoWayConverter;

public class UserConverter implements TwoWayConverter {

	public static final String VALUE_FOR_NULL_FILED = "Не указано";

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
		target.setName((sourceUser.getName() != null) ? sourceUser.getName() : VALUE_FOR_NULL_FILED);
		target.setSurname((sourceUser.getSurname() != null) ? sourceUser.getSurname() : VALUE_FOR_NULL_FILED);
		target.setRole(UserRoles.getRoleById(sourceUser.getIdRole()));
		target.setIconPath(Paths.get((sourceUser.getIconPath() != null) ? sourceUser.getIconPath() : VALUE_FOR_NULL_FILED));

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
		source.setName((targetDTO.getName() != null) ? targetDTO.getName() : VALUE_FOR_NULL_FILED);
		source.setSurname((targetDTO.getSurname()) != null ? targetDTO.getSurname() : VALUE_FOR_NULL_FILED);
		source.setIdRole((targetDTO.getRole() != null) ? targetDTO.getRole().getId() : UserRoles.NOT_INSTALLED.getId());
		source.setIconPath((targetDTO.getIconPath() != null) ? targetDTO.getIconPath().toString() : VALUE_FOR_NULL_FILED);

		return source;
	}

}
