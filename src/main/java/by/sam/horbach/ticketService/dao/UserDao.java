package by.sam.horbach.ticketService.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import by.sam.horbach.ticketService.entities.User;

public class UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean register(User user) {
		boolean result = true;
		return result;
	}

}
