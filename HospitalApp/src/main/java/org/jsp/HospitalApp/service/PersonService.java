package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.PersonDao;
import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	PersonDao personDao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		structure.setBody(personDao.savePerson(person));
		structure.setMessage("Person saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		structure.setBody(personDao.updatePerson(person));
		structure.setMessage("Person update successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deletePerson(int id) {
		Optional<Person> recPerson = personDao.getPerson(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recPerson.isPresent()) {
			personDao.deletePerson(id);
			structure.setBody("Person found");
			structure.setMessage("Person found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Person>> getPerson(int id) {
		Optional<Person> recPerson = personDao.getPerson(id);
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		if (recPerson.isPresent()) {
			structure.setBody(recPerson.get());
			structure.setMessage("Person found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Person>>> getAll() {
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		structure.setBody(personDao.getAll());
		structure.setMessage("List of Person ");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
	}

}
