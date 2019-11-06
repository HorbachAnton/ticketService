package by.sam.horbach.ticketService.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;

@Transactional
public class UserDaoImpl extends AbstractBaseDao implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserEmail(String email) {
		List<User> users = super.getSession().getCurrentSession().createQuery("from User where email=?0").setParameter(0, email)
				.list();

		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
}
