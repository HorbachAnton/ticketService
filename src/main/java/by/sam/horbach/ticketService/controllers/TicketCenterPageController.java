package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.PaginationTicketDTO;
import by.sam.horbach.ticketService.facades.TicketCenterFacade;

/**
 * A class responsible for interacting with the ticket center page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class TicketCenterPageController {

	private static final String PAGE_NAME = "ticket_center";
	private static final String LIST_TICKETS_ATTRIBUTE_NAME = "listTickets";
	private static final String PAGES_NUMBER_ATTRIBUTE_NAME = "numberOfPages";
	private static final String CHOSEN_PAGE_ATTRIBUTE_NAME = "chosen_page";

	private static final String CHOSEN_PAGE_REQUEST_PARAMETER_NAME = "chosen_page";

	private static final int DEFAULT_CHOSEN_PAGE_VALUE = 1;

	@Autowired
	TicketCenterFacade ticketCenterFacade;

	/**
	 * Returns a ModelAndView for ticket_center.jsp in response to a
	 * "ticket_center_page" request. As a page for pagination, returns the page with
	 * the number defined in the DEFAULT_CHOSEN_PAGE_VALUE constant.
	 * 
	 * 
	 * @return ModelAndView instance.
	 */
	@GetMapping(value = "/ticket_center_page")
	public ModelAndView getPage() {
		ModelAndView modelAndView = createModelAndView();
		PaginationTicketDTO paginationTicketDTO = getPaginationTicketDTO(DEFAULT_CHOSEN_PAGE_VALUE);
		setupPage(paginationTicketDTO, modelAndView, DEFAULT_CHOSEN_PAGE_VALUE);
		return modelAndView;
	}

	/**
	 * Returns a ModelAndView for ticket_center.jsp in response to a
	 * "ticket_center_page" request. As a page for pagination, returns the page with
	 * the number defined in the request parameter (the parameter name defined in
	 * the CHOSEN_PAGE_REQUEST_PARAMETER_NAME constant).
	 * 
	 * @param chosenPage a page number for pagination.
	 * @return ModelAndView instance.
	 */
	@GetMapping(value = "/get_chosen_ticket_center_page")
	public ModelAndView getChosenPage(@RequestParam(CHOSEN_PAGE_REQUEST_PARAMETER_NAME) int chosenPage) {
		ModelAndView modelAndView = createModelAndView();
		PaginationTicketDTO paginationTicketDTO = getPaginationTicketDTO(chosenPage);
		setupPage(paginationTicketDTO, modelAndView, chosenPage);
		return modelAndView;
	}

	private ModelAndView createModelAndView() {
		return new ModelAndView(PAGE_NAME);
	}

	private PaginationTicketDTO getPaginationTicketDTO(int chosenPage) {
		return ticketCenterFacade.getPaginationTicketDTO(chosenPage);
	}

	private void setupPage(PaginationTicketDTO paginationTicketDTO, ModelAndView modelAndView, int chosenPage) {
		modelAndView.addObject(LIST_TICKETS_ATTRIBUTE_NAME, paginationTicketDTO.getTicketDTOList());
		modelAndView.addObject(PAGES_NUMBER_ATTRIBUTE_NAME, paginationTicketDTO.getPagesNumber());
		modelAndView.addObject(CHOSEN_PAGE_ATTRIBUTE_NAME, chosenPage);
	}

	public void setAdminTicketFacade(TicketCenterFacade ticketCenterFacade) {
		this.ticketCenterFacade = ticketCenterFacade;
	}

}
