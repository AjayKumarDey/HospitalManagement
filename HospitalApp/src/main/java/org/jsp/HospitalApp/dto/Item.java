package org.jsp.HospitalApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, mfdate, exdate, batchno;
	private double price;
	@ManyToOne
	private MedOrder medOrder;

	@JsonIgnore
	public MedOrder getMedOrder() {
		return medOrder;
	}

}
