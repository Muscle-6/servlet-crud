package com.wanted.crud.dto;

public class EmployeeRegisterRequestDTO {

    private Long empId;
    private String empName;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private Long salary;
    private String hireDate;
    private String entYn;

    public EmployeeRegisterRequestDTO(Long empId, String empName, String email, String phone, String deptCode, String jobCode, Long salary, String hireDate, String entYn) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.phone = phone;
        this.deptCode = deptCode;
        this.jobCode = jobCode;
        this.salary = salary;
        this.hireDate = hireDate;
        this.entYn = entYn;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getEntYn() {
        return entYn;
    }

    public void setEntYn(String entYn) {
        this.entYn = entYn;
    }

    @Override
    public String toString() {
        return "EmployeeRegisterRequestDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", salary=" + salary +
                ", hireDate='" + hireDate + '\'' +
                ", entYn='" + entYn + '\'' +
                '}';
    }
}
