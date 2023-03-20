package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.AddressDao;
import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		structure.setBody(addressDao.saveAddress(address));
		structure.setMessage("Address Saved Succesfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		structure.setBody(addressDao.updateAddress(address));
		structure.setMessage("Address Updated Succesfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAddress(int id) {
		Optional<Address> op = addressDao.getAddress(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (op.isPresent()) {
			addressDao.deleteAddress(id);
			structure.setBody("Address Found");
			structure.setMessage("Address found and deleted succesfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Address>> getAddress(int id) {
		Optional<Address> op = addressDao.getAddress(id);
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		if (op.isPresent()) {
			structure.setBody(op.get());
			structure.setMessage("Address found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Address>>> getAll() {
		ResponseStructure<List<Address>> structure = new ResponseStructure<List<Address>>();
		structure.setBody(addressDao.getAll());
		structure.setMessage("List of Address");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Address>>>(structure, HttpStatus.FOUND);
	}

}
