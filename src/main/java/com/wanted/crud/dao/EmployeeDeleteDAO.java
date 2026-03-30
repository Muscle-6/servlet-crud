package com.wanted.crud.dao;

import com.wanted.crud.global.JDBCTemplate;
import java.sql.*;

public class EmployeeDeleteDAO {

    public boolean delete(int empId) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empId);
            return pstmt.executeUpdate() > 0;

        } finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
    }
}