package by.sam.horbach.ticketService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.sam.horbach.ticketService.dao.UserProfileDao;
import by.sam.horbach.ticketService.services.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileDao userProfileDao;

	@Override
	public boolean updateProfile() {
		return false;
	}

	@Override
	public boolean changePassword() { 
		return false;
	}

	@Override
	public boolean changeEmail() {
		return false;
	}

	@Override
	public boolean loadIcon() {
		return false;
	}

}
