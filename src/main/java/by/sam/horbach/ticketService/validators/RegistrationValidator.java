package by.sam.horbach.ticketService.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.services.UserService;
import by.sam.horbach.ticketService.utils.Constants;

public class RegistrationValidator implements Validator, Constants {

	private static final String EMAIL_FIELD_NAME = "email";
	private static final String NULL_EMAIL_ERROR_CODE = "errors.null_email";
	private static final String NULL_EMAIL_DEFAULT_MESSAGE = "errors.null_email.message";
	private static final String EXISTING_EMAIL_ERROR_CODE = "errors.existing_email";
	private static final String EXISTING_EMAIL_DEFAULT_MESSAGE = "errors.existing_email.message";

	private static final String PASSWORD_FIELD_NAME = "password";
	private static final String NULL_PASSWORD_ERROR_CODE = "errors.null_password";
	private static final String NULL_PASSWORD_DEFAULT_MESSAGE = "errors.null_password.message";
	private static final String INVALID_PASSWORD_ERROR_CODE = "errors.invalid_password";
	private static final String INVALID_PASSWORD_DEFAULT_MESSAGE = "errors.invalid_password.message";

	private static final Pattern PATTERN_PASSWORD = Pattern.compile(PASSWORD_REGEX);

	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, EMAIL_FIELD_NAME, NULL_EMAIL_ERROR_CODE,
				NULL_EMAIL_DEFAULT_MESSAGE);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD_FIELD_NAME, NULL_PASSWORD_ERROR_CODE,
				NULL_PASSWORD_DEFAULT_MESSAGE);

		UserDTO userDTO = (UserDTO) target;

		Matcher matcher = PATTERN_PASSWORD.matcher(userDTO.getPassword());

		if (!matcher.matches()) {
			errors.rejectValue(PASSWORD_FIELD_NAME, INVALID_PASSWORD_ERROR_CODE, INVALID_PASSWORD_DEFAULT_MESSAGE);
		}

		if (userService.getUserByEmail(userDTO.getEmail()) != null) {
			errors.rejectValue(EMAIL_FIELD_NAME, EXISTING_EMAIL_ERROR_CODE, EXISTING_EMAIL_DEFAULT_MESSAGE);
		}

	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
