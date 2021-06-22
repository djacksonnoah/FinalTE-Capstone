package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Location;

public interface LocationDAO {

	List<Location> list();
	
	List<Location> listByUser(long userId);
	
	List<Location> get(long itineraryId);
	
	void createLocation(Location locationToSave);
	
	void updateLocation(String locationId, Location location);
	
	void deleteLocation(String locationId);
	

}
