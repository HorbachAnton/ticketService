package by.sam.horbach.ticketService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	private static final String LOAD_USER_ICON_PAGE_REQUEST = "/load_user_icon_page";
	private static final String UPLOAD_FILE_REQUEST = "/upload_file";

	private static final String FILE_UPLOAD_DTO_MODEL_ATTRIBUTE_NAME = "fileUploadDTO";

	private static final String LOAD_PROFILE_ICON_PAGE_NAME = "load_profile_icon";
	private static final String REDIRECT_INDEX_PAGE_NAME = REDIRECT_PREFIX + "/";

	@Autowired
	private LoadProfileIconFacade loadUserIconFacade;

	@Autowired
	private Validator loadProfileIconValidator;

	/**
	 * Returns a view name of a load user icon page to be resolved with ViewResolver
	 * implementations and used together with the implicit model — determined
	 * through command objects and @ModelAttribute methods.
	 * 
	 * @return a view name of a load user icon page
	 */
	@GetMapping(value = LOAD_USER_ICON_PAGE_REQUEST)
	public String getPage(Model model) {
		model.addAttribute(FILE_UPLOAD_DTO_MODEL_ATTRIBUTE_NAME, new FileUploadDTO());
		return LOAD_PROFILE_ICON_PAGE_NAME;
	}

	@PostMapping(value = UPLOAD_FILE_REQUEST)
	public ModelAndView loadUserIcon(@ModelAttribute(FILE_UPLOAD_DTO_MODEL_ATTRIBUTE_NAME) FileUploadDTO file,
			BindingResult result, ModelAndView model) {
		loadProfileIconValidator.validate(file, result);

		if (result.hasErrors()) {
			return new ModelAndView(LOAD_PROFILE_ICON_PAGE_NAME);
		}

		loadUserIconFacade.loadProfileIcon(file.getFile());
		return new ModelAndView(REDIRECT_INDEX_PAGE_NAME);
	}

}
