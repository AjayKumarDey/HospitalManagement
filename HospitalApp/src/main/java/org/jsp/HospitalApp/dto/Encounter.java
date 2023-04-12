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
@Data
@Entity
public class Encounter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reason, date;
	@ManyToOne
	private Branch branch;
	@JsonIgnore
	public Branch getBranch() {
		return branch;
	}
	@OneToMany
	private List<Person> persons;
//	@JsonIgnore
//	public List<Person> getPersons() {
//		return persons;
//	}
}
