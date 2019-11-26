package by.sam.horbach.ticketService.validators;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.utils.Constants;

public class RegistrationValidator implements Validator, Constants {
	
	private static final Pattern PATTERN_PASSWORD = Pattern.compile(PASSWORD_REGEX);

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
		
		Matcher matcher = PATTERN_PASSWORD.matcher(userDTO.getPassword());
		
		if(!matcher.matches()){
			errors.rejectValue("password", "erros.invalid_password", "erros.invalid_password.message");
		}

		if (userDao.findByUserEmail(userDTO.getEmail()) != null) {
			errors.rejectValue("email", "errors.existing_email", "errors.existing_email.message");
		}

	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public static void main(String[] args) {
		Path path = Paths.get("resources\\img\\profile_icons");
		System.out.println(path.toAbsolutePath());
	}

}
