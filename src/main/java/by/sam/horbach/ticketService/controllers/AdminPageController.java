package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

	private static final String GET_ADMIN_PAGE_REQUEST = "/admin_page";
	private static final String ADMIN_PAGE_NAME = "admin_page";

	@GetMapping(value = GET_ADMIN_PAGE_REQUEST)
	public String getPage() {
		return ADMIN_PAGE_NAME;
	}

}
