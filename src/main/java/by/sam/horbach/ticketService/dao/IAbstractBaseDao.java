package by.sam.horbach.ticketService.dao;

import by.sam.horbach.ticketService.entities.User;

public interface IAbstractBaseDao {
	
	void save(User user);
	
	void update(User user);
	
	void delete(User user);
	
	User getById(int userId);

}
