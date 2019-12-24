package by.sam.horbach.ticketService.validators;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.dto.LocationDTO;

public class EventDetailsValidator implements Validator {

	public static final String EVENT_DATE_REGEX = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))T(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})((:[0-5]\\d){1,2})$";
	public static final String EVENT_ICON_PATH_REGEX = "^(\\S*/)*(\\S*)\\.png$";

	@Override
	public boolean supports(Class<?> clazz) {
		return EventDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EventDTO eventDTO = (EventDTO) target;

		validateTitle(eventDTO.getTitle(), errors);
		validateSummary(eventDTO.getSummary(), errors);
		validateDate(eventDTO.getDate(), errors);
		validateLocation(eventDTO.getLocation(), errors);
		validateIconPath(eventDTO.getIconPath(), errors);
	}

	private void validateTitle(String title, Errors errors) {
		if (validateTitleExists(title, errors)) {
			validateLengthTitle(title, errors);
		}
	}

	private boolean validateTitleExists(String title, Errors errors) {
		boolean isExist = true;
		if (title == null || title.isEmpty()) {
			isExist = false;
			errors.rejectValue("title", "errors.null_event_title", "errors.null_event_title.message");
		}
		return isExist;
	}

	private void validateLengthTitle(String title, Errors errors) {
		if (title.length() > 45) {
			errors.rejectValue("title", "errors.invalid_event_title_length",
					"errors.invalid_event_title_length.message");
		}
	}

	private void validateSummary(String summary, Errors errors) {
		if (validateSummaryExists(summary, errors)) {
			validateLengthSummary(summary, errors);
		}
	}

	private boolean validateSummaryExists(String summary, Errors errors) {
		boolean isExist = true;
		if (summary == null || summary.isEmpty()) {
			isExist = false;
			errors.rejectValue("summary", "errors.null_event_summary", "errors.null_event_summary.message");
		}
		return isExist;
	}

	private void validateLengthSummary(String title, Errors errors) {
		if (title.length() > 600) {
			errors.rejectValue("summary", "errors.invalid_event_summary_length",
					"errors.invalid_event_summary_length.message");
		}
	}

	private void validateDate(LocalDateTime date, Errors errors) {
		if (validateDateExists(date, errors)) {
			validateDatePattern(date, errors);
		}
	}

	private boolean validateDateExists(LocalDateTime date, Errors errors) {
		boolean isExist = true;
		if (date == null) {
			isExist = false;
			errors.rejectValue("date", "errors.null_event_date", "errors.null_event_date.message");
		}
		return isExist;
	}

	private void validateDatePattern(LocalDateTime date, Errors errors) {
		Pattern pattern = Pattern.compile(EVENT_DATE_REGEX);
		Matcher mathcer = pattern.matcher(date.toString());

		if (!mathcer.matches()) {
			errors.rejectValue("date", "errors.invalid_event_date", "errors.invalid_event_date.message");
		}
	}

	private void validateLocation(LocationDTO locationDTO, Errors errors) {
		if (validateLocationTitleExist(locationDTO, errors)) {
			validateLocationTitleLength(locationDTO, errors);
		}
	}

	private boolean validateLocationTitleExist(LocationDTO locationDTO, Errors errors) {
		boolean isExist = true;
		if (locationDTO.getTitle() == null || locationDTO.getTitle().isEmpty()) {
			isExist = false;
			errors.rejectValue("location.title", "errors.null_event_location_title",
					"errors.null_event_location_title.message");
		}
		return isExist;
	}

	private void validateLocationTitleLength(LocationDTO locationDTO, Errors errors) {
		if (locationDTO.getTitle().length() > 45) {
			errors.rejectValue("location.title", "errors.invalid_event_location_title_length",
					"errors.invalid_event_location_title_length.message");
		}
	}

	private void validateIconPath(Path iconPath, Errors errors) {
		if (validateIconPathExist(iconPath, errors)) {
			validateIconPathPattern(iconPath, errors);
		}
	}

	private boolean validateIconPathExist(Path iconPath, Errors errors) {
		boolean isExist = true;
		if (iconPath == null || iconPath.toString().isEmpty()) {
			isExist = false;
			errors.rejectValue("iconPath", "errors.null_event_iconPath", "errors.null_event_iconPath.message");
		}
		return isExist;
	}

	private void validateIconPathPattern(Path iconPath, Errors errors) {
		Pattern pattern = Pattern.compile(EVENT_ICON_PATH_REGEX);
		Matcher mathcer = pattern.matcher(iconPath.toString());

		if (!mathcer.matches()) {
			errors.rejectValue("iconPath", "errors.invalid_event_iconPath", "errors.invalid_event_iconPath.message");
		}
	}

}
