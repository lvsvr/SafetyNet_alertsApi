package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.ChildAlertDAO;

@Service
public class ChildAlertService {

	private final ChildAlertDAO childAlertDao;

	@Autowired
	public ChildAlertService(@Qualifier("childAlertDao")ChildAlertDAO childAlertDao) {
		super();
		this.childAlertDao = childAlertDao;
	}
	public ArrayList<String> getChildListByAddress(String address){
		return childAlertDao.getChildListByAddress(address); 
	}
}
