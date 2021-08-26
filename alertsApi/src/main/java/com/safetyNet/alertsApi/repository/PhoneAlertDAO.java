package com.safetyNet.alertsApi.repository;

import java.util.Set;

public interface PhoneAlertDAO {

	Set<String> getPhonesByFirestationNumbers(String firestationNumber);

}
