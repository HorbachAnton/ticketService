package by.sam.horbach.ticketService.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.sam.horbach.ticketService.dto.forms.BuyTicketsDTO;

public class BuyTicketsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BuyTicketsDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BuyTicketsDTO buyTicketsDTO = (BuyTicketsDTO) target;

		if (buyTicketsDTO.getQuantity() == 0) {
			errors.rejectValue("quantity", "errors.null_quantity", "errors.null_quantity.message");
		}
	}

}
