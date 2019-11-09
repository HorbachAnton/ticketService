package by.sam.horbach.ticketService.dao;

public interface IAbstractBaseDao {
	
	void save(Object user);
	
	void update(Object user);
	
	void delete(Object user);
	
	Object getById(int userId);

}
