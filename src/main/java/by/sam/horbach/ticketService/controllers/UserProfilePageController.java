package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.facades.impl.UserProfileFacadeImpl;
import by.sam.horbach.ticketService.services.UserService;

@Controller
public class UserProfilePageController {

	@Autowired
	UserProfileFacadeImpl userProfileFacade;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user_profile", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("userDTO", userProfileFacade.getUserByEmail());
		return "user_profile";
	}

}
