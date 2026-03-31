package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeRegisterRequestDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRegistDAO {

    public int register(Connection conn, EmployeeRegisterRequestDTO requestDTO) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, HIRE_DATE, ENT_YN) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(query);

            pstmt.setLong(1, requestDTO.getEmpId());
            pstmt.setString(2, requestDTO.getEmpName());
            pstmt.setString(3, "000000-0000000"); // EMP_NO 가짜 데이터 오호이야!
            pstmt.setString(4, requestDTO.getEmail());
            pstmt.setString(5, requestDTO.getPhone());
            pstmt.setString(6, requestDTO.getDeptCode());
            pstmt.setString(7, requestDTO.getJobCode());

            // [추가!] SAL_LEVEL에 기본값을 넣어준다 오호이야!
            pstmt.setString(8, "S6"); // 8번에 급여 등급 기본값 주입!

            pstmt.setLong(9, requestDTO.getSalary());     // 9번으로 밀림
            pstmt.setString(10, requestDTO.getHireDate()); // 10번으로 밀림
            pstmt.setString(11, requestDTO.getEntYn());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
}
