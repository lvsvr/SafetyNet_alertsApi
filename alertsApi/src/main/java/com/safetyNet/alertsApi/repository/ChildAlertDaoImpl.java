package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.AgeCalculator;
import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;

@Repository
public class ChildAlertDaoImpl implements ChildAlertDAO{
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private HomeDaoImpl homeDao;
	
	public ChildAlertDaoImpl(FirestationDaoImpl firestationDao, PersonDaoImpl personDao,
			MedicalRecordDaoImpl medicalRecordDao, HomeDaoImpl homeDao) {
		super();
		this.homeDao = homeDao;
	}

	@Override
	public Home getHomeByAddress(String address) {
		ArrayList<Home> homes = homeDao.getHomeList();
		Home namedHome = new Home();
		for(Home home: homes) {
			if(home.getAddress().equals(address)) {
				namedHome = home;
			}
		}
			return namedHome;
	}

	@Override
	public ArrayList<MedicalRecord> getMedicalRecordsByHome(Home home) {
		ArrayList<MedicalRecord>medicalRecordsList =new ArrayList<MedicalRecord>();
			for(MedicalRecord medicalRecord : home.getMedicalRecords()) {
			 medicalRecordsList.add(medicalRecord);
			}
		return medicalRecordsList;
	}

	@Override
	public ArrayList<String> getChildListFromMedicalRecordList(ArrayList<MedicalRecord> medicalRecords) {
		ArrayList<String> childList = new ArrayList<String>();
		ArrayList<String> adultList = new ArrayList<String>();
		
		for(MedicalRecord medicalRecord : medicalRecords) {
			AgeCalculator ac = new AgeCalculator();
			if(ac.calculateAge(medicalRecord.getBirthDate())<=18) {
				childList.add("firstName: "+ medicalRecord.getFirstName()+"; lastName: "+medicalRecord.getLastName()+"; age: "+ac.calculateAge(medicalRecord.getBirthDate()));
			}
			else {
				adultList.add(("ADULT - firstName: "+ medicalRecord.getFirstName()+"; lastName: "+medicalRecord.getLastName()));
			}
		}
		if(childList != null) {
			for(String adult : adultList) {
				childList.add(adult);
			}
		}
		return childList;
	}

	@Override
	public ArrayList<String> getChildListByAddress(String address) {
		Home home = getHomeByAddress(address);
		ArrayList<MedicalRecord>medicalRecords = getMedicalRecordsByHome(home);
		ArrayList<String>childList = getChildListFromMedicalRecordList(medicalRecords);
		return childList;
	}
}	
