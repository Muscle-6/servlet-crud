package com.wanted.crud.dto;

public class EmployeeListDTO {

    private int empId;
    private String empName;
    private String email;
    private String phone;
    private String deptTitle;
    private String jobName;
    private double salary;
    private String entYn;

    public EmployeeListDTO(int empId, String empName, String email, String phone, String deptTitle, String jobName, double salary, String entYn) {
        this.empId=empId;
        this.empName=empName;
        this.email=email;
        this.phone=phone;
        this.deptTitle=deptTitle;
        this.jobName=jobName;
        this.salary=salary;
        this.entYn=entYn;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
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

    public String getDeptTitle() {
        return deptTitle;
    }

    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRetireYn() {
        return entYn;
    }

    public void setRetireYn(String retireYn) {
        this.entYn = entYn;
    }
}
