package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.facades.EventFacade;

@Controller
public class EventPageController {

	@Autowired
	EventFacade eventFacade;

	@RequestMapping(value = "/event_page", method = RequestMethod.GET)
	public String getPage(@ModelAttribute("eventId") Integer eventId, Model model) {
		model.addAttribute("eventDTO", eventFacade.getEventById(eventId));
		return "event";
	}
	
}
