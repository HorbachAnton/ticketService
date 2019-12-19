package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.facades.AdminEventFacade;

@Controller
public class EventCreationPageController {

	public static final String EVENT_DTO_ATTRIBUTE_NAME = "eventDTO";

	public static final String EVENT_CREATION_URL = "/event_creation";
	public static final String EVENT_CREATION_VIEW_NAME = "event_creation";

	public static final String ADD_EVENT_COMMAND_URL = "/add_new_event";

	public static final String EVENT_CENTER_URL = "event_center_page";

	@Autowired
	Validator eventDetailsValidator;

	@Autowired
	AdminEventFacade adminEventFacade;

	@ModelAttribute(EVENT_DTO_ATTRIBUTE_NAME)
	public EventDTO getEventDTO() {
		return new EventDTO();
	}

	@RequestMapping(value = EVENT_CREATION_URL, method = RequestMethod.GET)
	public ModelAndView getPage() {
		return new ModelAndView(EVENT_CREATION_VIEW_NAME);
	}

	@RequestMapping(value = ADD_EVENT_COMMAND_URL, method = RequestMethod.POST)
	public ModelAndView addEvent(@ModelAttribute(EVENT_DTO_ATTRIBUTE_NAME) EventDTO eventDTO,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView(EVENT_CENTER_URL));
		adminEventFacade.addEvent(eventDTO);
		eventDetailsValidator.validate(eventDTO, bindingResult);
		return modelAndView;
	}

}
