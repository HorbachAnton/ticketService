package by.sam.horbach.ticketService.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dto.UserDTO;

public class RegistrationFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Wrong email");	
		ValidationUtils.rejectIfEmpty(errors, "password", "Wrong password");
	}

}
