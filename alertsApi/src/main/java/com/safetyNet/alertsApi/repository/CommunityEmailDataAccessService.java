package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Person;

@Repository("CommunityEmailDao")
public class CommunityEmailDataAccessService implements CommunityEmailDAO {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);

	@Autowired
	private PersonDataAccessService personDataAccessService;

	public CommunityEmailDataAccessService(PersonDataAccessService personDataAccessService) {
		super();
		this.personDataAccessService = personDataAccessService;
	}

	@Override
	public Set<String> getEmailListByCity(String city) {
		ArrayList<Person> persons = personDataAccessService.getAllPersons();
		Set<String> emails = new HashSet<String>();

		for (Person person : persons) {
			if (person.getCity().equals(city)) {
				emails.add(person.getEmail());
			}
		}
		return emails;
	}

}
