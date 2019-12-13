package by.sam.horbach.ticketService.dto;

import java.util.List;

public class PaginationEventDTO {

	private List<EventDTO> eventDTOList;
	private int pagesNumber;

	public PaginationEventDTO() {

	}

	public PaginationEventDTO(List<EventDTO> eventDTOList, int pagesNumber) {
		super();
		this.eventDTOList = eventDTOList;
		this.pagesNumber = pagesNumber;
	}

	public List<EventDTO> getEventDTOList() {
		return eventDTOList;
	}

	public void setEventDTOList(List<EventDTO> eventDTOList) {
		this.eventDTOList = eventDTOList;
	}

	public int getPagesNumber() {
		return pagesNumber;
	}

	public void setPagesNumber(int pagesNumber) {
		this.pagesNumber = pagesNumber;
	}

}
