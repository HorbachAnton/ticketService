package by.sam.horbach.ticketService.dao;

public interface IAbstractBaseDao {
	
	void save(Object object);
	
	void update(Object object);
	
	void delete(Object object);
	
	Object getById(int objectId);

}
