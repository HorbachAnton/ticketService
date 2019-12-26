package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.PaginationTicketDTO;
import by.sam.horbach.ticketService.facades.TicketCenterFacade;

@Controller
public class TicketCenterPageController {

	private static final String PAGE_NAME = "ticket_center";
	private static final String LIST_TICKETS_NAME_ATTRIBUTE = "listTickets";
	private static final String PAGES_NUMBER_NAME_ATTRIBUTE = "numberOfPages";

	private static final int DEFAULT_CHOSEN_PAGE_VALUE = 1;

	@Autowired
	TicketCenterFacade ticketCenterFacade;

	@RequestMapping(value = "/ticket_center_page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView modelAndView = new ModelAndView(PAGE_NAME);
		PaginationTicketDTO paginationTicketDTO = ticketCenterFacade.getPaginationTicketDTO(DEFAULT_CHOSEN_PAGE_VALUE);
		modelAndView.addObject(LIST_TICKETS_NAME_ATTRIBUTE, paginationTicketDTO.getTicketDTOList());
		modelAndView.addObject(PAGES_NUMBER_NAME_ATTRIBUTE, paginationTicketDTO.getPagesNumber());
		modelAndView.addObject("chosen_page", DEFAULT_CHOSEN_PAGE_VALUE);
		return modelAndView;
	}

	@RequestMapping(value = "/get_chosen_ticket_center_page", method = RequestMethod.GET)
	public ModelAndView getChosenPage(@RequestParam("chosen_page") int chosenPage) {
		ModelAndView modelAndView = new ModelAndView(PAGE_NAME);
		PaginationTicketDTO paginationTicketDTO = ticketCenterFacade.getPaginationTicketDTO(chosenPage);
		modelAndView.addObject(LIST_TICKETS_NAME_ATTRIBUTE, paginationTicketDTO.getTicketDTOList());
		modelAndView.addObject(PAGES_NUMBER_NAME_ATTRIBUTE, paginationTicketDTO.getPagesNumber());
		modelAndView.addObject("chosen_page", chosenPage);
		return modelAndView;
	}

	public void setAdminTicketFacade(TicketCenterFacade ticketCenterFacade) {
		this.ticketCenterFacade = ticketCenterFacade;
	}

}
