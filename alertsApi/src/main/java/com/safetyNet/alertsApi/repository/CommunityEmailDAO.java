package com.safetyNet.alertsApi.repository;

import java.util.Set;

public interface CommunityEmailDAO {
	
	Set<String> getEmailListByCity (String city);

}
