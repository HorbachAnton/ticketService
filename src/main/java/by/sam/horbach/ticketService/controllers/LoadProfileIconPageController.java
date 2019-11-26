package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import by.sam.horbach.ticketService.facades.LoadProfileIconFacade;
import by.sam.horbach.ticketService.utils.Constants;

/**
 * A class responsible for interacting with the load user icon page.
 * 
 * @author Horbach Anton
 *
 */
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
	@RequestMapping(value = "/load_user_icon", method = RequestMethod.GET)
	public String getPage() {
		return "load_user_icon";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView loadUserIcon(@RequestParam("file") MultipartFile file) {
		loadUserIconFacade.loadProfileIcon(file);
		return new ModelAndView(REDIRECT_PREFIX + "/");
	}
}
