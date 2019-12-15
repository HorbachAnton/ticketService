package by.sam.horbach.ticketService.dto;

import java.nio.file.Path;
import java.time.LocalDateTime;

public class EventDTO {

	private int id;
	private String title;
	private String summary;
	private LocalDateTime date;
	private LocationDTO location;
	private int price;
	private Path iconPath;

	public EventDTO() {

	}

	public EventDTO(int id, String title, String summary, LocalDateTime date, LocationDTO location, int price,
			Path iconPath) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.date = date;
		this.location = location;
		this.price = price;
		this.iconPath = iconPath;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Path getIconPath() {
		return iconPath;
	}

	public void setIconPath(Path iconPath) {
		this.iconPath = iconPath;
	}

}
