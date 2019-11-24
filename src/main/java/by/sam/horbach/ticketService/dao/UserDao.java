package by.sam.horbach.ticketService.dao;

import by.sam.horbach.ticketService.entities.User;

/**
 * A class implementing this interface must implement database operations
 * associated with the user entity.
 * 
 * @author Horbach Anton
 *
 */
public interface UserDao extends IAbstractBaseDao {

	/**
	 * Returns the user from the database by email.
	 * 
	 * @param email search email
	 * @return User object
	 */
	User findByUserEmail(String email);

}
