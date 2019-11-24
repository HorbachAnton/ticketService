package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A class responsible for interacting with the authorization page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class AuthorizationPageController {

	/**
	 * Returns a view name of an authorization page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of an authorization page
	 */
	@RequestMapping(value = "/authorization", method = RequestMethod.GET)
	public String getPage() {
		return "authorization";
	}

}
