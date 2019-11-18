package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.facades.ChangePersonalDataFacade;

@Controller
public class ChangePersonalDataPageController {
	
	@Autowired
	ChangePersonalDataFacade changePersonalDataFacade;
	
	@RequestMapping(value = "/change_personal_data_page", method = RequestMethod.GET)
	public String getPage() {
		return "changePersonalData";
	}

}
