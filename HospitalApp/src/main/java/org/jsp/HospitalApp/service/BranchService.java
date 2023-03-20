package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.BranchDao;
import org.jsp.HospitalApp.dao.HospitalDao;
import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.dto.Hospital;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;
	@Autowired
	HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hid) {
		Optional<Hospital> hospital = hospitalDao.getHospital(hid);
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		if (hospital.isPresent()) {
			branch.setHospital(hospital.get());
			hospital.get().getBranches().add(branch);
			structure.setBody(branchDao.saveBranch(branch));
			structure.setMessage("Saved Successfully");
			structure.setCode(HttpStatus.ACCEPTED.value());
		} else {
			throw new IdNotFoundException();
		}

		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();

		structure.setBody(branchDao.updateBranch(branch));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		Optional<Branch> op = branchDao.getBranch(id);
		if (op.isPresent()) {
			branchDao.deleteBranch(id);

			structure.setBody("User Present");
			structure.setMessage("Deleted Successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranch(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();

		Optional<Branch> op = branchDao.getBranch(id);
		if (op.isPresent()) {
			structure.setBody(op.get());
			structure.setMessage("Id is present");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> getAll() {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		structure.setBody(branchDao.getAll());
		structure.setMessage("Records are fetched");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.FOUND);
	}
}
