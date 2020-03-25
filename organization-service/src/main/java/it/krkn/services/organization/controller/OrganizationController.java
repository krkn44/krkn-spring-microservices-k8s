package it.krkn.services.organization.controller;

import it.krkn.services.organization.client.DepartmentClient;
import it.krkn.services.organization.client.EmployeeClient;
import it.krkn.services.organization.model.Organization;
import it.krkn.services.organization.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrganizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	OrganizationRepository repository;
	@Autowired
	DepartmentClient departmentClient;
	@Autowired
	EmployeeClient employeeClient;
	
	@PostMapping
	public Organization add(@RequestBody Organization organization) {
		LOGGER.info("Organization add: {}", organization);
		return repository.save(organization);
	}
	
	@GetMapping
	public Iterable<Organization> findAll() {
		LOGGER.info("Organization find");
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Organization findById(@PathVariable("id") String id) {
		LOGGER.info("Organization find: id={}", id);
		return repository.findById(id).get();
	}

	@GetMapping("/{id}/with-departments")
	public Organization findByIdWithDepartments(@PathVariable("id") String id) {
		LOGGER.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		if (organization.isPresent()) {
			Organization o = organization.get();
			o.setDepartments(departmentClient.findByOrganization(o.getId()));
			return o;
		} else {
			return null;
		}
	}
	
	@GetMapping("/{id}/with-departments-and-employees")
	public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") String id) {
		LOGGER.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		organization.ifPresent(org -> org.setDepartments(departmentClient.findByOrganizationWithEmployees(org.getId())));
		return organization.orElse(null);
	}
	
	@GetMapping("/{id}/with-employees")
	public Organization findByIdWithEmployees(@PathVariable("id") String id) {
		LOGGER.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		if (organization.isPresent()) {
			Organization o = organization.get();
			o.setEmployees(employeeClient.findByOrganization(o.getId()));
			return o;
		} else {
			return null;
		}
	}
	
}
