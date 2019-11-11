package by.sam.horbach.ticketService.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.dto.UserDTO;

public class UpdateValidator implements Validator {

	UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;

		if (StringUtils.isBlank(userDTO.getEmail())) {
			errors.rejectValue("email", "errors.null_email", "errors.null_email.message");
		}

		if (StringUtils.isBlank(userDTO.getPassword())) {
			errors.rejectValue("password", "errors.null_password", "errors.null_password.message");
		}

		if (StringUtils.isBlank(userDTO.getName())) {
			errors.rejectValue("name", "errors.null_name", "errors.null_name.message");
		}

		if (StringUtils.isBlank(userDTO.getSurname())) {
			errors.rejectValue("surname", "errors.null_surname", "errors.null_surname.message");
		}
		
		if (userDao.findByUserEmail(userDTO.getEmail()) != null) {
			errors.rejectValue("email", "errors.existing_email", "errors.existing_email.message");
		}

	}

}
