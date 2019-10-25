package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.entities.User;

@Controller
public class AuthorisationPageController {
	
	@RequestMapping(value = "/authorisation", method = RequestMethod.GET)
	public String getPage(@ModelAttribute("user") User user) {
		return "authorisation";
	}

}
