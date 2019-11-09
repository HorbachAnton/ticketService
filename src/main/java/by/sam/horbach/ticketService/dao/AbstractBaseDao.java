package by.sam.horbach.ticketService.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractBaseDao implements IAbstractBaseDao{
	
	SessionFactory session;
	
	public  void save(Object object) {
		session.getCurrentSession().save(object);
	}
	
	public  void update(Object object) {
		session.getCurrentSession().update(object);
	}
	
	public  void delete(Object object) {
		session.getCurrentSession().delete(object);
		
	}
	
	public  Object getById(int objectId) {
		return session.getCurrentSession().get(Object.class, objectId);
	}

	protected SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
	
}
