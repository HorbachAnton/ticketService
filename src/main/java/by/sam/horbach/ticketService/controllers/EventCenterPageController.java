package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import by.sam.horbach.ticketService.dto.PaginationEventDTO;
import by.sam.horbach.ticketService.facades.EventCenterFacade;

@Controller
public class EventCenterPageController {

	private static final String GET_EVENT_CENTER_PAGE_REQUEST = "/event_center_page";
	private static final String GET_CHOSEN_EVENT_CENTER_PAGE_REQUEST = "/get_chosen_page";
	private static final String DELETE_EVENT_REQUEST = "/delete_event";

	private static final String EVENT_CENTER_PAGE_NAME = "event_center";

	private static final String LIST_EVENTS_ATTRIBUTE_NAME = "listEvents";
	private static final String PAGES_NUMBER_ATTRIBUTE_NAME = "numberOfPages";
	private static final String CHOSEN_PAGE_ATTRIBUTE_NAME = "chosen_page";

	private static final String EVENT_ID_REQUEST_PARAM_NAME = "event_id";
	private static final String CHOSEN_PAGE_REQUEST_PARAM_NAME = "chosen_page";

	private static final int DEFAULT_CHOSEN_PAGE_VALUE = 1;

	private static final String REDIRECT_EVENT_CENTER_PAGE_URL = "event_center_page";

	@Autowired
	private EventCenterFacade eventCenterFacade;

	@GetMapping(value = GET_EVENT_CENTER_PAGE_REQUEST)
	public ModelAndView getPage() {
		ModelAndView modelAndView = new ModelAndView(EVENT_CENTER_PAGE_NAME);
		setupPage(modelAndView, DEFAULT_CHOSEN_PAGE_VALUE);
		return modelAndView;
	}

	@GetMapping(value = GET_CHOSEN_EVENT_CENTER_PAGE_REQUEST)
	public ModelAndView getChosenPage(@RequestParam(CHOSEN_PAGE_REQUEST_PARAM_NAME) int chosenPage) {
		ModelAndView modelAndView = new ModelAndView(EVENT_CENTER_PAGE_NAME);
		setupPage(modelAndView, chosenPage);
		return modelAndView;
	}

	private void setupPage(ModelAndView modelAndView, int chosenPage) {
		PaginationEventDTO paginationEventDTO = eventCenterFacade.getPaginationEventDTO(chosenPage);
		modelAndView.addObject(LIST_EVENTS_ATTRIBUTE_NAME, paginationEventDTO.getEventDTOList());
		modelAndView.addObject(PAGES_NUMBER_ATTRIBUTE_NAME, paginationEventDTO.getPagesNumber());
		modelAndView.addObject(CHOSEN_PAGE_ATTRIBUTE_NAME, chosenPage);
	}

	@GetMapping(value = DELETE_EVENT_REQUEST)
	public ModelAndView deleteEvent(@RequestParam(EVENT_ID_REQUEST_PARAM_NAME) int eventId) {
		eventCenterFacade.deleteEvent(eventId);
		return new ModelAndView(new RedirectView(REDIRECT_EVENT_CENTER_PAGE_URL));
	}

}
