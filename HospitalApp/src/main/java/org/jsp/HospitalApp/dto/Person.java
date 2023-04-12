package org.jsp.HospitalApp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, email;
	private long phone;
	private int age;
	@ManyToOne
	private Encounter encounter;
	@OneToMany
	private List<MedOrder> medOrders;
	@JsonIgnore
	public Encounter getEncounter() {
		return encounter;
	}
//	@JsonIgnore
//	public List<MedOrder> getMedOrders() {
//		return medOrders;
//	}
		
	
	
	
	
}
