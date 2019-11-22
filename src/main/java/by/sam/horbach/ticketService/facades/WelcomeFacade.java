package by.sam.horbach.ticketService.facades;

import java.util.List;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.entities.Comment;

public interface WelcomeFacade {
	
	List<EventDTO> getUpcomingEvents();
	
	List<Comment> getComments();

}
