package com.techelevator.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.techelevator.dao.ItineraryDAO;
import com.techelevator.model.Itinerary;

@CrossOrigin
@RestController
@RequestMapping(path="/itineraries/")
public class ItineraryController {

	@Autowired
	ItineraryDAO dao;
	
	
	
	
	@GetMapping("/user/{userId}")
	public List<Itinerary> getItinerary(@PathVariable int userId)
	{
		List<Itinerary> itineraries = dao.getItineraries(userId);
		return itineraries;
	}
	
	@PostMapping("/")
	public void saveItinerary( @RequestBody Itinerary incomingItinerary)
	{
		dao.createItinerary(incomingItinerary);
	}
	

	

	@PutMapping("{id}")
	public void updateItinerary(@RequestBody Itinerary changedItinerary, @PathVariable long id)
	{
		dao.updateItinerary(id, changedItinerary);
	}
	
	@DeleteMapping("{itineraryId}")
	public void deleteItinerary(@PathVariable int itineraryId)
	{
		dao.deleteItinerary(itineraryId);
	}

	
	
}
