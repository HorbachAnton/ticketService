package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.forms.PersonalDataDTO;
import by.sam.horbach.ticketService.facades.impl.ChangePersonalDataFacadeImpl;
import by.sam.horbach.ticketService.utils.Constants;

/**
 * A class responsible for interacting with the change personal data page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class ChangePersonalDataPageController implements Constants {

	private static final String GET_CHANGE_PERSONAL_DATA_PAGE_REQUEST = "/change_personal_data_page";
	private static final String CHANGE_PERSONAL_DATA_REQUEST = "/change_personal_data";

	private static final String CHANGE_PERSONAL_DATA_PAGE_NAME = "change_personal_data";
	private static final String REDIRECT_WELCOME_PAGE_NAME = REDIRECT_PREFIX + "/";

	private static final String PERSONAL_DATA_DTO_MODEL_ATTRIBUTE_NAME = "personalDataDTO";

	@Autowired
	private ChangePersonalDataFacadeImpl changePersonalDataFacade;

	/**
	 * Returns a view name of a change personal data page to be resolved with
	 * ViewResolver implementations and used together with the implicit model —
	 * determined through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a change personal data page
	 */
	@GetMapping(value = GET_CHANGE_PERSONAL_DATA_PAGE_REQUEST)
	public String getPage(Model model) {
		model.addAttribute(PERSONAL_DATA_DTO_MODEL_ATTRIBUTE_NAME, new PersonalDataDTO());
		return CHANGE_PERSONAL_DATA_PAGE_NAME;
	}

	/**
	 * Changes the user personal data in the system and returns a view name of a
	 * welcome page to be resolved with ViewResolver implementations and used
	 * together with the implicit model — determined through command objects
	 * and @ModelAttribute methods.
	 * 
	 * @param personalDataDTO instance of PersonalDataDTO class which contains the
	 *                        new personal data
	 * @param result          BindingResult interface implementation
	 * @return a view name of a welcome page
	 */
	@PostMapping(value = CHANGE_PERSONAL_DATA_REQUEST)
	public ModelAndView change(@ModelAttribute(PERSONAL_DATA_DTO_MODEL_ATTRIBUTE_NAME) PersonalDataDTO personalDataDTO,
			BindingResult result) {
		changePersonalDataFacade.changePersonalData(personalDataDTO);
		return new ModelAndView(REDIRECT_WELCOME_PAGE_NAME);
	}

}
