package by.sam.horbach.ticketService.dto;

import java.nio.file.Path;
import java.time.LocalDateTime;

import by.sam.horbach.ticketService.entities.Location;

public class EventDTO {

	private int id;
	private String title;
	private String summary;
	private LocalDateTime date;
	private Location location;
	private int price;
	private Path iconPath;

	public EventDTO() {

	}

	public EventDTO(int id, String title, String summary, LocalDateTime date, Location location, int price,
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((iconPath == null) ? 0 : iconPath.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + price;
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventDTO other = (EventDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (iconPath == null) {
			if (other.iconPath != null)
				return false;
		} else if (!iconPath.equals(other.iconPath))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (price != other.price)
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventDTO [id=" + id + ", title=" + title + ", summary=" + summary + ", date=" + date + ", location="
				+ location + ", price=" + price + ", iconPath=" + iconPath + "]";
	}

}
