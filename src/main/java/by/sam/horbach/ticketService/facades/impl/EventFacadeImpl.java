package by.sam.horbach.ticketService.facades.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.EventDTO;
import by.sam.horbach.ticketService.dto.forms.BuyTicketsDTO;
import by.sam.horbach.ticketService.entities.Ticket;
import by.sam.horbach.ticketService.facades.EventFacade;
import by.sam.horbach.ticketService.services.EventService;
import by.sam.horbach.ticketService.services.TicketService;

public class EventFacadeImpl implements EventFacade {

	TwoWayConverter buyTicketsConverter;
	TwoWayConverter eventConverter;

	EventService eventService;
	TicketService ticketService;

	private static final String CONVERT_BUY_TICKETS_DTO_ERROR_MESSAGE = "Failed to convert BuyTicketsDTO to List<Ticlet>";
	private static final String CONVERT_EVENT_ERROR_MESSAGE = "Failed to convert Event in EventDTO";
	private static final Logger LOGGER = LogManager.getLogger(EventFacadeImpl.class);

	public EventDTO getEventById(Integer eventId) {
		EventDTO eventDTO = null;

		try {
			eventDTO = (EventDTO) eventConverter.convertSourceToTargetClass(eventService.getEventById(eventId),
					EventDTO.class);
		} catch (Exception exception) {
			LOGGER.error(CONVERT_EVENT_ERROR_MESSAGE, exception);
		}

		return eventDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void buyTickets(BuyTicketsDTO buyTicketsDTO) {
		List<Ticket> ticketsList = null;

		try {
			ticketsList = (List<Ticket>) buyTicketsConverter.convertSourceToTargetClass(buyTicketsDTO, List.class);
		} catch (Exception exception) {
			LOGGER.error(CONVERT_BUY_TICKETS_DTO_ERROR_MESSAGE, exception);
		}

		ticketService.buyTickets(ticketsList);
	}

	public void setEventConverter(TwoWayConverter eventConverter) {
		this.eventConverter = eventConverter;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setBuyTicketsConverter(TwoWayConverter buyTicketsConverter) {
		this.buyTicketsConverter = buyTicketsConverter;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

}
