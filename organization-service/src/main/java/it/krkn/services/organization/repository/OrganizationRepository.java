package it.krkn.services.organization.repository;

import it.krkn.services.organization.model.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
}
