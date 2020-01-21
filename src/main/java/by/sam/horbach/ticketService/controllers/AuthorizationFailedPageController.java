package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * A class responsible for interacting with the authorization-failed page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class AuthorizationFailedPageController {

	private static final String GET_AUTHORIZATION_FAILED_PAGE_REQUEST = "/authorization-failed";
	private static final String AUTHORIZATION_FAILED_PAGE_NAME = "authorization-failed";

	/**
	 * Returns a view name of an authorization-failed page to be resolved with
	 * ViewResolver implementations and used together with the implicit model —
	 * determined through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of an authorization-failed page
	 */
	@GetMapping(value = GET_AUTHORIZATION_FAILED_PAGE_REQUEST)
	public String getErrorPage() {
		return AUTHORIZATION_FAILED_PAGE_NAME;
	}

}
