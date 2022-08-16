package com.example.Registrationform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Registrationform.model.Doctor;
import com.example.Registrationform.model.Patient;
import com.example.Registrationform.repo.DoctorRepo;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepo repo;
	
//	PasswordEncoder passwordEncoder;
	
	
	public DoctorService(DoctorRepo repo) {
		this.repo = repo;
//		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	
	//method for saving details of doctor
	public Doctor saveDoctor( Doctor doctor) {
//		String encodedPassword = this.passwordEncoder.encode(doctor.getPassword());
//		doctor.setPassword(encodedPassword);
		return repo.save(doctor);
	}
	
	
	   //method for getting details of doctor
	   public List<Doctor> getAllDoctor(){
	  	 return repo.findAll();
	   }
	
	   
	//method for fetching data by email   
	public Doctor fetchDoctorEmail(String email) {
		return repo.findByEmail(email);
	}
	
	//method for fetching data by email  and password 
	public Doctor fetchDoctorEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}
	
	
	//method for deleting data by id  
	public void deleteDoctor(Long docid) {
		repo.deleteById(docid);
		
	}
}
