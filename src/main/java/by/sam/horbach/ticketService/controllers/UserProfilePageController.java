package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.facades.impl.UserProfileFacadeImpl;
import by.sam.horbach.ticketService.services.UserService;

/**
 * A class responsible for interacting with the user profile page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class UserProfilePageController {

	@Autowired
	UserProfileFacadeImpl userProfileFacade;

	@Autowired
	UserService userService;

	/**
	 * Returns a view name of a user profile page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a user profile page
	 */
	@RequestMapping(value = "/user_profile", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("userDTO", userProfileFacade.getUserByEmail());
		return "user_profile";
	}

}
