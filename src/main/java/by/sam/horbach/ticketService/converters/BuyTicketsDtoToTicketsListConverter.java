package by.sam.horbach.ticketService.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.forms.BuyTicketsDTO;
import by.sam.horbach.ticketService.entities.Ticket;
import by.sam.horbach.ticketService.services.UserService;

public class BuyTicketsDtoToTicketsListConverter implements TwoWayConverter {

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

		List<Ticket> targetTicketList = new ArrayList<>();

		Ticket baseTicket = new Ticket();
		baseTicket.setIdEvent(sourceDTO.getIdEvent());
		baseTicket.setIdUser(getUserId());

		for (int j = 0; j < sourceDTO.getQuantity(); j++) {
			targetTicketList.add(baseTicket);
		}

		return targetTicketList;
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
		sourceDTO.setIdEvent(baseTicket.getIdEvent());
		sourceDTO.setQuantity(targetTicketList.size());

		return sourceDTO;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
