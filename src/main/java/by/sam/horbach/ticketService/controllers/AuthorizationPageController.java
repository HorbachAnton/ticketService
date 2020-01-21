package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * A class responsible for interacting with the authorization page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class AuthorizationPageController {

	private static final String GET_AUTHORIZATION_PAGE_REQUEST = "/authorization";
	private static final String AUTHORIZATION_PAGE_NAME = "authorization";

	/**
	 * Returns a view name of an authorization page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of an authorization page
	 */
	@GetMapping(value = GET_AUTHORIZATION_PAGE_REQUEST)
	public String getPage() {
		return AUTHORIZATION_PAGE_NAME;
	}

}
