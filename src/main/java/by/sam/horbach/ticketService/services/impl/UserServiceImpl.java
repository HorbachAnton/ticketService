package by.sam.horbach.ticketService.services.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private static final String RELATIVE_USER_ICON_PATH_REGEX = "resources\\\\*.*";

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
		Path iconPath = getAbsoluteUserIconPath(user.getId());
		file.transferTo(iconPath.toFile());
		user.setIconPath(getRelativeUserIconPath(iconPath));
		userDao.update(user);
	}

	private Path getAbsoluteUserIconPath(int userId) {
		return Paths
				.get(SERVLET_CONTEXT.getRealPath(USER_PROFILE_ICONS_PATH.toString()), userId + PROFILE_IMAGE_POSTFIX)
				.toAbsolutePath();
	}

	private String getRelativeUserIconPath(Path absolutePath) {
		String relativePath = null;
		Pattern pattern = Pattern.compile(RELATIVE_USER_ICON_PATH_REGEX);
		Matcher matcher = pattern.matcher(absolutePath.toString());

		if (matcher.find()) {
			relativePath = matcher.group();
		}

		return relativePath;
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
