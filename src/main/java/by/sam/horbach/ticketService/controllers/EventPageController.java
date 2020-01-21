package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import by.sam.horbach.ticketService.dto.forms.BuyTicketsDTO;
import by.sam.horbach.ticketService.facades.EventFacade;

@Controller
public class EventPageController {

	private static final String GET_EVENT_PAGE_REQUEST = "/event_page";
	private static final String BUY_TICKETS_REQUEST = "/buy_tickets";

	private static final String BUY_TICKETS_DTO_MODEL_ATTRIBUTE_NAME = "buyTicketsDTO";
	private static final String EVENT_DTO_MODEL_ATTRIBUTE_NAME = "eventDTO";
	private static final String EVENT_ID_MODEL_ATTRIBUTE_NAME = "eventId";
	private static final String BINDING_RESULT_ATTRIBUTE_NAME = "org.springframework.validation.BindingResult.buyTicketsDTO";

	private static final String TICKET_SERVICE_REDIRECT_URL = "/ticket-service/";
	private static final String EVENT_PAGE_REDIRECT_URL = "/ticket-service/event_page";

	private static final String EVENT_PAGE_NAME = "event";

	@Autowired
	private EventFacade eventFacade;

	@Autowired
	private Validator buyTicketsValidator;

	@ModelAttribute(BUY_TICKETS_DTO_MODEL_ATTRIBUTE_NAME)
	public BuyTicketsDTO createBuyTicketsDTO() {
		return new BuyTicketsDTO();
	}

	@GetMapping(value = GET_EVENT_PAGE_REQUEST)
	public String getPage(@ModelAttribute(EVENT_ID_MODEL_ATTRIBUTE_NAME) Integer eventId, Model model,
			BindingResult result) {
		model.addAttribute(EVENT_DTO_MODEL_ATTRIBUTE_NAME, eventFacade.getEventById(eventId));
		return EVENT_PAGE_NAME;
	}

	@PostMapping(value = BUY_TICKETS_REQUEST)
	public ModelAndView buyTickets(@ModelAttribute(BUY_TICKETS_DTO_MODEL_ATTRIBUTE_NAME) BuyTicketsDTO buyTicketsDTO,
			BindingResult result, RedirectAttributes redirectAttributes) {

		RedirectView redirectView = new RedirectView(TICKET_SERVICE_REDIRECT_URL);
		buyTicketsValidator.validate(buyTicketsDTO, result);

		if (result.hasErrors()) {
			redirectView.setUrl(EVENT_PAGE_REDIRECT_URL);
			redirectAttributes.addFlashAttribute(BINDING_RESULT_ATTRIBUTE_NAME, result);
			redirectAttributes.addFlashAttribute(BUY_TICKETS_DTO_MODEL_ATTRIBUTE_NAME, buyTicketsDTO);
		} else {
			eventFacade.buyTickets(buyTicketsDTO);
		}

		return new ModelAndView(redirectView).addObject(EVENT_ID_MODEL_ATTRIBUTE_NAME, buyTicketsDTO.getIdEvent());
	}

}
