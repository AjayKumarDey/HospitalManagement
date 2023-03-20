package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.EncounterDao;
import org.jsp.HospitalApp.dto.Encounter;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class EncounterService {
	@Autowired
	EncounterDao encounterDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter) {
		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
		structure.setBody(encounterDao.saveEncounter(encounter));
		structure.setMessage("Encounter saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter) {
		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
		structure.setBody(encounterDao.updateEncounter(encounter));
		structure.setMessage("Encounter Updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteEnconter(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		Optional<Encounter> recEncounter = encounterDao.getEncounter(id);
		if (recEncounter.isPresent()) {
			encounterDao.deleteEncounter(id);
			structure.setBody("Encounter found");
			structure.setMessage("Encounter found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			throw new IdNotFoundException();
		}

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(int id) {
		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
		Optional<Encounter> recEncounter = encounterDao.getEncounter(id);
		if (recEncounter.isPresent()) {
			structure.setBody(recEncounter.get());
			structure.setMessage("Encounter found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			throw new IdNotFoundException();
		}
		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Encounter>>> getAll() {
		ResponseStructure<List<Encounter>> structure = new ResponseStructure<List<Encounter>>();
		structure.setBody(encounterDao.getAll());
		structure.setMessage("List of Encounter ");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Encounter>>>(structure, HttpStatus.FOUND);
	}
}
