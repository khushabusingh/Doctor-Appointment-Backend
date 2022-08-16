package com.example.Registrationform.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="doctorregister" )
public class Doctor {
	@Id
	@Column(name = "docid", scale = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "pid_seq")
	private Long docid;
	
	@Column(name = "name", length = 30)
	private String name;
	
	@Column(name = "password", length = 200)
	private String password;
	
	@Column(name = "phone", length = 10)
	private String  phone;
	
	@Column(name = "address", length = 100)
	private String address;
		
	@Column(name = "special" ,length= 50)
	private String special;

	@Column(name = "qualify" ,length= 50)
	private String qualify;
	 
	@Column(name = "email", length = 50, unique=true)
	private String email;
	
	@OneToMany(mappedBy="doctor")
    @JsonIgnoreProperties("doctor")
	private Collection<Appointment> appointments;
	
	
	public Long getDocid() {
		return docid;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getQualify() {
		return qualify;
	}

	public void setQualify(String qualify) {
		this.qualify = qualify;
	}

	public void setDocid(Long docid) {
		this.docid = docid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(Long docid, String name, String password, String phone, String address, String special, String qualify,
			String email) {
		super();
		this.docid = docid;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.special = special;
		this.qualify = qualify;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + docid + ", name=" + name + ", password=" + password + ", phone=" + phone + ", address="
				+ address + ", special=" + special + ", qualify=" + qualify + ", email=" + email + "]";
	}

	


   
     
}
