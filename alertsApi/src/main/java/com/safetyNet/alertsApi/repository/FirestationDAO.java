package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.Firestation;

public interface FirestationDAO {

	ArrayList<Firestation> getAllFirestations();
	
	int insertFirestation(Firestation firestation);
}
