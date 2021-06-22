package com.techelevator.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.techelevator.model.Itinerary;

public interface ItineraryDAO {
	
	List<Itinerary> getItineraries(int userId);
	
	void createItinerary(Itinerary itinerary);
	
	void deleteItinerary(long itineraryId);
	
	void updateItinerary(long itineraryId, Itinerary itinerary);	

}
