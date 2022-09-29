package com.mescobar.departament;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.util.Assert;

import com.mescobar.departament.model.Department;
import com.mescobar.departament.repository.DepartmentRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DepartmentServiceApplicationTests {

	private static final DepartmentRepository repository = new DepartmentRepository();

	@Test
	public void testAddDepartment() {
		Department department = new Department(1L, "Test");
		department = repository.add(department);
		Assert.notNull(department, "Department is null.");
		Assert.isTrue(department.getId() == 1L, "Department bad id.");
	}

	@Test
	public void testFindAll() {
		List<Department> departments = repository.findAll();
		Assert.isTrue(departments.size() == 1, "Departments size is wrong.");
		Assert.isTrue(departments.get(0).getId() == 1L, "Department bad id.");
	}

	@Test
	public void testFindByOrganization() {
		List<Department> departments = repository.findByOrganization(1L);
		Assert.isTrue(departments.size() == 1, "Departments size is wrong.");
		Assert.isTrue(departments.get(0).getId() == 1L, "Department bad id.");
	}

	@Test
	public void testFindById() {
		Department department = repository.findById(1L);
		Assert.notNull(department, "Department not found.");
		Assert.isTrue(department.getId() == 1L, "Department bad id.");
	}

}
