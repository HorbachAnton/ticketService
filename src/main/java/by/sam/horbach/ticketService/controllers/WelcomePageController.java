package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.facades.WelcomeFacade;

@Controller
public class WelcomePageController {
	
	@Autowired
	WelcomeFacade welcomeFacadeFacade;
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("upcomingEvents", welcomeFacadeFacade.getUpcomingEvents());
		return "welcome";
	}
	
	@RequestMapping(value="/moreInfo")
	public String  moreInfo() {
		return "event";
	}

}
