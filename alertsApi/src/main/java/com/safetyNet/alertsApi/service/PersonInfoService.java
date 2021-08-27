package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.model.PersonInfo;
import com.safetyNet.alertsApi.repository.PersonInfoDAO;

@Service
public class PersonInfoService {
	
	@Autowired
	private final PersonInfoDAO personInfoDao;
	
	public PersonInfoService(@Qualifier("personInfoDao")PersonInfoDAO personInfoDao) {
		super();
		this.personInfoDao = personInfoDao;
	}
	
	public ArrayList<PersonInfo> getPersonInfoByFirstNameAndLastName(String firstName, String lastName){
		return personInfoDao.getPersonInfoByFirstNameAndLastName(firstName, lastName);
	}
	

}
