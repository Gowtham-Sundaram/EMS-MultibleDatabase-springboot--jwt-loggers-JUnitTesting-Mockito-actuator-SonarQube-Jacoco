package com.accent.employeemanagementsystem;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accent.employeemanagementsystem.beandto.Department;
import com.accent.employeemanagementsystem.beandto.Employee;
import com.accent.employeemanagementsystem.controller.EmployeeManagementController;
import com.accent.employeemanagementsystem.departmentrepository.DepartmentRepository;
import com.accent.employeemanagementsystem.deptentitydao.DepartmentEntity;
import com.accent.employeemanagementsystem.empentitydao.EmployeeEntity;
import com.accent.employeemanagementsystem.employeerepository.EmployeeRepository;
import com.accent.employeemanagementsystem.employemanagementeservice.EmployeeManagementService;

//@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class EmployeemanagementsystemApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private DepartmentRepository departmentRepository;

	@InjectMocks
	private EmployeeManagementService employeeManagementService;

	@Autowired
	private EmployeeManagementController employeeManagementController;

	Employee employee;
	Department department;

	@BeforeAll
	public static void empCreation() {
		System.out.println("Before all Test Ok");
	}

	@BeforeEach
	public void returnEmp() {
		employee = new Employee();
		employee.setEmpName("Gowtham");
		employee.setMobileNo(Long.parseLong("9944751745"));
		employee.setMailId("gowtham@gmail.com");
		employee.setDeptId(1);
		department = new Department();
		department.setDeptName("LPDC");
		department = new Department();
		department.setDeptName("LPDC");
	}

	@Test
	@Order(1)
	public void empSaveTest() {
		Assertions.assertEquals(1, employeeManagementController.saveEmployee(employee).getBody().getDeptId());
	}

	@Test
	@Order(2)
	public void empFetchTest() {
		Assertions.assertEquals("Gowtham", employeeManagementController.fetchEmpById(1).getBody().getEmpName());
	}

	@Test
	@Order(3)
	public void empUpdateTest() {
		Employee employee1 = new Employee("Test", Long.parseLong("987654321"), "g@gmail.com", 1);
		Assertions.assertEquals("Test", employeeManagementController.updateEmp(1, employee1).getBody().getEmpName());
	}

	@Test
	@Order(4)
	public void empDeleteTest() {
		Assertions.assertEquals("Employee Successfully Deleted", employeeManagementController.deleteEmp(1));
	}

	@Test
	@Order(5)
	public void deptSaveTest() {
		Assertions.assertEquals(1, employeeManagementController.saveDepartment(department).getBody().getDeptId());
	}

	@Test
	@Order(6)
	public void deptFetchTest() {
		Assertions.assertEquals("LPDC", employeeManagementController.fetchDeptById(1).getBody().getDeptName());
	}

	@Test
	@Order(7)

	public void deptUpdateTest() {
		Department department1 = new Department("Test");
		Assertions.assertEquals("Test",
				employeeManagementController.updateDept(1, department1).getBody().getDeptName());
	}

	@Test
	@Order(8)
	public void deptDeleteTest() {
		Assertions.assertEquals("Department Successfully Deleted", employeeManagementController.deleteDept(1));
	}

	@Test
	public void getAllEmployee() {
		when(employeeRepository.findAll()).thenReturn(Stream
				.of(new EmployeeEntity(1, "Gowtham", Long.parseLong("9944751745"), "gowtham@gmail.com", 1),
						new EmployeeEntity(2, "Jack", Long.parseLong("9876543210"), "jack@gmail.com", 1))
				.collect(Collectors.toList()));
		Assertions.assertEquals(2, employeeManagementService.fetchAllEmp().size());
	}

	@Test
	public void getAllDept() {
		when(departmentRepository.findAll()).thenReturn(Stream.of(new DepartmentEntity(1, "HPDC"),
				new DepartmentEntity(1, "LPDC"), new DepartmentEntity(1, "Machine Shop")).collect(Collectors.toList()));
		Assertions.assertEquals(3, employeeManagementService.fetchAllDept().size());
	}

	@AfterEach
	public void closeResource() {
		employee = null;
		department = null;
	}

	@AfterAll
	public static void empClose() {
		System.out.println("After all Test Ok");
	}
}
