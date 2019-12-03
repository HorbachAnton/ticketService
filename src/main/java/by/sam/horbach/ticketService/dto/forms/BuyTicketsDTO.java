package by.sam.horbach.ticketService.dto.forms;

public class BuyTicketsDTO {

	private int idEvent;
	private int quantity;

	public BuyTicketsDTO() {

	}

	public BuyTicketsDTO(int idEvent, int quantity) {
		super();
		this.idEvent = idEvent;
		this.quantity = quantity;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
