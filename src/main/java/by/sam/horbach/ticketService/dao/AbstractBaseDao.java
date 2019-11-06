package by.sam.horbach.ticketService.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.entities.User;

@Transactional
public abstract class AbstractBaseDao implements IAbstractBaseDao{
	
	SessionFactory session;
	
	public  void save(User user) {
		session.getCurrentSession().save(user);
	}
	
	public  void update(User user) {
		session.getCurrentSession().update(user);
	}
	
	public  void delete(User user) {
		session.getCurrentSession().delete(user);
		
	}
	
	public  User getById(int userId) {
		return session.getCurrentSession().get(User.class, userId);
	}

	protected SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
	
}
