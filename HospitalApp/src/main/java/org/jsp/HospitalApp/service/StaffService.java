package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.BranchDao;
import org.jsp.HospitalApp.dao.StaffDao;
import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.dto.Staff;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
	@Autowired
	StaffDao staffDao;
	@Autowired
	BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff, int bid) {
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		Optional<Branch> branch = branchDao.getBranch(bid);
		if (branch.isPresent()) {
			structure.setBody(staffDao.saveStaff(staff));
			staff.setBranch(branch.get());
			branch.get().getStaffs().add(staff);

			structure.setMessage("Staff saved successfully");
			structure.setCode(HttpStatus.ACCEPTED.value());

			return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.ACCEPTED);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff) {
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		structure.setBody(staffDao.updateStaff(staff));
		structure.setMessage("Staff update successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteStaff(int id) {
		Optional<Staff> recStaff = staffDao.getStaff(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recStaff.isPresent()) {
			staffDao.deleteStaff(id);
			structure.setBody("Staff found");
			structure.setMessage("Staff found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Staff>> getStaff(int id) {
		Optional<Staff> recStaff = staffDao.getStaff(id);
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		if (recStaff.isPresent()) {
			structure.setBody(recStaff.get());
			structure.setMessage("Staff found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Staff>>> getAll() {
		ResponseStructure<List<Staff>> structure = new ResponseStructure<List<Staff>>();
		structure.setBody(staffDao.getAll());
		structure.setMessage("List of Staff ");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(structure, HttpStatus.FOUND);
	}

}
