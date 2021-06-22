package com.techelevator.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import com.techelevator.model.Itinerary;

@Component
public class ItinerarySqlDAO implements ItineraryDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Itinerary> getItineraries(int userId)
	{
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		
		String sql = "SELECT * " +
					 "FROM itinerary " +
					 "WHERE user_id = ?";
		
		SqlRowSet  rows = jdbcTemplate.queryForRowSet(sql, userId);
		
		while(rows.next())
			
		{
			Itinerary itinerary = new Itinerary();
			int itineraryId = rows.getInt("itinerary_id");
			int userID = rows.getInt("user_id");
			String name = rows.getString("name");
			Date itineraryDate = rows.getDate("itinerary_date");
			
			itinerary.setItineraryId(itineraryId);
			itinerary.setUserId(userID);
			itinerary.setname(name);
			itinerary.setItineraryDate(itineraryDate);
			
			itineraries.add(itinerary);
			
		}
			return itineraries;
	}
	
	public void createItinerary(Itinerary itinerary)
	{
			String sql = "INSERT INTO itinerary (itinerary_id, user_id, name, itinerary_date) " +
						 "VALUES(DEFAULT, ?, ?, ?);";
			jdbcTemplate.update(sql, 
								itinerary.getUserId(),
								itinerary.getName(), 
								itinerary.getItineraryDate());			 
	}	
	
	public void deleteItinerary(long itineraryId)
	{
			String deleteLocationSql = "DELETE FROM locations WHERE itinerary_id = ?;";
		
		
			String deleteItinerarySql = "DELETE FROM itinerary " +
						 "WHERE itinerary_id = ?";
			jdbcTemplate.update(deleteLocationSql, itineraryId);
			jdbcTemplate.update(deleteItinerarySql, itineraryId);			 
	}
	
	public void updateItinerary(long itineraryId, Itinerary changedItinerary)
	{
			String sql = "UPDATE itinerary " +
						  "SET name = ?, itinerary_date = ? " +
						 "WHERE itinerary_id = ?";
			
			jdbcTemplate.update(sql, changedItinerary.getName(), changedItinerary.getItineraryDate(), itineraryId);
						 
	}


}
