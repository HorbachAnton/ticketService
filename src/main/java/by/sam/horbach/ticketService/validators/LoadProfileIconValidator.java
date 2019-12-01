package by.sam.horbach.ticketService.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dto.forms.FileUploadDTO;

public class LoadProfileIconValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FileUploadDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		FileUploadDTO fileDTO = (FileUploadDTO) target;

		if (fileDTO.getFile().getSize() == 0) {
			errors.rejectValue("file", "errors.null_file", "errors.null_file.message");
		}
	}
}
