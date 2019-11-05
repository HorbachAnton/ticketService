package by.sam.horbach.ticketService.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;

@Transactional
public class UserDaoImpl implements UserDao {

	SessionFactory session;

	@Override
	public boolean register(User user) {
		session.getCurrentSession().save(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserEmail(String email) {
		List<User> users = session.getCurrentSession().createQuery("from User where email=?0").setParameter(0, email)
				.list();

		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

}
