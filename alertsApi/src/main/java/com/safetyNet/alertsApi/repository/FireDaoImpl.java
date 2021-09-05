package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.model.PersonForEmergencyCase;

@Repository
public class FireDaoImpl implements FireDAO {

	private HomeDaoImpl homeDataAccessService;

	public FireDaoImpl(HomeDaoImpl homeDataAccessService) {
		super();
		this.homeDataAccessService = homeDataAccessService;
	}

	@Override
	public ArrayList<PersonForEmergencyCase> getPersonsListByAddress(String address) {
		return homeDataAccessService.getPersonsListByAddress(address);
	}

}
