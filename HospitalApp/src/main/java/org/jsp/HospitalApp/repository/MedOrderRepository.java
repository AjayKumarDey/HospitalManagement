package org.jsp.HospitalApp.repository;
import org.jsp.HospitalApp.dto.MedOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedOrderRepository extends JpaRepository<MedOrder, Integer>{

}
