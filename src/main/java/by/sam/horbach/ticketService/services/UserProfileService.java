package by.sam.horbach.ticketService.services;

public interface UserProfileService {

	boolean updateProfile();

	boolean changePassword();

	boolean changeEmail();
	
	boolean loadIcon();

}
