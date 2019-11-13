package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.facades.IndexFacade;

@Controller
public class IndexPageController {
	
	IndexFacade indexFacade;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("upcomingEvents", indexFacade.getUpcomingEvents());
		return "";
	}

}
