package it.krkn.services.department.repository;


import it.krkn.services.department.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findByOrganizationId(Long organizationId);

}
