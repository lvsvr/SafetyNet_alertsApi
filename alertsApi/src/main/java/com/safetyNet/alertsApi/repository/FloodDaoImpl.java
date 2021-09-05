package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.model.PersonForEmergencyCase;

@Repository
public class FloodDaoImpl implements FloodDAO{
	private FirestationDaoImpl firestationDatatAccessService;
	private HomeDaoImpl homeDataAccessService;
	
	public FloodDaoImpl(FirestationDaoImpl firestationDatatAccessService,
			HomeDaoImpl homeDataAccessService) {
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
