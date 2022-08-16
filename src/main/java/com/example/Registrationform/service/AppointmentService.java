package com.example.Registrationform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Registrationform.model.Appointment;
import com.example.Registrationform.repo.AppointmentRepo;


@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo repo;

	public AppointmentService(AppointmentRepo repo) {
		this.repo = repo;
	}

	//method for booking appointments 
    public Appointment addAppointments(Appointment appointment) throws Exception {
		
		if(appointment == null) {
			throw new Exception("Appointment object is null in addAppointment method");
		}
		return repo.save(appointment);
	}
	


     //method for getting details of appointment booking
	 public List<Appointment> getAllAppointments() {
		List<Appointment> appointment = new ArrayList<Appointment>();
		Iterable<Appointment> it = repo.findAll();
		it.forEach(appointments -> {
			appointment.add(appointments);
		});
		return appointment; 
	 }


	










//	public Appointment updateAppointment(Appointment appointment) {
//		if(appointment == null) {
//			throw new NullObjectException("Category object is null in updateCategory method");
//		}
//		Optional<Category> opt = dao.findById(category.getCategoryId());
//		Category cat = null;
//		if(opt.isPresent()) {
//			cat = dao.save(category);
//		}
//		else {
//			throw new ResourceNotFoundException("No category with id: "+category.getCategoryId()+" found");
//		}
//		return cat;
//	}
	
	
	
}
