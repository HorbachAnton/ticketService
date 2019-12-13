package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

	@ModelAttribute("buyTicketsDTO")
	public BuyTicketsDTO createBuyTicketsDTO() {
		return new BuyTicketsDTO();
	}

	@RequestMapping(value = "/event_page", method = RequestMethod.GET)
	public String getPage(@ModelAttribute("eventId") Integer eventId, Model model, BindingResult result) {
		model.addAttribute("eventDTO", eventFacade.getEventById(eventId));
		return "event";
	}

	@RequestMapping(value = "/buy_tickets", method = RequestMethod.POST)
	public ModelAndView buyTickets(@ModelAttribute("buyTicketsDTO") BuyTicketsDTO buyTicketsDTO, BindingResult result,
			RedirectAttributes redirectAttributes) {

		RedirectView redirectView = new RedirectView("/ticket-service/");
		buyTicketsValidator.validate(buyTicketsDTO, result);

		if (result.hasErrors()) {
			redirectView.setUrl("/ticket-service/event_page");
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.buyTicketsDTO", result);
			redirectAttributes.addFlashAttribute("buyTicketsDTO", buyTicketsDTO);
		} else {
			eventFacade.buyTickets(buyTicketsDTO);
		}

		return new ModelAndView(redirectView).addObject("eventId", buyTicketsDTO.getIdEvent());
	}

}
