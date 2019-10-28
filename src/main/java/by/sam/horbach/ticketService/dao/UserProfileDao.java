package by.sam.horbach.ticketService.dao;

public interface UserProfileDao {

	boolean updateProfile();

	boolean changePassword();

	boolean changeEmail();
	
	boolean loadIcon();

}
