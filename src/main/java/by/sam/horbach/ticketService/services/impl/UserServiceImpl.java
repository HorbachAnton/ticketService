package by.sam.horbach.ticketService.services.impl;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao;

	public boolean register(User user) {
		boolean result = true;
		userDao.register(user);
		return result;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
