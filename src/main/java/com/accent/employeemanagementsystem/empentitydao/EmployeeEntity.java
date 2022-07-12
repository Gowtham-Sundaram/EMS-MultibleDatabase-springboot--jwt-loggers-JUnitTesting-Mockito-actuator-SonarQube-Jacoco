package com.accent.employeemanagementsystem.empentitydao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "employee")
/*
 * @Getter
 * 
 * @Setter
 * 
 * @Builder
 */
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String empName;
	private Long mobileNo;
	private String mailId;
	private Integer deptId;

	public EmployeeEntity() {
	}

	public EmployeeEntity(Integer empId, String empName, Long mobileNo, String mailId, Integer deptId) {
		this.empId = empId;
		this.empName = empName;
		this.mobileNo = mobileNo;
		this.mailId = mailId;
		this.deptId = deptId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

}
