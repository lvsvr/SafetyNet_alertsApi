package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.PersonForEmergencyCase;

@Repository("floodDao")
public class FloodDataAccessService implements FloodDAO{
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	
	private FirestationDataAccessService firestationDatatAccessService;
	private HomeDataAccessService homeDataAccessService;
	
	public FloodDataAccessService(FirestationDataAccessService firestationDatatAccessService,
			HomeDataAccessService homeDataAccessService) {
		super();
		this.firestationDatatAccessService = firestationDatatAccessService;
		this.homeDataAccessService = homeDataAccessService;
	}


	@Override
	public ArrayList<PersonForEmergencyCase> getPersonsListByFirestationNumberList(ArrayList<String> firestationNumber) {
		ArrayList<String> addressListByFirestation = firestationDatatAccessService.getAddressListByFirestationList(firestationNumber);
		return homeDataAccessService.getPersonsListByAddressList(addressListByFirestation);
	}
}
