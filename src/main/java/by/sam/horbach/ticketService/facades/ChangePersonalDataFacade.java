package by.sam.horbach.ticketService.facades;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.services.UserService;

public class ChangePersonalDataFacade {

	TwoWayConverter converter;
	UserService userService;
	
	public void setConverter(TwoWayConverter converter) {
		this.converter = converter;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
