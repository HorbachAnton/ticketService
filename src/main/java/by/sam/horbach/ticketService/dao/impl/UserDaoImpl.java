package by.sam.horbach.ticketService.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;

@Transactional
public class UserDaoImpl extends AbstractBaseDao implements UserDao {

    @Override
    public User findByUserEmail(String email) {
        return (User) super.getCurrentSession().createQuery("from User where email=?0").setParameter(0, email).getSingleResult();
    }

}
