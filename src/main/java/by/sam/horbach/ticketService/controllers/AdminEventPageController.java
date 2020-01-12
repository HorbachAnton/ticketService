package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.facades.AdminEventFacade;

/**
 * The class responsible for intercepting, processing, and sending responses to
 * user requests sent from the administrator event page (admin_event.jsp). The
 * class also processing the request for getting page (admin_event.jsp).
 * 
 * @author Horbach Anton
 * 
 */
@Controller
public class AdminEventPageController {

	private static final String ADMIN_EVENT_PAGE_NAME = "admin_event";
	private static final String EVENT_ID_REQUEST_PARAMETER_NAME = "eventId";
	private static final String EVENT_DTO_MODEL_ATTRIBUTE_NAME = "eventDTO";

	@Autowired
	private Validator eventDetailsValidator;

	@Autowired
	private AdminEventFacade adminEventFacade;

	/**
	 * Processes the request for getting the administrator event page
	 * (/admin_event). Returns a ModelAndView instance of the administrator event
	 * page (admin_event.jsp).
	 * 
	 * @param eventId the identifier of the event whose data will be displayed on
	 *                the admin_event.jsp.
	 * @return a ModelAndView instance of the administrator event page
	 *         (admin_event.jsp).
	 */
	@GetMapping(value = "/admin_event")
	public ModelAndView getPage(@RequestParam(EVENT_ID_REQUEST_PARAMETER_NAME) int eventId) {
		ModelAndView modelAndView = new ModelAndView(ADMIN_EVENT_PAGE_NAME);
		setupPage(modelAndView, eventId);
		return modelAndView;
	}

	private void setupPage(ModelAndView modelAndView, int eventId) {
		modelAndView.addObject(EVENT_DTO_MODEL_ATTRIBUTE_NAME, adminEventFacade.getEvent(eventId));
	}

	/**
	 * Processes the request for changing event data (/change_event_details).
	 * Changes the specified event data and returns a ModelAndView instance of the
	 * administrator event page (admin_event.jsp).
	 * 
	 * @param eventDTO      an instance of the EventDTO class containing
	 *                      user-modified data.
	 * @param bindingResult BindingResult interface implementation
	 * @return a ModelAndView instance of the administrator event page
	 *         (admin_event.jsp).
	 */
	@PostMapping(value = "/change_event_details")
	public ModelAndView changeEventDetails(@ModelAttribute(EVENT_DTO_MODEL_ATTRIBUTE_NAME) EventDTO eventDTO,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(ADMIN_EVENT_PAGE_NAME);
		validateEventDTO(eventDTO, bindingResult);
		adminEventFacade.changeEventDetails(eventDTO);
		return modelAndView;
	}

	private void validateEventDTO(EventDTO eventDTO, BindingResult bindingResult) {
		eventDetailsValidator.validate(eventDTO, bindingResult);
	}

}
