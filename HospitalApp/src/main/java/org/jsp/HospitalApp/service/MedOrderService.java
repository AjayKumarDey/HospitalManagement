package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.EncounterDao;
import org.jsp.HospitalApp.dao.MedOrderDao;
import org.jsp.HospitalApp.dto.Encounter;
import org.jsp.HospitalApp.dto.Hospital;
import org.jsp.HospitalApp.dto.MedOrder;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedOrderService {
	@Autowired

	MedOrderDao dao;
	@Autowired
	EncounterDao encounterDao;

	MedOrderDao medOrderDao;


	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid) {
		Optional<Encounter> encounter = encounterDao.getEncounter(eid);
		ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
		structure.setBody(medOrderDao.saveMedOrder(medOrder));
		structure.setMessage("medOrder saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		if (encounter.isPresent()) {
			medOrder.setEncounter(encounter.get());
			encounter.get().getMedOrders().add(medOrder);
			structure.setBody(dao.saveMedOrder(medOrder));
			structure.setMessage("Saved Successfully");
			structure.setCode(HttpStatus.ACCEPTED.value());
		} else {
			throw new IdNotFoundException();
		}
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
		structure.setBody(medOrderDao.updateMedOrder(medOrder));
		structure.setMessage("MedOrder update successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		Optional<MedOrder> recMedOrder = medOrderDao.getMedOrder(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recMedOrder.isPresent()) {
			medOrderDao.deleteMedOrder(id);
			structure.setBody("MedOrder found");
			structure.setMessage("MedOrder found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(int id) {
		Optional<MedOrder> recMedOrder = medOrderDao.getMedOrder(id);
		ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
		if (recMedOrder.isPresent()) {
			structure.setBody(recMedOrder.get());
			structure.setMessage("MedOrder found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAll() {
		ResponseStructure<List<MedOrder>> structure = new ResponseStructure<List<MedOrder>>();
		structure.setBody(medOrderDao.getAll());
		structure.setMessage("List of MedOrder ");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<MedOrder>>>(structure, HttpStatus.FOUND);
	}

}
