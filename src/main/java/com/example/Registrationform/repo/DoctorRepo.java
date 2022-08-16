package com.example.Registrationform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Registrationform.model.Doctor;



@Repository
public interface DoctorRepo  extends JpaRepository<Doctor, Long> {
      public Doctor findByEmail(String email);
	
	public Doctor findByEmailAndPassword(String email, String password);
}
