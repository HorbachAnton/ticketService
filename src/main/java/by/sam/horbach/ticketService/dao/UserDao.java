package by.sam.horbach.ticketService.dao;

import by.sam.horbach.ticketService.entities.User;

public interface UserDao extends IAbstractBaseDao{

	User findByUserEmail(String email);

}
