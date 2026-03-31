package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeUpdateDTO;
import com.wanted.crud.global.JDBCTemplate; // 자원 반납을 위해 임포트

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeUpdateDAO {

    public EmployeeUpdateDTO selectEmployeeById(Connection conn, String empId) {
        EmployeeUpdateDTO employee = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT EMP_ID, EMP_NAME, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SALARY, HIRE_DATE, ENT_YN FROM EMPLOYEE WHERE EMP_ID = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                employee = new EmployeeUpdateDTO();
                employee.setEmpId(rs.getString("EMP_ID"));
                employee.setEmpName(rs.getString("EMP_NAME"));
                employee.setEmail(rs.getString("EMAIL"));
                employee.setPhone(rs.getString("PHONE"));
                employee.setDeptCode(rs.getString("DEPT_CODE"));
                employee.setJobCode(rs.getString("JOB_CODE"));
                employee.setSalary(rs.getInt("SALARY"));
                employee.setHireDate(rs.getDate("HIRE_DATE"));
                employee.setEntYn(rs.getString("ENT_YN"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ResultSet과 PreparedStatement 반납
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        return employee;
    }

    public int updateEmployee(Connection conn, EmployeeUpdateDTO dto) {
        int result = 0;
        PreparedStatement pstmt = null;

        String sql = "UPDATE EMPLOYEE SET EMAIL = ?, PHONE = ?, DEPT_CODE = ?, JOB_CODE = ?, SALARY = ?, HIRE_DATE = ?, ENT_YN = ? WHERE EMP_ID = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getEmail());
            pstmt.setString(2, dto.getPhone());
            pstmt.setString(3, dto.getDeptCode());
            pstmt.setString(4, dto.getJobCode());
            pstmt.setInt(5, dto.getSalary());
            pstmt.setDate(6, dto.getHireDate());
            pstmt.setString(7, dto.getEntYn());
            pstmt.setString(8, dto.getEmpId());

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // PreparedStatement 반납
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
}