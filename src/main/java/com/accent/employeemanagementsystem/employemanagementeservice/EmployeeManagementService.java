package com.accent.employeemanagementsystem.employemanagementeservice;

import com.accent.employeemanagementsystem.beandto.Department;
import com.accent.employeemanagementsystem.beandto.Employee;
import com.accent.employeemanagementsystem.departmentrepository.DepartmentRepository;
import com.accent.employeemanagementsystem.deptentitydao.DepartmentEntity;
import com.accent.employeemanagementsystem.empentitydao.EmployeeEntity;
import com.accent.employeemanagementsystem.employeerepository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeManagementService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	Logger logger = LoggerFactory.getLogger(EmployeeManagementService.class);

	private static String dateInfo() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}

	List<Integer> list;
	List<EmployeeEntity> empList;
	List<DepartmentEntity> deptList;

	public ResponseEntity<EmployeeEntity> saveEmployee(Employee employee) {
		if (employee != null) {
			EmployeeEntity employeeEntity = new EmployeeEntity();
			BeanUtils.copyProperties(employee, employeeEntity);
			try {
				employeeEntity = employeeRepository.save(employeeEntity);
				logger.info("Employee name {} saved @ {}", employeeEntity.getEmpName(), dateInfo());
				return new ResponseEntity<EmployeeEntity>(employeeEntity, HttpStatus.CREATED);
			} catch (Exception ex) {
				logger.error("Unable to save user @ {} error occured saveEmployee in service", dateInfo());
				return null;
			}
		} else
			logger.error("Employee creation failed @ {}", dateInfo());
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<EmployeeEntity> fetchEmpById(Integer empId) {
		list = new ArrayList<>();
		list.add(empId);
		if (employeeRepository.findAllById(list).isEmpty()) {
			logger.warn("Wrong empId {} entered to access @ {}", empId, dateInfo());
			list.clear();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("empId {} is accessed @ {}", empId, dateInfo());
			ResponseEntity<EmployeeEntity> responseEntity = new ResponseEntity<EmployeeEntity>(
					(EmployeeEntity) employeeRepository.findAllById(list).get(0), HttpStatus.FOUND);
			list.clear();
			return responseEntity;
		}
	}

	public String deleteEmp(Integer empId) {
		list = new ArrayList<>();
		list.add(empId);
		if (employeeRepository.findAllById(list).isEmpty()) {
			logger.warn("empId {} is not found to delete @ {}", empId, dateInfo());
			list.clear();
			return "Employee Not Found";
		} else {
			employeeRepository.deleteById(empId);
			logger.info("empId {} is deleted successfully @ {}", empId, dateInfo());
			list.clear();
			return "Employee Successfully Deleted";
		}
	}

	public List<EmployeeEntity> fetchAllEmp() {
		empList = employeeRepository.findAll();
		logger.info("All employees are fetched @ {}", dateInfo());
		return empList;
	}

	public ResponseEntity<EmployeeEntity> updateEmp(Integer empId, Employee employee) {
		list = new ArrayList<>();
		list.add(empId);
		if (employeeRepository.findAllById(list).isEmpty()) {
			logger.info("Employee name {} is not found to update @ {}", employee.getEmpName(), dateInfo());
			list.clear();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			EmployeeEntity existingEmployee = (EmployeeEntity) employeeRepository.findAllById(list).get(0);
			BeanUtils.copyProperties(employee, existingEmployee);
			try {
				existingEmployee = employeeRepository.save(existingEmployee);
				logger.info("Employee name {} is updated @ {}", existingEmployee.getEmpName(), dateInfo());
				ResponseEntity<EmployeeEntity> responseEntity = new ResponseEntity<EmployeeEntity>(existingEmployee,
						HttpStatus.CREATED);
				list.clear();
				return responseEntity;
			} catch (Exception ex) {
				logger.error("Unable to Update user @ {} error occured updateEmployee in service", dateInfo());
				list.clear();
				return null;
			}
		}
	}

	public ResponseEntity<DepartmentEntity> saveDepartment(Department department) {
		if (department != null) {
			DepartmentEntity departmentEntity = new DepartmentEntity();
			BeanUtils.copyProperties(department, departmentEntity);
			try {
				departmentEntity = departmentRepository.save(departmentEntity);
				logger.info("Department name {} saved @ {}", departmentEntity.getDeptName(), dateInfo());
				return new ResponseEntity<DepartmentEntity>(departmentEntity, HttpStatus.CREATED);
			} catch (Exception ex) {
				logger.error("Unable to save department @ {} error occured saveDepartment in service", dateInfo());
				return null;
			}
		} else {
			logger.error("Department creation failed @ {}", dateInfo());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<DepartmentEntity> fetchDeptById(Integer deptId) {
		list = new ArrayList<>();
		list.add(deptId);
		if (departmentRepository.findAllById(list).isEmpty()) {
			logger.warn("Wrong deptId {} entered to access @ {}", deptId, dateInfo());
			list.clear();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("deptId {} is accessed @ {}", deptId, dateInfo());
			ResponseEntity<DepartmentEntity> responseEntity = new ResponseEntity<DepartmentEntity>(
					(DepartmentEntity) departmentRepository.findAllById(list).get(0), HttpStatus.FOUND);
			list.clear();
			return responseEntity;
		}
	}

	public String deleteDept(Integer deptId) {
		list = new ArrayList<>();
		list.add(deptId);
		if (departmentRepository.findAllById(list).isEmpty()) {
			logger.warn("deptId {} is not found to delete @ {}", deptId, dateInfo());
			list.clear();
			return "Department Not Found";
		} else {
			departmentRepository.deleteById(deptId);
			logger.info("deptId {} is deleted successfully @ {}", deptId, dateInfo());
			list.clear();
			return "Department Successfully Deleted";
		}
	}

	public List<DepartmentEntity> fetchAllDept() {
		deptList = departmentRepository.findAll();
		logger.info("All Departments are fetched @ {}", dateInfo());
		return deptList;
	}

	public ResponseEntity<DepartmentEntity> updateDept(Integer deptId, Department department) {
		list = new ArrayList<>();
		list.add(deptId);
		if (departmentRepository.findAllById(list).isEmpty()) {
			logger.info("Department name {} is not found to update @ {}", department.getDeptName(), dateInfo());
			list.clear();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			DepartmentEntity existingDepartment = (DepartmentEntity) departmentRepository.findAllById(list).get(0);
			BeanUtils.copyProperties(department, existingDepartment);
			try {
				existingDepartment = departmentRepository.save(existingDepartment);
				logger.info("Department name {} is updated @ {}", department.getDeptName(), dateInfo());
				ResponseEntity<DepartmentEntity> responseEntity = new ResponseEntity<DepartmentEntity>(
						existingDepartment, HttpStatus.CREATED);
				list.clear();
				return responseEntity;
			} catch (Exception ex) {
				logger.error("Unable to update department @ {} error occured updateDepartment in service", dateInfo());
				list.clear();
				return null;
			}
		}
	}
}