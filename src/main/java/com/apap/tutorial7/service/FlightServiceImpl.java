package com.apap.tutorial7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;

	@Override
	public FlightModel addFlight(FlightModel flight) {
		return flightDb.save(flight);
	}

	@Override
	public void deleteFlightById(long id) {
		flightDb.deleteById(id);
	}

	/**
	 * @Override public void updateFlight(Long id, String flightNumber, String
	 *           origin, String destination, Date time) {
	 *           flightDb.getOne(id).setFlightNumber(flightNumber);
	 *           flightDb.getOne(id).setOrigin(origin);
	 *           flightDb.getOne(id).setDestination(destination);
	 *           flightDb.getOne(id).setTime(time);
	 * 
	 *           }
	 */

	@Override
	public FlightModel getFlightDetailById(long id) {
		return flightDb.getOne(id);

	}

	@Override
	public List<FlightModel> allFlight() {
		return flightDb.findAll();

	}

	@Override
	public void updateFlight(long id, FlightModel flight) {
		FlightModel updatedFlight = flightDb.findById(id).get();
		updatedFlight.setDestination(flight.getDestination());
		updatedFlight.setOrigin(flight.getOrigin());
		updatedFlight.setTime(flight.getTime());
		flightDb.save(updatedFlight);

	}

	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	@Override
	public void deleteFlight(FlightModel flight) {
		flightDb.delete(flight);
	}

	@Override
	public List<FlightModel> getAllFlight() {
		return flightDb.findAll();
	}

}
