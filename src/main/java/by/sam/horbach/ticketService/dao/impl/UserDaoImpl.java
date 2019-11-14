package by.sam.horbach.ticketService.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;

@Transactional
public class UserDaoImpl extends AbstractBaseDao implements UserDao {
	
	private static final String QUERY_USER_BY_EMAIL = "from User where email=?0";

    @Override
    public User findByUserEmail(String email) {
        return (User) super.getCurrentSession().createQuery(QUERY_USER_BY_EMAIL).setParameter(0, email).getSingleResult();
    }

}
