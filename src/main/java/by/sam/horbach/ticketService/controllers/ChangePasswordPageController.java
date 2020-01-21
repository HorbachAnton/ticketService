package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.forms.PasswordDTO;
import by.sam.horbach.ticketService.facades.impl.ChangePasswordFacadeImpl;
import by.sam.horbach.ticketService.utils.Constants;

/**
 * The class responsible for intercepting, processing, and sending responses to
 * user requests sent from the change password page (change_password.jsp). The
 * class also processing the request for getting page (change_password.jsp).
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class ChangePasswordPageController implements Constants {

	private static final String GET_CHANGE_PASSWORD_PAGE_REQUEST = "/change_password_page";
	private static final String CHANGE_PASSWORD_REQUEST = "/change_password";

	private static final String PASSWORD_DTO_ATTRIBUTE_NAME = "passwordDTO";
	private static final String CHANGE_PASSWORD_PAGE_NAME = "change_password";

	@Autowired
	private Validator updatePasswordValidator;

	@Autowired
	private ChangePasswordFacadeImpl changePasswordFacade;

	/**
	 * 
	 * Returns a view name for change_password.jsp in response to a
	 * "/change_password_page" request.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a change password page
	 */
	@GetMapping(value = GET_CHANGE_PASSWORD_PAGE_REQUEST)
	public String getPage(Model model) {
		model.addAttribute(PASSWORD_DTO_ATTRIBUTE_NAME, new PasswordDTO());
		return CHANGE_PASSWORD_PAGE_NAME;
	}

	/**
	 * Changes the user password in the system and returns a view name of a welcome
	 * page in response to a "/change_password". In case of binding errors, returns
	 * a view name of change password page.
	 * 
	 * @param passwordDTO instance of PasswordDTO class which contains the new
	 *                    password
	 * @param result      BindingResult interface implementation
	 * @param model       Model interface implementation
	 * @return a view name of a welcome page. In case of binding errors, returns a
	 *         view name of change password page.
	 */
	@PostMapping(value = CHANGE_PASSWORD_REQUEST)
	public ModelAndView changePassword(@ModelAttribute(PASSWORD_DTO_ATTRIBUTE_NAME) PasswordDTO passwordDTO,
			BindingResult result, ModelAndView model) {
		validatePasswordDTO(passwordDTO, result);

		if (!result.hasErrors()) {
			changePasswordFacade.changePassword(passwordDTO);
			model = new ModelAndView(REDIRECT_PREFIX + "/");
		}

		return model;
	}

	private void validatePasswordDTO(PasswordDTO passwordDTO, BindingResult result) {
		updatePasswordValidator.validate(passwordDTO, result);
	}

}
