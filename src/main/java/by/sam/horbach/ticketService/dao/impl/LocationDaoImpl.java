package by.sam.horbach.ticketService.dao.impl;

import javax.persistence.NoResultException;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.LocationDao;
import by.sam.horbach.ticketService.entities.Location;

/**
 * A class implementing database operations associated with the Location entity.
 * 
 * @author Horbach Anton
 *
 */
public class LocationDaoImpl extends AbstractBaseDao implements LocationDao {

	private static final String FIND_LOCATION_BY_TITLE_QUERY = "SELECT * FROM Location Where title = ?";

	@Override
	public Location getLocationByTitle(String title) {
		Location location = null;

		try {
			location = (Location) getCurrentSession().createSQLQuery(FIND_LOCATION_BY_TITLE_QUERY)
					.addEntity(Location.class).setParameter(1, title).getSingleResult();
		} catch (NoResultException e) {
			location = null;
		}

		return location;
	}

}
