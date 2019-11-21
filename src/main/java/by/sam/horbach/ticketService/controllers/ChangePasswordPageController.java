package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.forms.PasswordDTO;
import by.sam.horbach.ticketService.facades.ChangePasswordFacade;
import by.sam.horbach.ticketService.validators.UpdatePasswordValidator;

@Controller
public class ChangePasswordPageController {

	@Autowired
	UpdatePasswordValidator passwordValidator;

	@Autowired
	ChangePasswordFacade changePasswordFacade;

	@RequestMapping(value = "/change_password_page", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("passwordDTO", new PasswordDTO());
		return "change_password";
	}

	@RequestMapping(value = "/change_password", method = RequestMethod.POST)
	public ModelAndView change(@ModelAttribute("passwordDTO") PasswordDTO passwordDTO, BindingResult result,
			ModelAndView model) {
		passwordValidator.validate(passwordDTO, result);
		
		if (result.hasErrors()) {
			return model;
		}
		
		changePasswordFacade.changePassword(passwordDTO);
		return new ModelAndView("redirect:/welcome");
	}

}
