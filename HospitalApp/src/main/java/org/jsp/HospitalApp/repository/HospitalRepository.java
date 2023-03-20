package org.jsp.HospitalApp.repository;

import org.jsp.HospitalApp.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
