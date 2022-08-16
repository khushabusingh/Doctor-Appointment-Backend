package com.example.Registrationform.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="appointment")
public class Appointment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 	@SequenceGenerator(name = "appid_seq")
	    @Column(name = "appid", scale = 10)
	    private Long appid;
	    
	    @ManyToOne
	    @JoinColumn(name="patientid")
	    @JsonIgnoreProperties("appointments")
	    Patient patient;
	    
	    @ManyToOne
	    @JoinColumn(name="doctorid")
	    @JsonIgnoreProperties("appointments")
	    Doctor doctor;
	    
	    @Column(name = "dateofappointment", length = 30)
	    @Temporal(TemporalType.DATE)
	    private Date dateOfAppointment;
	    
	    @Column(name = "timeofappointment", length = 30)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date timeOfAppointment;

		public Appointment() {
			super();
		}

		public Appointment(Long appid, Patient patient,Doctor doctor, Date dateOfAppointment, Date timeOfAppointment) {
			super();
			this.appid = appid;
			this.patient = patient;
			this.doctor = doctor;
			this.dateOfAppointment = dateOfAppointment;
			this.timeOfAppointment = timeOfAppointment;
		}

		public Long getAppid() {
			return appid;
		}

		public void setAppid(Long appid) {
			this.appid = appid;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}
		
		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}

		public Date getDateOfAppointment() {
			return dateOfAppointment;
		}

		public void setDateOfAppointment(String dateOfAppointment) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				this.dateOfAppointment = sdf.parse(dateOfAppointment);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			this.dateOfAppointment = dateOfAppointment;
		}

		public Date getTimeOfAppointment() {
			return timeOfAppointment;
		}

		public void setTimeOfAppointment(String timeOfAppointment) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			
			try {
				Date appointmentTime = sdf.parse(timeOfAppointment);
				
				long totalMillis = this.dateOfAppointment.getTime() + appointmentTime.getTime();
				
				totalMillis = totalMillis +((1000*60*60*5)+(1000*60*30));
				
				this.timeOfAppointment = new Date(totalMillis);
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			this.timeOfAppointment = timeOfAppointment;
		}

		@Override
		public String toString() {
			return "Appointment [appid=" + appid + ", patient=" + patient + ", doctor=" + doctor + ", dateOfAppointment=" + dateOfAppointment
					+ ", timeOfAppointment=" + timeOfAppointment + "]";
		}
	    
	    
	
	}
