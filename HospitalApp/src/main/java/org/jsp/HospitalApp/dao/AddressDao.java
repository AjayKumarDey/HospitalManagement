package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {
	@Autowired
	AddressRepository repository;

	public Address saveAddress(Address address) {
		return repository.save(address);

	}

	public Address updateAddress(Address address) {
		return repository.save(address);

	}

	public void deleteAddress(int id) {
		repository.deleteById(id);
	}

	public Optional<Address> getAddress(int id) {
		return repository.findById(id);

	}

	public List<Address> getAll() {
		return repository.findAll();

	}

}
