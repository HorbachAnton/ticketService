package by.sam.horbach.ticketService.converters;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.dto.TicketDTO;
import by.sam.horbach.ticketService.dto.UserDTO;
import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.entities.Ticket;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.EventService;
import by.sam.horbach.ticketService.services.TicketService;
import by.sam.horbach.ticketService.services.UserService;

public class TicketToDTOConverter implements TwoWayConverter {

	TwoWayConverter userConverter;
	TwoWayConverter eventConverter;
	TicketService ticketService;
	EventService eventService;
	UserService userService;

	@Override
	public Class<Ticket> getSourceClass() {
		return Ticket.class;
	}

	@Override
	public Class<TicketDTO> getTargetClass() {
		return TicketDTO.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) throws Exception {
		Ticket ticket = (Ticket) source;

		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setId(ticket.getId());
		ticketDTO.setEvent((EventDTO) eventConverter.convertSourceToTargetClass(ticket.getEvent(), EventDTO.class));
		ticketDTO.setUser((UserDTO) userConverter.convertSourceToTargetClass(ticket.getUser(), UserDTO.class));

		return ticketDTO;
	}

	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) throws Exception {
		TicketDTO ticketDTO = (TicketDTO) target;

		Ticket ticket = new Ticket();
		ticket.setId(ticketDTO.getId());
		ticket.setEvent((Event) eventConverter.convertTargetToSourceClass(ticketDTO.getEvent(), Event.class));
		ticket.setUser((User) userConverter.convertTargetToSourceClass(ticketDTO.getUser(), User.class));

		return ticket;
	}

	public void setUserConverter(TwoWayConverter userConverter) {
		this.userConverter = userConverter;
	}

	public void setEventConverter(TwoWayConverter eventConverter) {
		this.eventConverter = eventConverter;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
