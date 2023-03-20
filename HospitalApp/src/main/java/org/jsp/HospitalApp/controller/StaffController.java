package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.dto.Staff;
import org.jsp.HospitalApp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
	@Autowired
	StaffService staffService;

	@PostMapping("/staff/{bid}")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff, @PathVariable int bid) {
		return staffService.saveStaff(staff, bid);
	}

	@PutMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff) {
		return staffService.updateStaff(staff);
	}

	@DeleteMapping("/staff/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteStaff(@PathVariable int id) {

		return staffService.deleteStaff(id);
	}

	@GetMapping("/staff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getStaff(@PathVariable int id) {
		return staffService.getStaff(id);
	}

	@GetMapping("/staff/all")
	public ResponseEntity<ResponseStructure<List<Staff>>> getAll() {
		return staffService.getAll();
	}
}