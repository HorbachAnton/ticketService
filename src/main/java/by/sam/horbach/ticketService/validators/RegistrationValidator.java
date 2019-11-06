package by.sam.horbach.ticketService.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.dto.UserDTO;

public class RegistrationValidator implements Validator {

	UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errors.null_email", "errors.null_email.message");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errors.null_password", "errors.null_password.message");

		UserDTO userDTO = (UserDTO) target;

		
		if (StringUtils.isNotEmpty(userDTO.getEmail())) {
			
		}
		if (userDao.findByUserEmail(userDTO.getEmail()) != null) {
			errors.rejectValue("email", "errors.existing_email", "errors.existing_email.message");
		}

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
