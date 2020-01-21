package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.facades.impl.RegistrationFacadeImpl;

/**
 * A class responsible for interacting with the registration page page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class RegistrationPageController {

	private static final String GET_REGISTRATION_PAGE_REQUEST = "/registration";
	private static final String REGISTER_REQUEST = "/register";

	private static final String USER_DTO_MODEL_ATTRIBUTE_NAME = "userDTO";
	private static final String AUTHORIZATION_PAGE_NAME = "authorization";

	private static final String REGISTRATION_PAGE_NAME = "registration";

	@Autowired
	private RegistrationFacadeImpl registrationFacade;

	@Autowired
	private Validator registrationFormValidator;

	/**
	 * Returns a view name of a registration page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a registration page
	 */
	@GetMapping(value = GET_REGISTRATION_PAGE_REQUEST)
	public String getPage(Model model) {
		model.addAttribute(USER_DTO_MODEL_ATTRIBUTE_NAME, new UserDTO());
		return REGISTRATION_PAGE_NAME;
	}

	/**
	 * Registers the user in the system and returns a view name of an authorization
	 * page to be resolved with ViewResolver implementations and used together with
	 * the implicit model — determined through command objects and @ModelAttribute
	 * methods. In case of binding errors, returns a view name of registration page.
	 * 
	 * @param userDTO instance of UserDTO class which contains the new password
	 * @param result  BindingResult interface implementation
	 * @return a view name of a registration page. In case of binding errors,
	 *         returns a view name of registration page.
	 */
	@PostMapping(value = REGISTER_REQUEST)
	public String register(@ModelAttribute(USER_DTO_MODEL_ATTRIBUTE_NAME) UserDTO userDTO, BindingResult result) {
		registrationFormValidator.validate(userDTO, result);

		if (result.hasErrors()) {
			return REGISTRATION_PAGE_NAME;
		}

		registrationFacade.register(userDTO);
		return AUTHORIZATION_PAGE_NAME;
	}

}
