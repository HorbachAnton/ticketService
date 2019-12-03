package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import by.sam.horbach.ticketService.dto.forms.BuyTicketsDTO;
import by.sam.horbach.ticketService.facades.EventFacade;
import by.sam.horbach.ticketService.validators.BuyTicketsValidator;

@Controller
public class EventPageController {

	@Autowired
	EventFacade eventFacade;

	@Autowired
	BuyTicketsValidator buyTicketsValidator;

	@RequestMapping(value = "/event_page", method = RequestMethod.GET)
	public String getPage(@ModelAttribute("eventId") Integer eventId, Model model) {
		model.addAttribute("eventDTO", eventFacade.getEventById(eventId));
		model.addAttribute("buyTicketsDTO", new BuyTicketsDTO());
		return "event";
	}

	@RequestMapping(value = "/buy_tickets", method = RequestMethod.POST)
	public ModelAndView buyTickets(@ModelAttribute("buyTicketsDTO") BuyTicketsDTO buyTicketsDTO, BindingResult result) {
		buyTicketsValidator.validate(buyTicketsDTO, result);

		if (result.hasErrors()) {
			redirectToEventPage(buyTicketsDTO, result);
		}

		eventFacade.buyTickets(buyTicketsDTO);
		return new ModelAndView(new RedirectView("/ticket-service/event_page")).addObject("eventId",
				buyTicketsDTO.getIdEvent());
	}

	private ModelAndView redirectToEventPage(@ModelAttribute("buyTicketsDTO") BuyTicketsDTO buyTicketsDTO,
			BindingResult result) {
		return new ModelAndView(new RedirectView("/ticket-service/event_page")).addObject("eventId",
				buyTicketsDTO.getIdEvent());
	}

}
