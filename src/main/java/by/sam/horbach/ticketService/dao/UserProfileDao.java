package by.sam.horbach.ticketService.dao;

public interface UserProfileDao {

	public boolean updateProfile();

	public boolean changePassword();

	public boolean changeEmail();
	
	public boolean loadIcon();

}
