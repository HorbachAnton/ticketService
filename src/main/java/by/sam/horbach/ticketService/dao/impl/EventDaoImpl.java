package by.sam.horbach.ticketService.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.EventDao;
import by.sam.horbach.ticketService.entities.Event;

public class EventDaoImpl extends AbstractBaseDao implements EventDao {

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

}
