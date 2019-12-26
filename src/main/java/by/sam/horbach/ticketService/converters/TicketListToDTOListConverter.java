package by.sam.horbach.ticketService.converters;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.binding.convert.converters.TwoWayConverter;

import by.sam.horbach.ticketService.dto.TicketDTO;
import by.sam.horbach.ticketService.entities.Ticket;

public class TicketListToDTOListConverter implements TwoWayConverter {

	private static final String CONVERT_TO_DTO_LIST_ERROR_MESSAGE = "Failed to convert List<Ticket> in List<TicketDTO>";
	private static final String CONVERT_TO_LIST_ERROR_MESSAGE = "Failed to convert List<TicketDTO> in List<Ticket>";
	private static final Logger LOGGER = LogManager.getLogger(TicketListToDTOListConverter.class);

	TwoWayConverter ticketToDTOConverter;

	@Override
	public Class<?> getSourceClass() {
		return List.class;
	}

	@Override
	public Class<?> getTargetClass() {
		return List.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object convertSourceToTargetClass(Object source, Class<?> targetClass) throws Exception {
		List<Ticket> ticketList = (List<Ticket>) source;

		List<TicketDTO> ticketDTOList = new ArrayList<>(ticketList.size());

		ticketList.forEach(ticket -> {
			try {
				ticketDTOList.add((TicketDTO) ticketToDTOConverter.convertSourceToTargetClass(ticket, TicketDTO.class));
			} catch (Exception exception) {
				LOGGER.error(CONVERT_TO_DTO_LIST_ERROR_MESSAGE, exception);
			}
		});

		return ticketDTOList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object convertTargetToSourceClass(Object target, Class<?> sourceClass) throws Exception {
		List<TicketDTO> ticketDTOList = (List<TicketDTO>) target;

		List<Ticket> ticketList = new ArrayList<>(ticketDTOList.size());

		ticketDTOList.forEach(ticketDTO -> {
			try {
				ticketList.add((Ticket) ticketToDTOConverter.convertTargetToSourceClass(ticketDTO, Ticket.class));
			} catch (Exception exception) {
				LOGGER.error(CONVERT_TO_LIST_ERROR_MESSAGE, exception);
			}
		});

		return ticketList;
	}

	public void setTicketToDTOConverter(TwoWayConverter ticketToDTOConverter) {
		this.ticketToDTOConverter = ticketToDTOConverter;
	}

}
