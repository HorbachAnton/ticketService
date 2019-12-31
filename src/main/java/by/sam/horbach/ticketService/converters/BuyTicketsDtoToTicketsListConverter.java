package by.sam.horbach.ticketService.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.forms.BuyTicketsDTO;
import by.sam.horbach.ticketService.entities.Event;
import by.sam.horbach.ticketService.entities.Ticket;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.services.UserService;

public class BuyTicketsDtoToTicketsListConverter implements TwoWayConverter {

	TwoWayConverter eventConverter;
	TwoWayConverter userConventer;
	UserService userService;

	@Override
	public Class<?> getSourceClass() {
		return BuyTicketsDTO.class;
	}

	@Override
	public Class<?> getTargetClass() {
		return List.class;
	}

	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) throws Exception {
		BuyTicketsDTO sourceDTO = (BuyTicketsDTO) source;
		return getBookedTickets(sourceDTO);
	}

	private List<Ticket> getBookedTickets(BuyTicketsDTO buyTicketsDTO) {
		List<Ticket> bookedTickets = new ArrayList<>();

		for (int i = 0; i < buyTicketsDTO.getQuantity(); i++) {
			bookedTickets.add(getBookedTicket(buyTicketsDTO));
		}

		return bookedTickets;
	}

	private Ticket getBookedTicket(BuyTicketsDTO buyTicketsDTO) {
		Ticket bookedTicket = new Ticket();
		setupBookedTicket(bookedTicket, buyTicketsDTO);
		return bookedTicket;
	}

	private void setupBookedTicket(Ticket bookedTicket, BuyTicketsDTO buyTicketsDTO) {
		bookedTicket.setEvent(getEventWithId(buyTicketsDTO.getIdEvent()));
		bookedTicket.setUser(getUserWithId());
	}

	private Event getEventWithId(int eventId) {
		Event event = new Event();
		event.setId(eventId);
		return event;
	}

	private User getUserWithId() {
		User user = new User();
		user.setId(getUserId());
		return user;
	}

	private int getUserId() {
		return userService.getCurrentUser().getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) throws Exception {
		List<Ticket> targetTicketList = (List<Ticket>) target;
		Ticket baseTicket = targetTicketList.get(0);

		BuyTicketsDTO sourceDTO = new BuyTicketsDTO();
		sourceDTO.setIdEvent(baseTicket.getEvent().getId());
		sourceDTO.setQuantity(targetTicketList.size());

		return sourceDTO;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setEventConverter(TwoWayConverter eventConverter) {
		this.eventConverter = eventConverter;
	}

	public void setUserConventer(TwoWayConverter userConventer) {
		this.userConventer = userConventer;
	}

}
