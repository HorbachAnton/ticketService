package by.sam.horbach.ticketService.dao;

import by.sam.horbach.ticketService.entities.User;

public interface UserDao {

	boolean register(User user);

	User findByUserName(String email);

}
