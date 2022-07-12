package com.accent.employeemanagementsystem.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.accent.employeemanagementsystem.beandto.Department;
import com.accent.employeemanagementsystem.beandto.Employee;
import com.accent.employeemanagementsystem.deptentitydao.DepartmentEntity;
import com.accent.employeemanagementsystem.empentitydao.EmployeeEntity;
import com.accent.employeemanagementsystem.employemanagementeservice.EmployeeManagementService;
import com.accent.employeemanagementsystem.jwtconfig.JwtUtil;
import com.accent.employeemanagementsystem.jwtuserentitydao.AuthRequest;

import java.util.List;

import org.slf4j.Logger;

@RestController
public class EmployeeManagementController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private EmployeeManagementService employeeManagementService;

	Logger logger = LoggerFactory.getLogger(EmployeeManagementController.class);

	@GetMapping("/")
	public String welcome() {
		return "Welcome!";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
			logger.info("Logged in User: {}", authRequest.getUserName());
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

	@PostMapping("/saveEmp")
	public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody Employee employee) {
		return employeeManagementService.saveEmployee(employee);
	}

	@GetMapping("/getEmp/{id}")
	public ResponseEntity<EmployeeEntity> fetchEmpById(@PathVariable("id") Integer empId) {
		return employeeManagementService.fetchEmpById(empId);
	}

	@DeleteMapping("/deleteEmp/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteEmp(@PathVariable("id") Integer empId) {
		return employeeManagementService.deleteEmp(empId);
	}

	@GetMapping("/fetchAllEmp")
	public List<EmployeeEntity> fetchAllEmp() {
		return employeeManagementService.fetchAllEmp();
	}

	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<EmployeeEntity> updateEmp(@PathVariable("id") Integer empId, @RequestBody Employee employee) {
		return employeeManagementService.updateEmp(empId, employee);
	}

	@PostMapping("/saveDept")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<DepartmentEntity> saveDepartment(@RequestBody Department department) {
		return employeeManagementService.saveDepartment(department);
	}

	@GetMapping("/getDept/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<DepartmentEntity> fetchDeptById(@PathVariable("id") Integer deptId) {
		return employeeManagementService.fetchDeptById(deptId);
	}

	@DeleteMapping("/deleteDept/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteDept(@PathVariable("id") Integer deptId) {
		return employeeManagementService.deleteDept(deptId);
	}

	@GetMapping("/fetchAllDept")
	public List<DepartmentEntity> fetchAllDept() {
		return employeeManagementService.fetchAllDept();
	}

	@PutMapping("/updateDept/{id}")
	public ResponseEntity<DepartmentEntity> updateDept(@PathVariable("id") Integer deptId,
			@RequestBody Department department) {
		return employeeManagementService.updateDept(deptId, department);
	}

}
