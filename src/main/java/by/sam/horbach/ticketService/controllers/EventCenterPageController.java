package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.facades.EventCenterFacade;

@Controller
public class EventCenterPageController {

	private static final String PAGE_NAME = "event_center";

	private static final int EVENTS_NUMBER_ON_PAGE = 6;

	private static final String LIST_EVENTS_NAME_ATTRIBUTE = "listEvents";

	private static final String FIRST_EVENT_NAME_ATTRIBUTE = "first_event";
	private static final int DEFAULT_FIRST_EVENT_VALUE_ATTRIBUTE = 0;

	private static final String LAST_EVENT_NAME_ATTRIBUTE = "last_event";
	private static final int SUBTRAHEND_LAST_EVENT_ATTRIBUTE = 1;
	private static final int DEFAULT_LAST_EVENT_VALUE_ATTRIBUTE = EVENTS_NUMBER_ON_PAGE
			- SUBTRAHEND_LAST_EVENT_ATTRIBUTE;

	@Autowired
	EventCenterFacade eventCenterFacade;

	@RequestMapping(value = "/event_center_page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView modelAndView = new ModelAndView(PAGE_NAME);
		modelAndView.addObject(LIST_EVENTS_NAME_ATTRIBUTE, eventCenterFacade.getEventList());
		modelAndView.addObject(FIRST_EVENT_NAME_ATTRIBUTE, DEFAULT_FIRST_EVENT_VALUE_ATTRIBUTE);
		modelAndView.addObject(LAST_EVENT_NAME_ATTRIBUTE, DEFAULT_LAST_EVENT_VALUE_ATTRIBUTE);
		return modelAndView;
	}

}
