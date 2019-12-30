package by.sam.horbach.ticketService.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Abstract base class implementing the common IAbstractBaseDao methods.
 * 
 * @author Horbach Anton
 *
 */
public abstract class AbstractBaseDao implements IAbstractBaseDao {

	protected SessionFactory session;

	@Override
	public void save(Object object) {
		session.getCurrentSession().save(object);
	}

	@Override
	public void update(Object object) {
		session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Object object) {
		session.getCurrentSession().delete(object);
	}

	@Override
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
