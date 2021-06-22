package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Location;

@Component
public class LocationSqlDAO implements LocationDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Location> list()
	{
		List<Location> locations = new ArrayList<>();
		String sql = "SELECT * from locations;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			Location location = new Location();
			
			String locationId = results.getString("location_id");
			String locationName = results.getString("name");
			float latitude = results.getFloat("latitude");
			float longitude = results.getFloat("longitude");
			long itineraryId = results.getLong("itinerary_id");
			String address = results.getString("address");
			int locationOrder = results.getInt("location_order");
			
			
			location.setLocationId(locationId);
			location.setName(locationName);
			location.setLatitude(latitude);
			location.setLongitude(longitude);
			location.setItineraryId(itineraryId);
			location.setAddress(address);
			location.setLocation_order(locationOrder);
			
			locations.add(location);
			
		}
		
		return locations;
	}

	
	@Override
	public List<Location> listByUser(long userId)
	{
		List<Location> locations = new ArrayList<>();
		String sql = "SELECT l.* from locations AS l"
				+ " INNER JOIN itinerary AS i ON l.itinerary_id = i.itinerary_id"
				+ " WHERE i.user_id = ?"
				+ " ORDER BY l.itinerary_id, l.location_order;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		
		while(results.next()) {
			Location location = new Location();
			
			String locationId = results.getString("location_id");
			String locationName = results.getString("name");
			float latitude = results.getFloat("latitude");
			float longitude = results.getFloat("longitude");
			long itineraryId = results.getLong("itinerary_id");
			String address = results.getString("address");
			int locationOrder = results.getInt("location_order");
			
			
			location.setLocationId(locationId);
			location.setName(locationName);
			location.setLatitude(latitude);
			location.setLongitude(longitude);
			location.setItineraryId(itineraryId);
			location.setAddress(address);
			location.setLocation_order(locationOrder);
			
			locations.add(location);
			
		}
		
		return locations;
	}

	public void createLocation(Location location)
	{
		String sql = "INSERT INTO locations " +
					 "(location_id, name, latitude, longitude, itinerary_id, address, location_order)" +
					 "VALUES(?, ?, ?, ?, ?, ?, ?);";
		int locationOrder = getNextSortOrder(location.getItineraryId());
		
		jdbcTemplate.update(sql,
							location.getLocationId(),
							location.getName(),
							location.getLatitude(),
							location.getLongitude(),
							location.getItineraryId(),
							location.getAddress(),
							locationOrder);

	}
	
	private int getNextSortOrder (long itineraryId)
	{
		String sql = "SELECT MAX(location_order) + 1 as location_order " +
						"FROM locations WHERE itinerary_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
		
		if (results.next())
		{
			return results.getInt("location_order");
		}
		return 1;
	}
	
	public void deleteLocation(String locationId)
	{
		String sql = "DELETE FROM locations WHERE location_id = ?;";
		jdbcTemplate.update(sql, locationId);
	}
	
	
	public List<Location> get(long id)
	{
		List <Location> locations = new ArrayList<>();
		String sql = "SELECT * FROM locations WHERE itinerary_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		while(results.next()) {
			
			Location location = new Location();
			String locationId = results.getString("location_id");
			String locationName = results.getString("name");
			float latitude = results.getFloat("latitude");
			float longitude = results.getFloat("longitude");
			long itineraryId = results.getLong("itinerary_id");
			String address = results.getString("address");
			int locationOrder = results.getInt("location_order");
			
			
			location.setLocationId(locationId);
			location.setName(locationName);
			location.setLatitude(latitude);
			location.setLongitude(longitude);
			location.setItineraryId(itineraryId);
			location.setAddress(address);
			location.setLocation_order(locationOrder);
			locations.add(location);
			
		}
		
		return locations;
	}
	
		public void updateLocation(String id, Location location)
		{
			String sql = "UPDATE locations SET " +
						 "name = ?, latitude = ?, longitude = ?, itinerary_id = ?, address = ?, location_order = ?;";
			
			jdbcTemplate.update(sql,
								location.getName(),
								location.getLatitude(),
								location.getLongitude(),
								location.getItineraryId(),
								location.getAddress(),
								location.getLocation_order());
		}
}
