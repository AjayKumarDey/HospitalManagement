package org.jsp.HospitalApp.repository;

import org.jsp.HospitalApp.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
