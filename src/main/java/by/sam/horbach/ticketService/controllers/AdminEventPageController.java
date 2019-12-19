package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.facades.AdminEventFacade;

@Controller
public class AdminEventPageController {

	@Autowired
	Validator eventDetailsValidator;

	@Autowired
	AdminEventFacade adminEventFacade;

	@RequestMapping(value = "/admin_event", method = RequestMethod.GET)
	public ModelAndView getPage(@RequestParam("eventId") int eventId) {
		ModelAndView modelAndView = new ModelAndView("admin_event");
		modelAndView.addObject("eventDTO", adminEventFacade.getEvent(eventId));
		return modelAndView;
	}

	@RequestMapping(value = "/change_event_details", method = RequestMethod.POST)
	public ModelAndView changeEventDetails(@ModelAttribute("eventDTO") EventDTO eventDTO, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("admin_event");
		eventDetailsValidator.validate(eventDTO, bindingResult);
		adminEventFacade.changeEventDetails(eventDTO);
		return modelAndView;
	}

}
