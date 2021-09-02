package com.safetyNet.alertsApi.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.CommunityEmailDAO;

@Service
public class CommunityEmailService {
	
	private final CommunityEmailDAO communityEmailDao;

	public CommunityEmailService(CommunityEmailDAO communityEmailDao) {
		super();
		this.communityEmailDao = communityEmailDao;
	}
	
	public Set<String> getEmailListByCity(String city) {
		return communityEmailDao.getEmailListByCity(city);

	}
}