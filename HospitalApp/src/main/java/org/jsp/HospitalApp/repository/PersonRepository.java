package org.jsp.HospitalApp.repository;

import org.jsp.HospitalApp.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
