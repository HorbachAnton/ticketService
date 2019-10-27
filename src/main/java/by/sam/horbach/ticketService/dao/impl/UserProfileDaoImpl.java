package by.sam.horbach.ticketService.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.UserProfileDao;

@Repository
@Transactional
public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	SessionFactory session;

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
