package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.facades.impl.RegistrationFacadeImpl;
import by.sam.horbach.ticketService.validators.RegistrationValidator;

/**
 * A class responsible for interacting with the registration page page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class RegistrationPageController {

	@Autowired
	RegistrationFacadeImpl registrationFacade;

	@Autowired
	RegistrationValidator registrationValidator;

	/**
	 * Returns a view name of a registration page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a registration page
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "registration";
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
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {
		registrationValidator.validate(userDTO, result);

		if (result.hasErrors()) {
			return "registration";
		}

		registrationFacade.register(userDTO);
		return "authorization";
	}

}
