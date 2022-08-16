package com.example.Registrationform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registrationform.model.Doctor;
import com.example.Registrationform.model.Patient;
import com.example.Registrationform.repo.DoctorRepo;

import com.example.Registrationform.service.DoctorService;


    @RestController
    @RequestMapping("/api/doctor")
    @CrossOrigin(origins ="http://localhost:4200")
    public class DoctorController {

	
	@Autowired
	private DoctorService service;
	@Autowired
	private DoctorRepo repo;
	
	    //method for registration for doctor 
	    @PostMapping("/docregister")
		public Doctor addDoctor(@RequestBody Doctor doctor) throws Exception {
			System.out.println("controller is called ");
			String temEmailId = doctor.getEmail();
			if(temEmailId != null && "".equals(temEmailId)) {
				Doctor doctorobj=	service.fetchDoctorEmail(temEmailId);
				if(doctorobj != null) {
					throw new Exception ("doctor with "+temEmailId+"is already present");
				}
			}
			Doctor doctorobj= null;
			doctorobj = service.saveDoctor(doctor);
	    	 return doctorobj;
		 }
	     
	     
	     //method for login for doctor 
	     @PostMapping("/doclogin")
	     public Doctor loginDoctor(@RequestBody Doctor doctor) throws Exception {
	    	 String temEmailId = doctor.getEmail();
	    	 String temPass= doctor.getPassword();
	    	 Doctor doctorobj = null;
	    	 if(temEmailId != null && temPass != null) {
	    		 doctorobj= service.fetchDoctorEmailAndPassword(temEmailId, temPass);
	    	 }
	    	 if(doctorobj== null) {
	    		 throw new Exception("Bad credentials");
	    	 }
	    	 return doctorobj;
	     }
	     
	    //method for getting details of doctor 
	    @GetMapping("/getDoctor")
	    public List<Doctor> getAllDoctor(){
	  	 return repo.findAll();
	    }
	    
	    
	    //method for getting data by id 
	    @GetMapping("/docregister/{docid}")
	    public Doctor getDoctorById(@PathVariable("docid") Long docid) {
	    	return repo.findById(docid).get();
	    }
	    
	    
	    //method for deleting data by id  
	    @DeleteMapping("/deleteDoctor/{docid}")
	    public void deleteDoctor(@PathVariable("docid") Long docid) {
	    	service.deleteDoctor(docid);
	    }  
	    
}
