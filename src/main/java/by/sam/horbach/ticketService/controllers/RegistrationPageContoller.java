package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.entities.User;

@Controller
public class RegistrationPageContoller {

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getPage(@ModelAttribute("user")User user) {
		return "registration";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@ModelAttribute("user")User user, BindingResult result, ModelMap map) {
		System.out.println(user.getEmail() + user.getPassword());
	}

}
