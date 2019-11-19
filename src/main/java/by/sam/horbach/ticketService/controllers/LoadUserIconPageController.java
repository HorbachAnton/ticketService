package by.sam.horbach.ticketService.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoadUserIconPageController {

	@RequestMapping(value = "/load_user_icon", method = RequestMethod.GET)
	public String getPage() {
		return "load_user_icon";
	}
}
