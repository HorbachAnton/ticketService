package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import by.sam.horbach.ticketService.facades.impl.UserProfileFacadeImpl;

/**
 * A class responsible for interacting with the user profile page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class UserProfilePageController {

	private static final String GET_USER_PROFILE_PAGE_REQUEST = "/user_profile";
	private static final String USER_DTO_MODEL_ATTRIBUTE_NAME = "userDTO";
	private static final String USER_PROFILE_PAGE_NAME = "user_profile";

	@Autowired
	private UserProfileFacadeImpl userProfileFacade;

	/**
	 * Returns a view name of a user profile page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a user profile page
	 */
	@GetMapping(value = GET_USER_PROFILE_PAGE_REQUEST)
	public String getPage(Model model) {
		model.addAttribute(USER_DTO_MODEL_ATTRIBUTE_NAME, userProfileFacade.getUserByEmail());
		return USER_PROFILE_PAGE_NAME;
	}

}
