package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.HospitalDao;
import org.jsp.HospitalApp.dto.Hospital;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		structure.setBody(hospitalDao.saveHospital(hospital));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();

		structure.setBody(hospitalDao.updateHospital(hospital));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		Optional<Hospital> op = hospitalDao.getHospital(id);
		if (op.isPresent()) {
			hospitalDao.deleteHospital(id);

			structure.setBody("User Present");
			structure.setMessage("Deleted Successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospital(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();

		Optional<Hospital> op = hospitalDao.getHospital(id);
		if (op.isPresent()) {
			structure.setBody(op.get());
			structure.setMessage("Id is present");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Hospital>>> getAll() {
		ResponseStructure<List<Hospital>> structure = new ResponseStructure<List<Hospital>>();
		structure.setBody(hospitalDao.getAll());
		structure.setMessage("Records are fetched");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(structure, HttpStatus.FOUND);
	}
}
