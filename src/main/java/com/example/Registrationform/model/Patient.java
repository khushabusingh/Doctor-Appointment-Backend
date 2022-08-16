package com.example.Registrationform.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="patientregister" )

public class Patient {
	@Id
	@Column(name = "pid", scale = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "pid_seq")
	private Long pid;
	
	@Column(name = "fname", length = 30)
	private String fname;
	
	@Column(name = "lname", length = 30)
	private String lname;
	
	@Column(name = "password", length = 200)
	private String password;
	
	@Column(name = "phone", length = 10)
	private String  phone;
	
	@Column(name = "address", length = 100)
	private String address;
	
	@Column(name = "gender" ,length= 6)
	private String gender;
	
	@Column(name = "dateofbirth")
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	
	@Column(name = "email", length = 50, unique= true)
	private String email;
	
	
	
	
	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@OneToMany(mappedBy="patient")
    @JsonIgnoreProperties("patient")
	private Collection<Appointment> appointments;
	

	public Collection<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Collection<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Patient() {
		super();
		
	}

	public Patient(Long pid, String fname,String lname,Date dateofbirth, String password, String phone, String address, float age, String gender,
			String email
//			,Collection<Role> roles
			) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.dateofbirth=dateofbirth;
		this.gender = gender;

		this.email = email;
//		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + pid + ", fullname=" + fname+ ", lastname=" + lname  + ", password=" + password + ", phone=" + phone + ", address="
				+ address + ", gender=" + gender 
				+ ", email=" + email + "]";
	}
	 
   
//	
//	public void setDateOfManufacture(String dateOfManufacture) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			this.date = sdf.parse(dateOfManufacture);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
 
	
	

