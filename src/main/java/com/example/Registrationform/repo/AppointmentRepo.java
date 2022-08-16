package com.example.Registrationform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Registrationform.model.Appointment;


@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

}
