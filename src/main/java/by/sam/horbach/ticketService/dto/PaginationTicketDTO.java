package by.sam.horbach.ticketService.dto;

import java.util.List;

public class PaginationTicketDTO {
	private List<TicketDTO> ticketDTOList;
	private int pagesNumber;

	public PaginationTicketDTO() {

	}

	public PaginationTicketDTO(List<TicketDTO> ticketDTOList, int pagesNumber) {
		super();
		this.ticketDTOList = ticketDTOList;
		this.pagesNumber = pagesNumber;
	}

	public List<TicketDTO> getTicketDTOList() {
		return ticketDTOList;
	}

	public void setTicketDTOList(List<TicketDTO> ticketDTOList) {
		this.ticketDTOList = ticketDTOList;
	}

	public int getPagesNumber() {
		return pagesNumber;
	}

	public void setPagesNumber(int pagesNumber) {
		this.pagesNumber = pagesNumber;
	}

}
