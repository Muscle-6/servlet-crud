package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.wanted.crud.global.JDBCTemplate.close;

public class EmployeeDAO {

    public EmployeeDTO selectEmployeeById(Connection con, String empId) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        EmployeeDTO employee = null;

        String sql = """
                SELECT
                    e.EMP_ID,
                    e.EMP_NAME,
                    e.EMAIL,
                    e.PHONE,
                    e.DEPT_CODE,
                    d.DEPT_TITLE,
                    e.JOB_CODE,
                    j.JOB_NAME,
                    e.SALARY,
                    e.HIRE_DATE,
                    e.ENT_YN
                FROM EMPLOYEE e
                LEFT JOIN DEPARTMENT d ON e.DEPT_CODE = d.DEPT_ID
                LEFT JOIN JOB j ON e.JOB_CODE = j.JOB_CODE
                WHERE e.EMP_ID = ?
                """;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, empId);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                employee = new EmployeeDTO();
                employee.setEmpId(rset.getString("EMP_ID"));
                employee.setEmpName(rset.getString("EMP_NAME"));
                employee.setEmail(rset.getString("EMAIL"));
                employee.setPhone(rset.getString("PHONE"));
                employee.setDeptCode(rset.getString("DEPT_CODE"));
                employee.setDeptTitle(rset.getString("DEPT_TITLE"));
                employee.setJobCode(rset.getString("JOB_CODE"));
                employee.setJobName(rset.getString("JOB_NAME"));
                employee.setSalary(rset.getInt("SALARY"));
                employee.setHireDate(rset.getDate("HIRE_DATE"));
                employee.setEntYn(rset.getString("ENT_YN"));
            }

        } catch (Exception e) {
            throw new RuntimeException("사원 상세 조회 중 오류가 발생했습니다.", e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return employee;
    }
}