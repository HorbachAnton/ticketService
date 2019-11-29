package by.sam.horbach.ticketService.services.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.entities.UserRoles;
import by.sam.horbach.ticketService.services.UserService;
import by.sam.horbach.ticketService.utils.Constants;

public class UserServiceImpl implements UserService, Constants {

	private static final String PROFILE_IMAGE_POSTFIX = "_profile_icon.png";

	PasswordEncoder passwordEncoder;
	UserDao userDao;

	public boolean register(User user) {
		boolean result = true;
		prepareUser(user);
		userDao.save(user);
		return result;
	}

	private User prepareUser(User user) {
		user.setIdRole(UserRoles.CONSUMER.getId());
		user.setEnabled(true);
		user.setPassword(encodePassword(user.getPassword()));
		return user;
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public void changePassword(User user) {
		user.setPassword(encodePassword(user.getPassword()));
		userDao.update(user);
	}

	public void changePersonalData(User user) {
		userDao.update(user);
	}

	@Override
	public void saveProfileIcon(MultipartFile file) throws IOException {
		User user = getCurrentUser();
		Path iconPath = getUserIconPath(user.getId());
		file.transferTo(iconPath.toFile());
		user.setIconPath(iconPath.toString());
		userDao.update(user);
	}

	private Path getUserIconPath(int userId) {
		return Paths.get(SERVLET_CONTEXT.getRealPath(USER_PROFILE_ICONS_PATH.toString()), userId + PROFILE_IMAGE_POSTFIX).toAbsolutePath();
	}

	public User getUserByEmail(String userEmail) {
		return userDao.findByUserEmail(userEmail);
	}

	@Override
	public User getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();

		if (!isAuthenticated(authentication)) {
			return null;
		}

		return userDao.findByUserEmail(authentication.getName());
	}

	@Override
	public boolean isCurrentUser(User user) {
		return getCurrentUser().equals(user);
	}

	@Override
	public boolean isAuthenticated(Authentication authentication) {
		return authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
				&& authentication.isAuthenticated();
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}
