package com.accent.employeemanagementsystem.beandto;




/*@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor*/

public class Employee {
    private String empName;
    private Long mobileNo;
    private String mailId;
    private Integer deptId;

    public Employee() {
    }

    public Employee(String empName, Long mobileNo, String mailId, Integer deptId) {
        this.empName = empName;
        this.mobileNo = mobileNo;
        this.mailId = mailId;
        this.deptId = deptId;
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
