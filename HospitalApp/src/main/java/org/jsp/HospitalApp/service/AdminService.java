package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.AdminDao;
import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(adminDao.saveAdmin(admin));
		structure.setMessage("Admin Saved Succesfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(adminDao.updateAdmin(admin));
		structure.setMessage("Admin Updated Succesfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAdmin(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		Optional<Admin> op = adminDao.getAdmin(id);
		if (op.isPresent()) {
			adminDao.deleteAdmin(id);
			structure.setBody("Admin Found");
			structure.setMessage("Admin found and deleted succesfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdmin(int id) {
		Optional<Admin> op = adminDao.getAdmin(id);
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		if (op.isPresent()) {
			structure.setBody(op.get());
			structure.setMessage("Admin found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Admin>>> getAll() {
		ResponseStructure<List<Admin>> structure = new ResponseStructure<List<Admin>>();
		structure.setBody(adminDao.getAll());
		structure.setMessage("List of Admin");
		structure.setCode(HttpStatus.FOUND.value());
		;
		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.FOUND);
	}

}
