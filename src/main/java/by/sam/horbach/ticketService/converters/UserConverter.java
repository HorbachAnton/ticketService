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
	public Object convertSourceToTargetClass(Object sourceObject, Class<?> targetClass) {
		User source = (User) sourceObject;

		UserDTO target = new UserDTO();
		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setPassword(source.getPassword());
		target.setEnabled(source.isEnabled());
		target.setName((source.getName() != null) ? source.getName() : VALUE_FOR_NULL_FILED);
		target.setSurname((source.getSurname() != null) ? source.getSurname() : VALUE_FOR_NULL_FILED);
		target.setRole(UserRoles.getRoleById(source.getIdRole()));
		target.setIconPath(Paths.get((source.getIconPath() != null) ? source.getIconPath() : VALUE_FOR_NULL_FILED));

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
		source.setIdRole(targetDTO.getRole().getId());
		source.setIconPath((targetDTO.getIconPath() != null) ? targetDTO.getIconPath().toString() : VALUE_FOR_NULL_FILED);

		return source;
	}

}
