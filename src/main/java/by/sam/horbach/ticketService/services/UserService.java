package by.sam.horbach.ticketService.services;

import by.sam.horbach.ticketService.entities.User;

public interface UserService {
	
	boolean register(User user);
	
	User getUserByEmail(String userEmail);

}
