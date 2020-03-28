package it.krkn.services.employee.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_INFO")
public class Employee extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ORGANIZATION_ID")
	private Long organizationId;

	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private int age;

	@Column(name = "POSITION")
	private String position;

	public Employee() {

	}
	
	public Employee(Long organizationId, Long departmentId, String name, int age, String position) {
		this.organizationId = organizationId;
		this.departmentId = departmentId;
		this.name = name;
		this.age = age;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long aLong) {
		this.id = id;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", organizationId=" + organizationId +
				", departmentId=" + departmentId +
				", name='" + name + '\'' +
				", age=" + age +
				", position='" + position + '\'' +
				'}';
	}
}
