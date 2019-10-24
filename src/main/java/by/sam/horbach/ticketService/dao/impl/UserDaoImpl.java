package by.sam.horbach.ticketService.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Override
	public boolean register(User user) {
		boolean result = true;

		return result;
	}

}
