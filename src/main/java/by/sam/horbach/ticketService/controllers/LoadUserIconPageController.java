package by.sam.horbach.ticketService.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A class responsible for interacting with the load user icon page.
 * 
 * @author Horbach Anton
 *
 */
public class LoadUserIconPageController {

	/**
	 * Returns a view name of a load user icon page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of a load user icon page
	 */
	@RequestMapping(value = "/load_user_icon", method = RequestMethod.GET)
	public String getPage() {
		return "load_user_icon";
	}
}
