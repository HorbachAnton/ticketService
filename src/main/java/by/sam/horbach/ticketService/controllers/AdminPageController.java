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

}
