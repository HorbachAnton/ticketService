package by.sam.horbach.ticketService.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dto.forms.FileUploadDTO;

public class LoadProfileIconValidator implements Validator {

	private static final String FILE_FIELD_NAME = "file";
	private static final String NULL_FILE_ERROR_CODE = "errors.null_file";
	private static final String NULL_FILE_DEFAULT_MESSAGE = "errors.null_file.message";

	@Override
	public boolean supports(Class<?> clazz) {
		return FileUploadDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		FileUploadDTO fileDTO = (FileUploadDTO) target;

		if (fileDTO.getFile().getSize() == 0) {
			errors.rejectValue(FILE_FIELD_NAME, NULL_FILE_ERROR_CODE, NULL_FILE_DEFAULT_MESSAGE);
		}
	}
}
