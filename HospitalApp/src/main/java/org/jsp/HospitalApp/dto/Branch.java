package org.jsp.HospitalApp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, email;
	private long phone;
	@ManyToOne
	private Hospital hospital;
	@OneToOne
	private Address address;
	@OneToMany
	private List<Encounter> encounters;
	@OneToMany
	private List<Admin> admin;
	@OneToMany
	private List<Staff> staffs;
	
	@JsonIgnore
	public Hospital getHospital1() {
		return hospital;
	}

}
