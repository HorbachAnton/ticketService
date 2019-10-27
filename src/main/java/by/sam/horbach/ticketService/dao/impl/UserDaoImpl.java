package by.sam.horbach.ticketService.dao.impl;

import java.util.List;

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
	SessionFactory session;

	@Override
	public boolean register(User user) {
		session.getCurrentSession().save(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String email) {
		List<User> users = session.getCurrentSession().createQuery("from User where email=?").setParameter(0, email)
				.list();

		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
