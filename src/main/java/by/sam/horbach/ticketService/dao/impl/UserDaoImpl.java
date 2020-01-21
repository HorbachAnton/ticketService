package by.sam.horbach.ticketService.dao.impl;

import javax.persistence.NoResultException;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;

/**
 * * A class implementing database operations associated with the User entity.
 * 
 * @author Horbach Anton
 *
 */
public class UserDaoImpl extends AbstractBaseDao implements UserDao {

	private static final String QUERY_USER_BY_EMAIL = "select * from User where email = ?";
	private static final int EMAIL_PARAMETER_POSITION = 1;

	@Override
	public User findByUserEmail(String email) {
		User user = null;

		try {
			user = (User) getCurrentSession().createSQLQuery(QUERY_USER_BY_EMAIL).addEntity(User.class)
					.setParameter(EMAIL_PARAMETER_POSITION, email).getSingleResult();
		} catch (NoResultException e) {
			user = new User();
		}

		return user;
	}

}
