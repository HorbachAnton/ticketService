package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.facades.impl.WelcomeFacadeImpl;

/**
 * A class responsible for interacting with the welcome page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class IndexPageController {

	@Autowired
	WelcomeFacadeImpl welcomeFacadeFacade;

	/**
	 * Returns a view name of a welcome page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a welcome page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("upcomingEvents", welcomeFacadeFacade.getUpcomingEvents());
		return "index";
	}

	/**
	 * Returns a view name of a event page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of a event page
	 */
	@RequestMapping(value = "/moreInfo")
	public String moreInfo() {
		return "event";
	}

}
