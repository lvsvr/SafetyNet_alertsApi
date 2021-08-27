package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.model.PersonForEmergencyCase;
import com.safetyNet.alertsApi.repository.FloodDAO;

@Service
public class FloodService {

	@Autowired
	private final FloodDAO floodDao;

	public FloodService(@Qualifier("floodDao")FloodDAO floodDao) {
		super();
		this.floodDao = floodDao;
	}
	
	public ArrayList<PersonForEmergencyCase> getPersonsListByFirestationNumberList(ArrayList<String> firestationNumber){
		return floodDao.getPersonsListByFirestationNumberList(firestationNumber);
	}
	

}
