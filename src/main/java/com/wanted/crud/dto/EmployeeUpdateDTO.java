package com.wanted.crud.dto;

import java.sql.Date;

public class EmployeeUpdateDTO {
    // 요구사항에 있는 사원 정보 항목들
    private String empId;      // 사번 (수정불가지만 누구를 수정할지 찾기 위해 필요)
    private String empName;    // 사원명 (수정불가지만 화면에 보여주기 위해 필요)
    private String email;      // 이메일
    private String phone;      // 전화번호
    private String deptCode;   // 부서코드
    private String jobCode;    // 직급코드
    private int salary;        // 급여
    private Date hireDate;     // 입사일
    private String entYn;      // 퇴직여부

    // 기본 생성자
    public EmployeeUpdateDTO() {}

    // Getter와 Setter (Alt + Insert 또는 우클릭 -> Generate로 자동 생성하셔도 됩니다)
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDeptCode() { return deptCode; }
    public void setDeptCode(String deptCode) { this.deptCode = deptCode; }

    public String getJobCode() { return jobCode; }
    public void setJobCode(String jobCode) { this.jobCode = jobCode; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public String getEntYn() { return entYn; }
    public void setEntYn(String entYn) { this.entYn = entYn; }
}