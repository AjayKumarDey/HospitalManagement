package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.BranchService;
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
public class BranchController {
	@Autowired
	private BranchService branchService;

	@PostMapping("/branch/{hid}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @PathVariable int hid) {
		return branchService.saveBranch(branch, hid);
	}

	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch) {
		return branchService.updateBranch(branch);
	}

	@DeleteMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBranch(@PathVariable int id) {
		return branchService.deleteBranch(id);
	}

	@GetMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getBranch(@PathVariable int id) {
		return branchService.getBranch(id);
	}

	@GetMapping("/branch/all")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAll() {
		return branchService.getAll();
	}

}
