package by.sam.horbach.ticketService.dao;

/**
 * A class implementing this interface should implement the general operations
 * of adding, deleting, receiving and updating objects in the database.
 * 
 * @author Horbach Anton
 *
 */
public interface IAbstractBaseDao {

	/**
	 * Saves an object in the database
	 * 
	 * @param object search object
	 */
	void save(Object object);

	/**
	 * Updates an object in the database
	 * 
	 * @param object search object
	 */
	void update(Object object);

	/**
	 * Deletes an object in the database
	 * 
	 * @param object search object
	 */
	void delete(Object object);

	/**
	 * Returns an object from the database by its ID
	 * 
	 * @param <T>
	 * @param expectedClass
	 * @param objectId
	 * @return search object
	 */
	<T> Object getById(Class<T> expectedClass, int objectId);

}
