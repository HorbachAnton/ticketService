package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserProfileService;

@Controller
public class UserProfilePageController {

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String getPage(@ModelAttribute("user") User user) {
		return "userProfile";
	}

	public boolean updateProfile() {
		return true;
	}

	public boolean changePassword() {
		return true;
	}

	public boolean changeEmail() {
		return true;
	}

	public boolean loadIcon() {
		return true;
	}

}
