package by.sam.horbach.ticketService.services.impl;

import by.sam.horbach.ticketService.dao.LocationDao;
import by.sam.horbach.ticketService.entities.Location;
import by.sam.horbach.ticketService.services.LocationService;

public class LocationServiceImpl implements LocationService {

	LocationDao locationDao;
	
	@Override
	public Location getLocation(int id) {
 		return (Location) locationDao.getById(id);
	}

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
	
	

}
