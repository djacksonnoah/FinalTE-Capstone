package com.techelevator.model;

public class Location {
	
	private String locationId;
	private String name;
	private float latitude;
	private float longitude;
	private long itineraryId;
	private String address;
	private int location_order;
	
	
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public long getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(long itineraryId) {
		this.itineraryId = itineraryId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLocation_order() {
		return location_order;
	}
	public void setLocation_order(int location_order) {
		this.location_order = location_order;
	}
	
	
	

}
