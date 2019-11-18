package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.dto.forms.ChangePasswordDTO;
import by.sam.horbach.ticketService.facades.ChangePasswordFacade;

@Controller
public class ChangePasswordPageController {

	@Autowired
	ChangePasswordFacade changePasswordFacade;

	@RequestMapping(value = "/change_password_page", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("changePasswordDTO", new ChangePasswordDTO());
		return "changePassword";
	}

	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public String change(@ModelAttribute("changePasswordDTO") ChangePasswordDTO changePasswordDTO, BindingResult result,
			ModelMap map) {
		changePasswordFacade.changePassword(changePasswordDTO);
		return "welcome";
	}

	public void setChangePasswordFacade(ChangePasswordFacade changePasswordFacade) {
		this.changePasswordFacade = changePasswordFacade;
	}

}
