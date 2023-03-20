package org.jsp.HospitalApp.dao;

import java.util.List;

import java.util.Optional;

import org.jsp.HospitalApp.dto.Encounter;
import org.jsp.HospitalApp.repository.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EncounterDao {
	@Autowired
	EncounterRepository repository;

	public Encounter saveEncounter(Encounter encounter) {
		return repository.save(encounter);
	}

	public Encounter updateEncounter(Encounter encounter) {
		return repository.save(encounter);
	}

	public void deleteEncounter(int id) {
		repository.deleteById(id);

	}

	public Optional<Encounter> getEncounter(int id) {
		return repository.findById(id);
	}

	public List<Encounter> getAll() {
		return repository.findAll();
	}
}
