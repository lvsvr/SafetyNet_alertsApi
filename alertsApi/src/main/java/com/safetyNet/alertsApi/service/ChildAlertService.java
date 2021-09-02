package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.ChildAlertDAO;

@Service
public class ChildAlertService {

	private final ChildAlertDAO childAlertDao;

	public ChildAlertService(ChildAlertDAO childAlertDao) {
		super();
		this.childAlertDao = childAlertDao;
	}
	public ArrayList<String> getChildListByAddress(String address){
		return childAlertDao.getChildListByAddress(address); 
	}
}
