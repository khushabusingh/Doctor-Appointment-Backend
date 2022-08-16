package com.example.Registrationform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registrationform.model.Appointment;
import com.example.Registrationform.model.Doctor;
import com.example.Registrationform.service.AppointmentService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	
	    //@RequestMapping(value ="/appointment", method = RequestMethod.POST)
	    //method for booking appointments 
		@PostMapping("/{appid}/addappointments")
		public Appointment addAppointments(@PathVariable("appid")   Long appid ,@RequestBody Appointment ap) throws Exception  {
			ap.setDoctor(new Doctor(appid,"","","","","","",""));
			System.out.println(ap.getAppid());
			return service.addAppointments(ap);
		}
	
//		@PostMapping("/categories/{catId}/products")
//		public Product addProduct(@PathVariable("catId") int catId, @RequestBody Product p) {
//			p.setCategory(new Category(catId,"",""));
//			return service.addProduct(p);
//		}
	
	//method for getting details of appointment
	@GetMapping("/getappointments")
	public List<Appointment> getAllAppointments() {
		return service.getAllAppointments();
	}
}
