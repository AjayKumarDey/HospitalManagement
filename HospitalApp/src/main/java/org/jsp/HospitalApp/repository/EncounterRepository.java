package org.jsp.HospitalApp.repository;

import org.jsp.HospitalApp.dto.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {

}
