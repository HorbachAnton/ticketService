package by.sam.horbach.ticketService.facades.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import by.sam.horbach.ticketService.facades.LoadProfileIconFacade;
import by.sam.horbach.ticketService.services.UserService;

public class LoadProfileIconFacadeImpl implements LoadProfileIconFacade {

	private static final String ERROR_MESSAGE = "Failed to save user profile icon";
	private static final Logger LOGGER = LogManager.getLogger(LoadProfileIconFacadeImpl.class);

	UserService userService;

	@Override
	public void loadProfileIcon(MultipartFile file) {
		try {
			userService.saveProfileIcon(file);
		} catch (IOException exception) {
			LOGGER.error(ERROR_MESSAGE, exception);
		}
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
