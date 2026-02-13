package com.vineshotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="room_name")
	private String roomName;
	
	@Column(name="description", length=500)
	private String description;
	
	@Column(name="price_per_night")
	private Double pricePerNight;
	
	@Column(name="max_adults")
	private Integer maxAdults;
	
	@Column(name="max_children")
	private Integer maxChildren;
	
	public Room() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public Integer getMaxAdults() {
		return maxAdults;
	}

	public void setMaxAdults(Integer maxAdults) {
		this.maxAdults = maxAdults;
	}

	public Integer getMaxChildren() {
		return maxChildren;
	}

	public void setMaxChildren(Integer maxChildren) {
		this.maxChildren = maxChildren;
	}
	
	
}
