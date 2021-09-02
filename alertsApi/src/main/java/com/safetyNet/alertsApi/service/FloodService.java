package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.model.PersonForEmergencyCase;
import com.safetyNet.alertsApi.repository.FloodDAO;

@Service
public class FloodService {

	private final FloodDAO floodDao;

	public FloodService(FloodDAO floodDao) {
		super();
		this.floodDao = floodDao;
	}
	
	public ArrayList<PersonForEmergencyCase> getPersonsListByFirestationNumberList(ArrayList<String> firestationNumber){
		return floodDao.getPersonsListByFirestationNumberList(firestationNumber);
	}
	

}
