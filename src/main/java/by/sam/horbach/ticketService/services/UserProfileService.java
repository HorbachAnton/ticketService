package by.sam.horbach.ticketService.services;

public interface UserProfileService {

	public boolean updateProfile();

	public boolean changePassword();

	public boolean changeEmail();
	
	public boolean loadIcon();

}
