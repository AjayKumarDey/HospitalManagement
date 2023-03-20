package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.AddressService;
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
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAddress(@PathVariable int id) {
		return addressService.deleteAddress(id);
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<ResponseStructure<Address>> getAddress(@PathVariable int id) {
		return addressService.getAddress(id);
	}

	@GetMapping("/address/all")

	public ResponseEntity<ResponseStructure<List<Address>>> getAll() {
		return addressService.getAll();
	}
}
