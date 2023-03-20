package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository branchRepository;

	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch updateBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public void deleteBranch(int id) {
		branchRepository.deleteById(id);
	}

	public Optional<Branch> getBranch(int id) {
		return branchRepository.findById(id);
	}

	public List<Branch> getAll() {
		return branchRepository.findAll();
	}

}
