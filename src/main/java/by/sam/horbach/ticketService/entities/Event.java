package by.sam.horbach.ticketService.entities;

import java.time.LocalDateTime;

public class Event {
	
	private int id;
	private String title;
	private String summary;
	private LocalDateTime date;
	private int idLocation;
	private int price;
	private String iconPath;
	
	public Event() {
		
	}
	
	public Event(int id, String title, String summary, LocalDateTime date, int idLocation, int price, String iconPath) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.date = date;
		this.idLocation = idLocation;
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
	public int getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

}
