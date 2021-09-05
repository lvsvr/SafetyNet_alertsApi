package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.JsonReader;

@Repository
public class FirestationDaoImpl implements FirestationDAO {
	private static JsonReader jsonReader = new JsonReader();
	private static ArrayList<Firestation> firestations;

	public FirestationDaoImpl() {
		super();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		firestations = jsonReader.getFirestationsFromJson(dataJsonObject);

	}

	@Override
	public ArrayList<Firestation> getAllFirestations() {
		return firestations;
	}

	@Override
	public int insertFirestation(Firestation firestation) {
		firestations.add(new Firestation(firestation.getAddress(), firestation.getStation()));
		return 1;
	}

	@Override
	public Optional<Firestation> getFirestationByAddress(String address) {
		Firestation namedFirestation = new Firestation();
		for (Firestation firestation : firestations) {
			if (firestation.getAddress().equals(address))
				namedFirestation = firestation;
		}
		return Optional.of(namedFirestation);
	}

	@Override
	public int updateFirestationByAddress(String address, Firestation updatedFirestation) {
		Optional<Firestation> firestationToUpdate = getFirestationByAddress(address);
		if (firestationToUpdate == null) {
			return 0;
		}
		ArrayList<Firestation> firestationsMemo = new ArrayList<Firestation>();
		for (Firestation firestation : firestations) {
			if (!firestation.getAddress().equals(address)) {
				firestationsMemo.add(firestation);
			} else if (firestation.getAddress().equals(address)) {
				firestationsMemo.add(updatedFirestation);
			}
		}
		firestations = firestationsMemo;
		return 1;
	}

	@Override
	public int deleteFirestationByAddress(String address) {
		Optional<Firestation> firestationToDelete = getFirestationByAddress(address);
		if (firestationToDelete == null) {
			return 0;
		}
		ArrayList<Firestation> firestationsMemo = new ArrayList<Firestation>();
		for (Firestation firestation : firestations) {
			if (!(firestation.getAddress().equals(address)))
				firestationsMemo.add(firestation);
		}
		firestations = firestationsMemo;
		return 1;
	}

	@Override
	public Set<String> getAddressListByFirestation(String firestationNumber) {
		ArrayList<Firestation> firestations = getAllFirestations();
		Set<String> addressList = new HashSet<String>();
		for (Firestation firestation : firestations) {
			if (firestation.getStation().equals(firestationNumber)) {
				addressList.add(firestation.getAddress());
			}
		}
		return addressList;
	}

	@Override
	public ArrayList<String> getAddressListByFirestationList(ArrayList<String> firestationsNumbers) {
		ArrayList<String> addressAListByFirestation = new ArrayList<String>();
		for (String firestationNumber : firestationsNumbers) {
			for (Firestation firestation : getAllFirestations()) {
				if (firestation.getStation().equals(firestationNumber)) {
					addressAListByFirestation.add(firestation.getAddress());
				}
			}
		}
		return addressAListByFirestation;
	}
}