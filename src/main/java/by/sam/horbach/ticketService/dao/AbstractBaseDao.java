package by.sam.horbach.ticketService.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract base class implementing the common IAbstractBaseDao methods.
 * 
 * @author Horbach Anton
 *
 */
@Transactional
public abstract class AbstractBaseDao implements IAbstractBaseDao {

	protected SessionFactory session;

	public void save(Object object) {
		session.getCurrentSession().save(object);
	}

	public void update(Object object) {
		session.getCurrentSession().update(object);
	}

	public void delete(Object object) {
		session.getCurrentSession().delete(object);
	}

	public <T> Object getById(Class<T> expectedClass, int objectId) {
		return session.getCurrentSession().get(expectedClass, objectId);
	}

	protected Session getCurrentSession() {
		return session.getCurrentSession();
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

}
