package by.sam.horbach.ticketService.facades.impl;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.PaginationTicketDTO;
import by.sam.horbach.ticketService.dto.TicketDTO;
import by.sam.horbach.ticketService.entities.Ticket;
import by.sam.horbach.ticketService.facades.TicketCenterFacade;
import by.sam.horbach.ticketService.services.TicketService;

public class TicketCenterFacadeImpl implements TicketCenterFacade {

	private static final Logger LOGGER = LogManager.getLogger(TicketCenterFacadeImpl.class);
	private static final String CONVERT_TO_DTO_LIST_ERROR_MESSAGE = "Failed to convert List<Ticket> in List<TicketDTO>";

	private static final int TICKET_NUMBER_ON_PAGE = 6;
	private static final int FIRST_TICKET_DEFAULT_VALUE = 0;
	private static final int LAST_TICKET_DEFAULT_VALUE = 6;

	private TwoWayConverter ticketListToDTOListConverter;
	private TicketService ticketService;

	@Override
	public PaginationTicketDTO getPaginationTicketDTO(int chosenPage) {
		List<Ticket> ticketList = ticketService.getTickets();

		PaginationTicketDTO paginationTicketDTO = new PaginationTicketDTO();
		paginationTicketDTO.setPagesNumber((int) Math.ceil((double) ticketList.size() / 6));
		paginationTicketDTO.setTicketDTOList(convertTickeListToTicketDTOList(getTicketSubList(ticketList, chosenPage)));

		return paginationTicketDTO;
	}

	private List<Ticket> getTicketSubList(List<Ticket> ticketList, int chosenPage) {
		List<Ticket> pagginationTicketList = null;

		if (chosenPage == 1) {
			pagginationTicketList = getTicketSubList(ticketList, FIRST_TICKET_DEFAULT_VALUE, LAST_TICKET_DEFAULT_VALUE);
		} else {
			int lastTicket = chosenPage * TICKET_NUMBER_ON_PAGE;
			pagginationTicketList = getTicketSubList(ticketList, lastTicket - TICKET_NUMBER_ON_PAGE, lastTicket);
		}

		return pagginationTicketList;
	}

	private List<Ticket> getTicketSubList(List<Ticket> ticketList, int firstTicket, int lastTicket) {
		List<Ticket> pagginationTicketList = null;

		if (ticketList.size() > lastTicket || ticketList.size() == lastTicket) {
			pagginationTicketList = ticketList.subList(firstTicket, lastTicket);
		} else {
			pagginationTicketList = ticketList.subList(firstTicket, ticketList.size());
		}

		return pagginationTicketList;
	}

	@SuppressWarnings("unchecked")
	private List<TicketDTO> convertTickeListToTicketDTOList(List<Ticket> ticketList) {
		List<TicketDTO> ticketDTOList = Collections.emptyList();

		try {
			ticketDTOList = (List<TicketDTO>) ticketListToDTOListConverter.convertSourceToTargetClass(ticketList,
					List.class);
		} catch (Exception exception) {
			LOGGER.error(CONVERT_TO_DTO_LIST_ERROR_MESSAGE, exception);
		}

		return ticketDTOList;
	}

	public void setTicketListToDTOListConverter(TwoWayConverter ticketListToDTOListConverter) {
		this.ticketListToDTOListConverter = ticketListToDTOListConverter;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

}
