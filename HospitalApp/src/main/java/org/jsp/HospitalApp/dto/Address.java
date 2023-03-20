package org.jsp.HospitalApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, place, city, state, country;
	private int pincode;
	@OneToOne
	private Branch branch;

	@JsonIgnore
	public Branch getBranch() {
		return branch;
	}
}
