package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;

public interface ChildAlertDAO {

	Home getHomeByAddress(String address);
	ArrayList<MedicalRecord> getMedicalRecordsByHome(Home home);
	ArrayList<String> getChildListFromMedicalRecordList(ArrayList<MedicalRecord>medicalRecords);
	ArrayList<String> getChildListByAddress(String address);
}
