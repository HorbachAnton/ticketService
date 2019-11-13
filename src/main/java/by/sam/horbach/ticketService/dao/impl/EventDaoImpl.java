package by.sam.horbach.ticketService.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.EventDao;
import by.sam.horbach.ticketService.entities.Event;

@Transactional
public class EventDaoImpl extends AbstractBaseDao implements EventDao {
	
	private static final String COLUMN_EVENT_DATE = "date";
	private static final int NUMBER_UPCOMING_EVENT = 4;

	@Override
	public List<Event> getEvents() {
		Session currentSession = super.session.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Event> cr = cb.createQuery(Event.class);
		Root<Event> root = cr.from(Event.class);
		cr.select(root);
		
		Query<Event> query = currentSession.createQuery(cr);
		return query.getResultList();
	}

	@Override
	public List<Event> getUpcomingEvents() {
		Session currentSession = super.session.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Event> cr = cb.createQuery(Event.class);
		Root<Event> root = cr.from(Event.class);
		cr.select(root);
		cr.orderBy(cb.desc(root.get(COLUMN_EVENT_DATE)));
		
		Query<Event> query = currentSession.createQuery(cr).setMaxResults(NUMBER_UPCOMING_EVENT);
		return query.getResultList();
	}

}
