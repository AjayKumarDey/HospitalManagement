package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Hospital;
import org.jsp.HospitalApp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	@Autowired
	HospitalRepository hospitalRepository;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public Hospital updateHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public void deleteHospital(int id) {
		hospitalRepository.deleteById(id);
	}

	public Optional<Hospital> getHospital(int id) {
		return hospitalRepository.findById(id);
	}

	public List<Hospital> getAll() {
		return hospitalRepository.findAll();
	}

}
