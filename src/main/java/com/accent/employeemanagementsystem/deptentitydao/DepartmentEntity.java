package com.accent.employeemanagementsystem.deptentitydao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "department")
/*
 * @Getter
 * 
 * @Setter
 */
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer deptId;
    private String deptName;
    
	public DepartmentEntity() {
	}
	
	public DepartmentEntity(Integer deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
    
}

