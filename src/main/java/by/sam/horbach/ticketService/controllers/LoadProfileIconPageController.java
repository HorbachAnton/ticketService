package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.dto.forms.FileUploadDTO;
import by.sam.horbach.ticketService.facades.LoadProfileIconFacade;
import by.sam.horbach.ticketService.utils.Constants;

/**
 * A class responsible for interacting with the load user icon page.
 * 
 * @author Horbach Anton
 *
 */
@Controller
public class LoadProfileIconPageController implements Constants {

	@Autowired
	LoadProfileIconFacade loadUserIconFacade;

	/**
	 * Returns a view name of a load user icon page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of a load user icon page
	 */
	@RequestMapping(value = "/load_user_icon_page", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("fileUploadDTO", new FileUploadDTO());
		return "load_profile_icon";
	}

	@RequestMapping(value = "/upload_file", method = RequestMethod.POST)
	public ModelAndView loadUserIcon(@ModelAttribute("fileUploadDTO") FileUploadDTO file, BindingResult result) {
		loadUserIconFacade.loadProfileIcon(file.getFile());
		return new ModelAndView(REDIRECT_PREFIX + "/");
	}
}
