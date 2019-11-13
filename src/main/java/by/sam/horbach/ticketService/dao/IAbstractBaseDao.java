package by.sam.horbach.ticketService.dao;

public interface IAbstractBaseDao {
	
	void save(Object object);
	
	void update(Object object);
	
	void delete(Object object);
	
	<T> Object getById(Class<T> expectedClass, int objectId);

}
