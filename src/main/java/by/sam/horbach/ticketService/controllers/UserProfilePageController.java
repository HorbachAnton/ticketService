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
import by.sam.horbach.ticketService.services.UserService;

@Controller
public class UserProfilePageController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String getPage(Model model) {

		return "userProfile";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateProfile(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, ModelMap map) {
		return "userProfile";
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
