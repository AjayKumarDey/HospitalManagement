package org.jsp.HospitalApp.controller;

import java.util.List;
import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.PersonService;
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
public class PersonController {
	@Autowired
	PersonService personService;

	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<String>> deletePerson(@PathVariable int id) {
		return personService.deletePerson(id);
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<Person>> getPerson(@PathVariable int id) {
		return personService.getPerson(id);
	}

	@GetMapping("/person/all")
	public ResponseEntity<ResponseStructure<List<Person>>> getAll() {
		return personService.getAll();
	}
}
