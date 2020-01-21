package by.sam.horbach.ticketService.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dto.forms.PasswordDTO;
import by.sam.horbach.ticketService.utils.Constants;

public class UpdatePasswordValidator implements Validator, Constants {

	private static final Pattern PATTERN_PASSWORD = Pattern.compile(PASSWORD_REGEX);

	private static final String PASSWORD_FIELD_NAME = "password";
	private static final String NULL_PASSWORD_ERROR_CODE = "errors.null_password";
	private static final String NULL_PASSWORD_DEFAULT_MESSAGE = "errors.null_password.message";
	private static final String INVALID_PASSWORD_ERROR_CODE = "errors.invalid_password";
	private static final String INVALID_PASSWORD_DEFAULT_MESSAGE = "errors.invalid_password.message";

	private static final String CONFIRM_PASSWORD_FIELD_NAME = "confirmPassword";
	private static final String NULL_CONFIRM_PASSWORD_ERROR_CODE = "errors.null_confirm_password";
	private static final String NULL_CONFIRM_PASSWORD_DEFAULT_MESSAGE = "errors.null_confirm_password.message";

	@Override
	public boolean supports(Class<?> clazz) {
		return PasswordDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PasswordDTO passwordDTO = (PasswordDTO) target;

		if (StringUtils.isBlank(passwordDTO.getPassword())) {
			errors.rejectValue(PASSWORD_FIELD_NAME, NULL_PASSWORD_ERROR_CODE, NULL_PASSWORD_DEFAULT_MESSAGE);
		}

		if (StringUtils.isBlank(passwordDTO.getConfirmPassword())) {
			errors.rejectValue(CONFIRM_PASSWORD_FIELD_NAME, NULL_CONFIRM_PASSWORD_ERROR_CODE,
					NULL_CONFIRM_PASSWORD_DEFAULT_MESSAGE);
		}

		Matcher matcher = PATTERN_PASSWORD.matcher(passwordDTO.getPassword());

		if (!matcher.matches()) {
			errors.rejectValue(PASSWORD_FIELD_NAME, INVALID_PASSWORD_ERROR_CODE, INVALID_PASSWORD_DEFAULT_MESSAGE);
		}

		if (!StringUtils.equals(passwordDTO.getPassword(), passwordDTO.getConfirmPassword())) {
			errors.rejectValue(CONFIRM_PASSWORD_FIELD_NAME, NULL_PASSWORD_ERROR_CODE, NULL_PASSWORD_DEFAULT_MESSAGE);
		}

	}

}
