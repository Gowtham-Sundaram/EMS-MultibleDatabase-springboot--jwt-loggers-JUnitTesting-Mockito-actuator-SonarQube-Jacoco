package com.accent.employeemanagementsystem.beandto;




/*@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor*/
public class Department {
	private String deptName;

	public Department() {
	}

	public Department(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
