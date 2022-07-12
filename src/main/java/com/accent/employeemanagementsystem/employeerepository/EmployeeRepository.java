package com.accent.employeemanagementsystem.employeerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accent.employeemanagementsystem.empentitydao.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
}
