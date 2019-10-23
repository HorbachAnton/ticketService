package by.sam.horbach.ticketService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.sam.horbach.ticketService.entities.User;

@Controller
public class RegistrationController {
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@ModelAttribute("user")User user, BindingResult result, ModelMap model) {
		
        if (result.hasErrors()) {
            return ;
        }
        
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
	}
}
