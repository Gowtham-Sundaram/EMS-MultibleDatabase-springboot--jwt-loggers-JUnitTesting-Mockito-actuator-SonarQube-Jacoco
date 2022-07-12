package com.accent.employeemanagementsystem.departmentrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accent.employeemanagementsystem.deptentitydao.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {
}


