package com.safetyNet.alertsApi.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.CommunityEmailDAO;

@Service
public class CommunityEmailService {
	
	private final CommunityEmailDAO communityEmailDao;

	@Autowired
	public CommunityEmailService(@Qualifier("CommunityEmailDao")CommunityEmailDAO communityEmailDao) {
		super();
		this.communityEmailDao = communityEmailDao;
	}
	
	public Set<String> getEmailListByCity(String city) {
		return communityEmailDao.getEmailListByCity(city);

	}
}