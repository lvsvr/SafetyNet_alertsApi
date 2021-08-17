package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.FirestationDAO;
import com.safetyNet.alertsApi.model.Firestation;

@Service
public class FirestationService {

	private final FirestationDAO firestationDao;
	
	@Autowired
	public FirestationService(FirestationDAO firestationDao) {
		super();
		this.firestationDao = firestationDao;
	}
	
	public ArrayList<Firestation> getAllFirestations(){
		return firestationDao.getAllFirestations();
	}
	
}
