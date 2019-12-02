package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import by.sam.horbach.ticketService.facades.impl.WelcomeFacadeImpl;
import by.sam.horbach.ticketService.utils.Constants;

/**
 * A class responsible for interacting with the welcome page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class IndexPageController implements Constants {

	@Autowired
	WelcomeFacadeImpl welcomeFacade;

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
		model.addAttribute("upcomingEvents", welcomeFacade.getUpcomingEvents());
		return "index";
	}

	/**
	 * Returns a view name of a event page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of a event page
	 */
	@RequestMapping(value = "/learn_more_about_event", method = RequestMethod.GET)
	public ModelAndView requestToEventPage(@ModelAttribute("eventId") Integer eventId) {
		return  new ModelAndView(new RedirectView("/ticket-service/event_page"));
	}

}
