package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A class responsible for interacting with the authorization-failed page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class AuthorizationFailedPageController {

	/**
	 * Returns a view name of an authorization-failed page to be resolved with
	 * ViewResolver implementations and used together with the implicit model —
	 * determined through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of an authorization-failed page
	 */
	@RequestMapping(value = "/authorization-failed", method = RequestMethod.GET)
	public String getErrorPage() {
		return "/authorization-failed";
	}

}
