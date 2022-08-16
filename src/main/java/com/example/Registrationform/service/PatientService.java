package com.example.Registrationform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Registrationform.model.Patient;
import com.example.Registrationform.repo.PatientRepo;

@Service
public class PatientService {

	@Autowired
	private PatientRepo repo;
	
//	PasswordEncoder passwordEncoder;
	

	public PatientService(PatientRepo repo) {
		this.repo = repo;
//		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	//method for saving details of patient into database 
	public Patient savePatient( Patient patient) {
//		String encodedPassword = this.passwordEncoder.encode(patient.getPassword());
//		patient.setPassword(encodedPassword);
		return repo.save(patient);
	}
	
	//method for getting data of patient
	public List<Patient> getAllPatient(){
	  	 return repo.findAll();
	   }
	
	
	//method for fetching data of patient by email
	public Patient fetchPatientEmail(String email) {
		return repo.findByEmail(email);
	}
	
	//method for fetching data of patient by email and password when we login
	public Patient fetchPatientEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}

	public void deletePatient(Long pid) {
		repo.deleteById(pid);
		
	}
}
