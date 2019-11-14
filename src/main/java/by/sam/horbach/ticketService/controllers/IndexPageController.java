package by.sam.horbach.ticketService.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexPageController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getPage(Model model) {
		return StringUtils.EMPTY;
	}

}
