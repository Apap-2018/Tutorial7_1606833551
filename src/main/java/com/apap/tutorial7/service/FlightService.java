package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.FlightModel;

public interface FlightService {
	FlightModel getFlightDetailById(long id);
	
	FlightModel addFlight(FlightModel flight);

	void deleteFlightById(long id);

	//void updateFlight(Long id, String flightNumber, String origin, String destination, Date time);
	
	List<FlightModel> allFlight();
	
	void updateFlight(long id, FlightModel flight);
	
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	
	void deleteFlight(FlightModel flight);
		
	List<FlightModel> getAllFlight();
	    

}
