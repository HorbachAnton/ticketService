package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.facades.RegistrationFacade;
import by.sam.horbach.ticketService.validators.RegistrationValidator;

@Controller
public class RegistrationPageController {

	@Autowired
	RegistrationFacade registrationFacade;
	
	@Autowired
	RegistrationValidator registrationValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, ModelMap map) {
		registrationValidator.validate(userDTO, result);
		if(result.hasErrors()) {
			return "registration";
		}
		registrationFacade.register(userDTO);
		return "userProfile";
	}

}
