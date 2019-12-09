package by.sam.horbach.ticketService.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.dto.forms.PasswordDTO;
import by.sam.horbach.ticketService.utils.Constants;

public class UpdatePasswordValidator implements Validator, Constants {

	private static final Pattern PATTERN_PASSWORD = Pattern.compile(PASSWORD_REGEX);

	UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return PasswordDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PasswordDTO passwordDTO = (PasswordDTO) target;

		if (StringUtils.isBlank(passwordDTO.getPassword())) {
			errors.rejectValue("password", "errors.null_password", "errors.null_password.message");
		}

		if (StringUtils.isBlank(passwordDTO.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "errors.null_confirm_password",
					"errors.null_confirm_password.message");
		}

		Matcher matcher = PATTERN_PASSWORD.matcher(passwordDTO.getPassword());

		if (!matcher.matches()) {
			errors.rejectValue("password", "errors.invalid_password", "errors.invalid_password.message");
		}

		if (!StringUtils.equals(passwordDTO.getPassword(), passwordDTO.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "errors.null_password", "errors.null_password.message");
		}

	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
