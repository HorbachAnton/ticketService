package by.sam.horbach.ticketService.services.impl;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.LocationDao;
import by.sam.horbach.ticketService.entities.Location;
import by.sam.horbach.ticketService.services.LocationService;

@Transactional
public class LocationServiceImpl implements LocationService {

	private LocationDao locationDao;

	@Override
	public Location getLocation(int id) {
		return (Location) locationDao.getById(Location.class, id);
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

}
