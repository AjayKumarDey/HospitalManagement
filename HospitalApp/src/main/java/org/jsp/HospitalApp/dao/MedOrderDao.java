package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.MedOrder;
import org.jsp.HospitalApp.repository.MedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedOrderDao {
	@Autowired
	MedOrderRepository repository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
	}

	public MedOrder updateMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
	}

	public void deleteMedOrder(int id) {
		repository.deleteById(id);
	}

	public Optional<MedOrder> getMedOrder(int id) {
		return repository.findById(id);
	}

	public List<MedOrder> getAll() {
		return repository.findAll();
	}

}
