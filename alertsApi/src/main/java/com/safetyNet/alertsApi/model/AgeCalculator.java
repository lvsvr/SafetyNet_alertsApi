package com.safetyNet.alertsApi.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class AgeCalculator {

	public AgeCalculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int calculateAge(String birthdate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate bDate = LocalDate.parse(birthdate, formatter);
		String currentDate = formatter.format(java.time.LocalDate.now());
		LocalDate cDate = LocalDate.parse(currentDate, formatter);
		if (bDate != null) {
			return Period.between(bDate, cDate).getYears();
		}
		return 0;
	}

}
