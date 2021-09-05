package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.model.Person;

@Repository
public class CommunityEmailDaoImpl implements CommunityEmailDAO {
	@Autowired
	private PersonDaoImpl personDataAccessService;

	public CommunityEmailDaoImpl(PersonDaoImpl personDataAccessService) {
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
