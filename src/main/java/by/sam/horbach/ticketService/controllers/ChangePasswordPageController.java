package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.forms.PasswordDTO;
import by.sam.horbach.ticketService.facades.impl.ChangePasswordFacadeImpl;
import by.sam.horbach.ticketService.utils.Constants;

/**
 * A class responsible for interacting with the change password page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class ChangePasswordPageController implements Constants {

	@Autowired
	Validator updatePasswordValidator;

	@Autowired
	ChangePasswordFacadeImpl changePasswordFacade;

	/**
	 * Returns a view name of a change password page to be resolved with
	 * ViewResolver implementations and used together with the implicit model —
	 * determined through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a change password page
	 */
	@RequestMapping(value = "/change_password_page", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("passwordDTO", new PasswordDTO());
		return "change_password";
	}

	/**
	 * Changes the user password in the system and returns a view name of a welcome
	 * page to be resolved with ViewResolver implementations and used together with
	 * the implicit model — determined through command objects and @ModelAttribute
	 * methods. In case of binding errors, returns a view name of change password
	 * page.
	 * 
	 * @param passwordDTO instance of PasswordDTO class which contains the new
	 *                    password
	 * @param result      BindingResult interface implementation
	 * @param model       Model interface implementation
	 * @return a view name of a welcome page. In case of binding errors, returns a
	 *         view name of change password page.
	 */
	@RequestMapping(value = "/change_password", method = RequestMethod.POST)
	public ModelAndView change(@ModelAttribute("passwordDTO") PasswordDTO passwordDTO, BindingResult result,
			ModelAndView model) {
		updatePasswordValidator.validate(passwordDTO, result);

		if (result.hasErrors()) {
			return model;
		}

		changePasswordFacade.changePassword(passwordDTO);
		return new ModelAndView(REDIRECT_PREFIX + "/");
	}

}
