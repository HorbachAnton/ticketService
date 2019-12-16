package by.sam.horbach.ticketService.services;

import by.sam.horbach.ticketService.entities.Location;

public interface LocationService {

	Location getLocation(int id);

	Location getLocationByTitle(String title);

	void saveLocation(Location location);

}
