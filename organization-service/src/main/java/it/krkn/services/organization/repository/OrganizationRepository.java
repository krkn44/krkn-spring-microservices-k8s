package it.krkn.services.organization.repository;

import it.krkn.services.organization.model.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, String> {
	
}
