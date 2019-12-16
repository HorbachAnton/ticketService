package by.sam.horbach.ticketService.dao;

import by.sam.horbach.ticketService.entities.Location;

/**
 * A class implementing this interface must implement database operations
 * associated with the Location entity.
 * 
 * @author Horbach Anton
 *
 */
public interface LocationDao extends IAbstractBaseDao {
	
	Location getLocationByTitle(String title);

}
