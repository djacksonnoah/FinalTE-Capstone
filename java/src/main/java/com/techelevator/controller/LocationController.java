package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.LocationDAO;
import com.techelevator.model.Location;

@RestController
@CrossOrigin
@RequestMapping(path = "/locations/")
public class LocationController {
	
	@Autowired
	LocationDAO dao;
	
	

	@GetMapping("")
	public List<Location> getAllLocations()
	{
		return dao.list();
	}
	@GetMapping("/user/{userId}")
	public List<Location> getLocationsByUser(@PathVariable long userId)
	{
		return dao.listByUser(userId);
	}
	
	@GetMapping("{id}")
	public List<Location> getLocationsByItinerary(@PathVariable long id)
	{
		
		
		return dao.get(id);
	}

	@PostMapping()
	public void createNewLocation(@RequestBody Location newLocation)
	{
		dao.createLocation(newLocation);
	}
	
	@DeleteMapping("{locationId}")
	public void deleteLocation(@PathVariable String locationId)
	{
		dao.deleteLocation(locationId);
	}
	
	@PutMapping("{locationId}")
	public void updateLocation(@PathVariable String locationId, @RequestBody Location location)
	{
		dao.updateLocation(locationId, location);
	}
	
}
