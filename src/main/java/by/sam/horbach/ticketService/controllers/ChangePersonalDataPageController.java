package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.forms.PersonalDataDTO;
import by.sam.horbach.ticketService.facades.ChangePersonalDataFacade;

@Controller
public class ChangePersonalDataPageController {

	@Autowired
	ChangePersonalDataFacade changePersonalDataFacade;

	@RequestMapping(value = "/change_personal_data_page", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("personalDataDTO", new PersonalDataDTO());
		return "changePersonalData";
	}

	@RequestMapping(value = "/change_personal_data", method = RequestMethod.POST)
	public ModelAndView change(@ModelAttribute("personalDataDTO") PersonalDataDTO personalDataDTO, BindingResult result, ModelMap map) {
		changePersonalDataFacade.changePersonalData(personalDataDTO);
		return new ModelAndView("redirect:/welcome");
	}

}
