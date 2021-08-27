package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.Set;

import com.safetyNet.alertsApi.model.PersonForEmergencyCase;

public interface FloodDAO {
	
	ArrayList<PersonForEmergencyCase> getPersonsListByFirestationNumberList(ArrayList<String> firestationNumber);

}
