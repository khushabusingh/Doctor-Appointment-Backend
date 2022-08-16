package com.example.Registrationform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Registrationform.model.Patient;


@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

	
	public Patient findByEmail(String email);
	
	public Patient findByEmailAndPassword(String email, String password);
}
