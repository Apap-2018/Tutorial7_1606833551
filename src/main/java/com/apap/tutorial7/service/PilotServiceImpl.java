package com.apap.tutorial7.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	

	@Override
	public PilotModel addPilot(PilotModel pilot) {
		return pilotDb.save(pilot);
		
	}
	/**
	 * @Override
	public void addPilot(PilotModel pilot) {
		return pilotDb.save(pilot);
		
	}
	 */
	

	@Override
	public void deletePilotById(long id) {
		pilotDb.deleteById(id);
	}

	@Override
	public void updatePilot(long id,PilotModel pilot) {
		PilotModel updatedPilot = pilotDb.findById(id).get();
		updatedPilot.setName(pilot.getName());
		updatedPilot.setFlyHour(pilot.getFlyHour());
		pilotDb.save(updatedPilot);
	}

	@Override
	public PilotModel getPilotDetailById(long id) {
		// TODO Auto-generated method stub
		return pilotDb.getOne(id);
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
		
	}


	
	

}
