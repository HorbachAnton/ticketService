package by.sam.horbach.ticketService.entities;

public class Location {

	private int id;
	private String title;

	public Location() {

	}

	public Location(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
