package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Staff;
import org.jsp.HospitalApp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StaffDao {
	@Autowired
	StaffRepository repository;

	public Staff saveStaff(Staff staff) {
		return repository.save(staff);

	}

	public Staff updateStaff(Staff staff) {
		return repository.save(staff);

	}

	public void deleteStaff(int id) {
		repository.deleteById(id);
	}

	public Optional<Staff> getStaff(int id) {
		return repository.findById(id);

	}

	public List<Staff> getAll() {
		return repository.findAll();

	}

}
