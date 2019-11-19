package by.sam.horbach.ticketService.converters;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.forms.PersonalDataDTO;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

public class PersonalDataDTOConverter implements TwoWayConverter {

	UserService userService;

	@Override
	public Class<PersonalDataDTO> getSourceClass() {
		return PersonalDataDTO.class;
	}

	@Override
	public Class<User> getTargetClass() {
		return User.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) {
		PersonalDataDTO sourceDTO = (PersonalDataDTO) source;

		User targetUser = userService.getCurrentUser();
		targetUser.setName(sourceDTO.getName());
		targetUser.setSurname(sourceDTO.getSurname());

		return targetUser;
	}

	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) {
		User targetUser = (User) target;

		PersonalDataDTO personalDataDTO = new PersonalDataDTO();
		personalDataDTO.setName(targetUser.getName());
		personalDataDTO.setSurname(targetUser.getSurname());

		return personalDataDTO;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
