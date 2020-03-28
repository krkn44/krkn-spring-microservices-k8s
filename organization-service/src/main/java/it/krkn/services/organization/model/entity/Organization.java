package it.krkn.services.organization.model.entity;

import it.krkn.services.organization.model.dto.Department;
import it.krkn.services.organization.model.dto.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORGANIZATION_INFO")
public class Organization extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Transient
    private List<Department> departments = new ArrayList<>();

    @Transient
    private List<Employee> employees = new ArrayList<>();

    public Organization() {

    }

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

	@Override
	public String toString() {
		return "Organization{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", departments=" + departments +
				", employees=" + employees +
				'}';
	}
}
