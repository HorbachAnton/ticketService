package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import by.sam.horbach.ticketService.dto.PaginationEventDTO;
import by.sam.horbach.ticketService.facades.EventCenterFacade;

@Controller
public class EventCenterPageController {

	private static final String PAGE_NAME = "event_center";
	private static final String LIST_EVENTS_NAME_ATTRIBUTE = "listEvents";
	private static final String PAGES_NUMBER_NAME_ATTRIBUTE = "numberOfPages";

	private static final int DEFAULT_CHOSEN_PAGE_VALUE = 1;

	@Autowired
	EventCenterFacade eventCenterFacade;

	@RequestMapping(value = "/event_center_page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView modelAndView = new ModelAndView(PAGE_NAME);
		PaginationEventDTO paginationEventDTO = eventCenterFacade.getPaginationEventDTO(DEFAULT_CHOSEN_PAGE_VALUE);
		modelAndView.addObject(LIST_EVENTS_NAME_ATTRIBUTE, paginationEventDTO.getEventDTOList());
		modelAndView.addObject(PAGES_NUMBER_NAME_ATTRIBUTE, paginationEventDTO.getPagesNumber());
		modelAndView.addObject("chosen_page", DEFAULT_CHOSEN_PAGE_VALUE);
		return modelAndView;
	}

	@RequestMapping(value = "/get_chosen_page", method = RequestMethod.GET)
	public ModelAndView getChosenPage(@RequestParam("chosen_page") int chosenPage) {
		ModelAndView modelAndView = new ModelAndView(PAGE_NAME);
		PaginationEventDTO paginationEventDTO = eventCenterFacade.getPaginationEventDTO(chosenPage);
		modelAndView.addObject(LIST_EVENTS_NAME_ATTRIBUTE, paginationEventDTO.getEventDTOList());
		modelAndView.addObject(PAGES_NUMBER_NAME_ATTRIBUTE, paginationEventDTO.getPagesNumber());
		modelAndView.addObject("chosen_page", chosenPage);
		return modelAndView;
	}

	@RequestMapping(value = "/delete_event", method = RequestMethod.GET)
	public ModelAndView deleteEvent(@RequestParam("event_id") int eventId) {
		eventCenterFacade.deleteEvent(eventId);
		return new ModelAndView(new RedirectView("event_center_page"));
	}

}
