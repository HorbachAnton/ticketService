package by.sam.horbach.ticketService.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.entities.UserRoles;
import by.sam.horbach.ticketService.services.UserService;

public class UserServiceImpl implements UserService {

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
	
	public User getUserByEmail(String userEmail) {
		return userDao.findByUserEmail(userEmail);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}
