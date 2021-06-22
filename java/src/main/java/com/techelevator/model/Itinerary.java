package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;

public class Itinerary 
{
	
	private long itineraryId;
	private long userId;
	private String name;
	private Date itineraryDate;

	

//	
//	public Itinerary(int itineraryId, int userId, String name, Date itineraryDate)
//	{
//			this.itineraryId = itineraryId;
//			this.userId = userId;
//			this.name = name;
//			this.itineraryDate = itineraryDate;
//	}
	
	public long getItineraryId()
	{
		return itineraryId;
	}
	
	public long getUserId()
	{
		return userId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Date getItineraryDate()
	{
		return itineraryDate;
	}
	
	public long setItineraryId(long itineraryId)
	{
		return this.itineraryId = itineraryId;
	}
	
	public long setUserId(long userId)
	{
		return this.userId = userId;
	}
	
	public String setname(String name)
	{
		return this.name = name;
	}
	
	public Date setItineraryDate(Date itineraryDate)
	{
		return this.itineraryDate = itineraryDate;
	}
	

}
