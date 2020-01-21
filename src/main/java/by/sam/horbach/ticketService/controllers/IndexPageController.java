package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	private static final String GET_INDEX_PAGE_REQUEST = "/";
	private static final String REDIRECT_TO_EVENT_PAGE_REQUEST = "/learn_more_about_event";

	private static final String UPCOMING_EVENTS_MODEL_ATTRIBUTE_NAME = "upcomingEvents";
	private static final String EVENT_ID_MODEL_ATTRIBUTE_NAME = "eventId";

	private static final String INDEX_PAGE_NAME = "index";

	private static final String REDIRECT_EVENT_PAGE_URL = "/ticket-service/event_page";

	@Autowired
	private WelcomeFacadeImpl welcomeFacade;

	/**
	 * Returns a view name of a welcome page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @param model Model interface implementation
	 * @return a view name of a welcome page
	 */
	@GetMapping(value = GET_INDEX_PAGE_REQUEST)
	public String getPage(Model model) {
		model.addAttribute(UPCOMING_EVENTS_MODEL_ATTRIBUTE_NAME, welcomeFacade.getUpcomingEvents());
		return INDEX_PAGE_NAME;
	}

	/**
	 * Returns a view name of a event page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of a event page
	 */
	@GetMapping(value = REDIRECT_TO_EVENT_PAGE_REQUEST)
	public ModelAndView requestToEventPage(@ModelAttribute(EVENT_ID_MODEL_ATTRIBUTE_NAME) Integer eventId) {
		return new ModelAndView(new RedirectView(REDIRECT_EVENT_PAGE_URL));
	}

}
