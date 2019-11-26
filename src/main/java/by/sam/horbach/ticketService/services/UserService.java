package by.sam.horbach.ticketService.services;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import by.sam.horbach.ticketService.entities.User;

public interface UserService {

	boolean register(User user);

	void changePassword(User user);

	void changePersonalData(User user);

	User getUserByEmail(String userEmail);

	User getCurrentUser();

	void saveProfileIcon(MultipartFile file) throws IOException;

	boolean isCurrentUser(User user);

	boolean isAuthenticated(Authentication authentication);

}
