package com.apap.tutorial7.service;


import com.apap.tutorial7.model.PilotModel;
public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	PilotModel addPilot(PilotModel pilot);
	PilotModel getPilotDetailById(long id);
	void deletePilotById(long id);
	void deletePilot(PilotModel pilot);
	void updatePilot(long id, PilotModel pilot);

}
