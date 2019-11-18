package by.sam.horbach.ticketService.services;

import org.springframework.security.core.Authentication;

import by.sam.horbach.ticketService.entities.User;

public interface UserService {
	
	boolean register(User user);
	
	void changePassword(User user);
	
	User getUserByEmail(String userEmail);
	
	User getCurrentUser();
	
	boolean isCurrentUser(User user);
	
	boolean isAuthenticated(Authentication authentication);

}
