package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.service.MedicalRecordService;

@RequestMapping("/medicalRecord")
@RestController
public class MedicalRecordController {

	private final MedicalRecordService medicalRecordService;

	@Autowired
	public MedicalRecordController(MedicalRecordService medicalRecordService) {
		super();
		this.medicalRecordService = medicalRecordService;
	}

	@GetMapping
	public ArrayList<MedicalRecord> getAllMedicalRecords() {
		return medicalRecordService.getAllMedicalRecords();
	}

	@PostMapping
	public void insertMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		medicalRecordService.insertMedicalRecord(medicalRecord);
	}

	@GetMapping(path = "{firstName}/{lastName}")
	public Optional<MedicalRecord> getMedicalRecordByNames(@PathVariable String firstName,
			@PathVariable String lastName) {
		return medicalRecordService.getMedicalRecordByNames(firstName, lastName);
	}

	@DeleteMapping(path = "{firstName}/{lastName}")
	public void deleteMedicalRecordByNames(@PathVariable String firstName, @PathVariable String lastName) {
		medicalRecordService.deleteMedicalRecordByNames(firstName, lastName);
	}

	@PutMapping(path = "{firstName}/{lastName}")
	public void updateMedicalRecordByNames(@PathVariable String firstName, @PathVariable String lastName,
			@RequestBody MedicalRecord medicalRecord) {
		medicalRecordService.updateMedicalRecordByNames(firstName, lastName, medicalRecord);
	}
}
