package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminPageController {

	@RequestMapping(value = "/admin_page", method = RequestMethod.GET)
	public String getPage() {
		return "admin_page";
	}

	@RequestMapping(value = "/user_center_page", method = RequestMethod.GET)
	public String getUserCenterPafe() {
		return "user_center";
	}

	@RequestMapping(value = "/event_center_page", method = RequestMethod.GET)
	public String getEventCenterPage() {
		return "event_center";
	}

	@RequestMapping(value = "/ticket_center_page", method = RequestMethod.GET)
	public String getTicketCenterPage() {
		return "ticket_center";
	}

}
