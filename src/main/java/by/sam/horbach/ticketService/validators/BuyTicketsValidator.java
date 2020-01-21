package by.sam.horbach.ticketService.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dto.forms.BuyTicketsDTO;

public class BuyTicketsValidator implements Validator {

	private static final String QUANTITY_FIELD_NAME = "quantity";
	private static final String NULL_QUANTITY_ERROR_CODE = "errors.null_quantity";
	private static final String NULL_QUANTITY_DEFAULT_MESSAGE = "errors.null_quantity.message";

	@Override
	public boolean supports(Class<?> clazz) {
		return BuyTicketsDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BuyTicketsDTO buyTicketsDTO = (BuyTicketsDTO) target;

		if (buyTicketsDTO.getQuantity() == 0) {
			errors.rejectValue(QUANTITY_FIELD_NAME, NULL_QUANTITY_ERROR_CODE, NULL_QUANTITY_DEFAULT_MESSAGE);
		}
	}

}
