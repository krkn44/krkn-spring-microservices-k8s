package it.krkn.services.organization.controller;

import it.krkn.services.organization.client.DepartmentClient;
import it.krkn.services.organization.client.EmployeeClient;
import it.krkn.services.organization.model.entity.Organization;
import it.krkn.services.organization.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrganizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

	private OrganizationRepository repository;
	private DepartmentClient departmentClient;
	private EmployeeClient employeeClient;

	public OrganizationController(OrganizationRepository repository, DepartmentClient departmentClient, EmployeeClient employeeClient) {
		this.repository = repository;
		this.departmentClient = departmentClient;
		this.employeeClient = employeeClient;
	}

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
	public Organization findById(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		return repository.findById(id).orElse(null);
	}

	@GetMapping("/{id}/with-departments")
	public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		organization.ifPresent(o -> o.setDepartments(departmentClient.findByOrganization(o.getId())));
		return organization.orElse(null);
	}
	
	@GetMapping("/{id}/with-departments-and-employees")
	public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		organization.ifPresent(org -> org.setDepartments(departmentClient.findByOrganizationWithEmployees(org.getId())));
		return organization.orElse(null);
	}
	
	@GetMapping("/{id}/with-employees")
	public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		organization.ifPresent(o -> o.setEmployees(employeeClient.findByOrganization(o.getId())));
		return organization.orElse(null);
	}
	
}
