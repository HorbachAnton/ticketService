package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@Autowired
	ChangePersonalDataFacadeImpl changePersonalDataFacade;

	/**
	 * Returns a view name of a change personal data page to be resolved with
	 * ViewResolver implementations and used together with the implicit model —
	 * determined through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a change personal data page
	 */
	@RequestMapping(value = "/change_personal_data_page", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("personalDataDTO", new PersonalDataDTO());
		return "change_personal_data";
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
	@RequestMapping(value = "/change_personal_data", method = RequestMethod.POST)
	public ModelAndView change(@ModelAttribute("personalDataDTO") PersonalDataDTO personalDataDTO,
			BindingResult result) {
		changePersonalDataFacade.changePersonalData(personalDataDTO);
		return new ModelAndView(REDIRECT_PREFIX + "/");
	}

}
