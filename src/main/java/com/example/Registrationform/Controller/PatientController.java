package com.example.Registrationform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registrationform.model.Patient;
import com.example.Registrationform.repo.PatientRepo;
import com.example.Registrationform.service.PatientService;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins ="http://localhost:4200")
public class PatientController {
	
	@Autowired
	private PatientService service;
	@Autowired
	private PatientRepo repo;
	
	 //method for registering(registration)patient into database
     @PostMapping("/register")
	 public Patient addPatient(@RequestBody Patient patient) throws Exception {
		System.out.println("controller is called ");
		String temEmailId = patient.getEmail();
		if(temEmailId != null && "".equals(temEmailId)) {
			Patient patientobj=	service.fetchPatientEmail(temEmailId);
			if(patientobj != null) {
				throw new Exception ("Patient with "+temEmailId+"is already present");
			}
		}
		Patient patientobj= null;
		patientobj = service.savePatient(patient);
    	 return patientobj;
	}
     
     
     //method for login patient
     @PostMapping("/login")
     public Patient loginPatient(@RequestBody Patient patient) throws Exception {
    	 String temEmailId = patient.getEmail();
    	 String temPass= patient.getPassword();
    	 System.out.println("email"+patient.getEmail());
    	 System.out.println("password"+patient.getPassword());
    	 Patient patientobj = null;
    	 if(temEmailId != null && temPass != null) {
    		 patientobj= service.fetchPatientEmailAndPassword(temEmailId, temPass);
    	 }
    	 if(patientobj== null) {
    		 throw new Exception("Bad credentials");
    	 }
    	 return patientobj;
     }
       
   //method for getting details of  patient
    @GetMapping("/getPatient")
  public List<Patient> getAllPatient(){
  	 return service.getAllPatient();
   }
       
    
  //method for getting details of patient through id
    @GetMapping("/register/{pid}")
    public Patient getPatientById(@PathVariable("pid") Long pid) {
    	return repo.findById(pid).get();
    }
    
  //method for delete patient by id
    @DeleteMapping("/deletePatient/{pid}")
    public void deletePatient(@PathVariable("pid") Long pid) {
    	service.deletePatient(pid);
    }
}
