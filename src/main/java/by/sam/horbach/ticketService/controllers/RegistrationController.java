package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void registry() {
		
	}
}
