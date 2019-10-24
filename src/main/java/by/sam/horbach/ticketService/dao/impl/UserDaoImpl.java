package by.sam.horbach.ticketService.dao.impl;

<<<<<<< HEAD
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
=======
import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;

public class UserDaoImpl implements UserDao {
>>>>>>> 33a45cc416dd83db7990844594e53a52cac926cc

	@Override
	public boolean register(User user) {
		boolean result = true;

		return result;
	}

}
