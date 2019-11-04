package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.facades.RegistrationFacade;

@Controller
public class RegistrationPageController {

	@Autowired
	RegistrationFacade registrationFacade;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getPage() {
		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") UserDTO userDTO, BindingResult result, ModelMap map) {
		registrationFacade.register(userDTO);
		return "userProfile";
	}

}
