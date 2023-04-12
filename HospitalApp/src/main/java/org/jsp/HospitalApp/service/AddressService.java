package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.AddressDao;
import org.jsp.HospitalApp.dao.BranchDao;
import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.dto.Hospital;
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
	@Autowired
	BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address ,int bid) {
		Optional<Branch> branch = branchDao.getBranch(bid);
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		if (branch.isPresent()) {
			address.setBranch(branch.get());
			branch.get().setAddress(address);
			structure.setBody(addressDao.saveAddress(address));
			structure.setMessage("Saved Successfully");
			structure.setCode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.ACCEPTED);
		} else {
			throw new IdNotFoundException();
		}

		
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
